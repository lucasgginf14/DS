package e2.Items;

public class Armor extends Item implements Defensive {

    public Armor(String name) {
        super(name);
    }

    @Override
    public int getDefense() {
        return 6;
    }

    @Override
    public int getMinStrength() {
        return 2;
    }
}