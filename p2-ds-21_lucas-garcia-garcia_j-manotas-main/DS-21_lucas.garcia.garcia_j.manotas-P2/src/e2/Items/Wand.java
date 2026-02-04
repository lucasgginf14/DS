package e2.Items;

public class Wand extends Item implements Ofensive, Defensive {

    private final OfensiveBehaviour behaviour;

    public int getRemainingUses() {
        return behaviour.getRemainingUses();
    }

    public Wand(String name){
        super(name);
        behaviour = new OfensiveBehaviour(getUses());
    }
    @Override
    public int getMinStrength() {
        return 4;
    }

    @Override
    public int getUses() {
        return 7;
    }

    @Override
    public int getMinManaRequired() {
        return 2;
    }

    @Override
    public int attack() {
        boolean firstAttack = getRemainingUses() == getUses();
        behaviour.decreaseAttacks();

        return getDamage() * (firstAttack ? 2 : 1);
    }

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public int getDefense() {
        return 5;
    }
}
