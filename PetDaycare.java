import java.util.*;

class VirtualPet {
    final String petId;
    String petName, species;
    int age, happiness, health;
    String currentStage;
    boolean isGhost = false;

    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;

    static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    // Main constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.currentStage = stage;
        totalPetsCreated++;
    }

    // Overloaded constructors
    public VirtualPet() {
        this("Unknown", "RandomSpecies", 0, 50, 50, EVOLUTION_STAGES[0]);
    }
    public VirtualPet(String petName) {
        this(petName, "Mystery", 0, 60, 60, EVOLUTION_STAGES[1]);
    }
    public VirtualPet(String petName, String species) {
        this(petName, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }

    void evolvePet() {
        if (isGhost) return;
        int stageIndex = Math.min(age / 2, EVOLUTION_STAGES.length - 1);
        currentStage = EVOLUTION_STAGES[stageIndex];
    }

    void simulateDay() {
        if (isGhost) return;
        age++;
        health -= new Random().nextInt(15);
        happiness -= new Random().nextInt(10);
        if (health <= 0) {
            isGhost = true;
            currentStage = "Ghost";
        } else evolvePet();
    }

    String getPetStatus() {
        return petName + " (" + species + ") - Age: " + age +
                ", Health: " + health + ", Happiness: " + happiness +
                ", Stage: " + currentStage + (isGhost ? " 👻" : "");
    }
}

public class PetDaycare {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet(); // Egg
        VirtualPet pet2 = new VirtualPet("Fluffy"); // Baby
        VirtualPet pet3 = new VirtualPet("Sparky", "Dragon"); // Child

        VirtualPet[] pets = {pet1, pet2, pet3};

        for (int day = 1; day <= 3; day++) {
            System.out.println("\nDay " + day + " simulation:");
            for (VirtualPet pet : pets) {
                pet.simulateDay();
                System.out.println(pet.getPetStatus());
            }
        }
        System.out.println("\nTotal Pets Created: " + VirtualPet.totalPetsCreated);
    }
}
