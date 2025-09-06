abstract class MagicalStructure {
    String structureName;
    int magicPower;

    MagicalStructure(String name, int magicPower) {
        this.structureName = name;
        this.magicPower = magicPower;
    }

    abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    @SuppressWarnings("unused")
    int spellCapacity;

    WizardTower() {
        super("Wizard Tower", 120);
        this.spellCapacity = 5;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts Fireball!");
    }
}

class EnchantedCastle extends MagicalStructure {
    @SuppressWarnings("unused")
    int defenseRating;

    EnchantedCastle() {
        super("Enchanted Castle", 80);
        this.defenseRating = 200;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " raises a magic shield!");
    }
}

class DragonLair extends MagicalStructure {
    String dragonType;

    DragonLair(String type) {
        super("Dragon Lair", 150);
        this.dragonType = type;
    }

    @Override
    void castMagicSpell() {
        System.out.println(dragonType + " breathes fire!");
    }
}

class KingdomManager {
    static String performMagicBattle(MagicalStructure a, MagicalStructure b) {
        return a.structureName + " vs " + b.structureName +
                " → Winner: " + (a.magicPower > b.magicPower ? a.structureName : b.structureName);
    }

    static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) total += s.magicPower;
        return total;
    }
}

public class KingdomBuilder {
    public static void main(String[] args) {
        MagicalStructure tower = new WizardTower();
        MagicalStructure castle = new EnchantedCastle();
        MagicalStructure lair = new DragonLair("Fire Dragon");

        MagicalStructure[] structures = {tower, castle, lair};

        System.out.println("Total Magic Power: " + KingdomManager.calculateKingdomMagicPower(structures));
        System.out.println(KingdomManager.performMagicBattle(tower, lair));

        tower.castMagicSpell();
        castle.castMagicSpell();
        lair.castMagicSpell();
    }
}
