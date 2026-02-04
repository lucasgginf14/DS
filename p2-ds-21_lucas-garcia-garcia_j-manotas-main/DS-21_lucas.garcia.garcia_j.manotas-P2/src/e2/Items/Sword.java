package e2.Items;

public class Sword extends Item implements Ofensive, Defensive {

    private final OfensiveBehaviour behaviour;

    public int getRemainingUses() {
        return behaviour.getRemainingUses();
    }

    public Sword(String name){
        super(name);
        behaviour = new OfensiveBehaviour(getUses());
    }
    @Override
    public int getMinStrength() {
        return 6;
    }

    @Override
    public int getUses() {
        return 10;
    }

    @Override
    public int getMinManaRequired() {
        return 1;
    }

    @Override
    public int attack() {
        behaviour.decreaseAttacks();
        return getDamage();
    }

    @Override
    public int getDamage() {
        return 6;
    }

    @Override
    public int getDefense() {
        return 4;
    }
}
