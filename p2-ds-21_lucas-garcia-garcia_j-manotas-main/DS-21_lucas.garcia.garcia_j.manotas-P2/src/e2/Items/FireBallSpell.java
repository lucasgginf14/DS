package e2.Items;

public class FireBallSpell extends Item implements Ofensive {

    private final OfensiveBehaviour behaviour;

    public int getRemainingUses() {
        return behaviour.getRemainingUses();
    }

    public FireBallSpell(String name){
        super(name);
        behaviour = new OfensiveBehaviour(getUses());
    }

    @Override
    public int getDamage() {
        return 7;
    }

    @Override
    public int getUses() {
        return 3;
    }

    @Override
    public int getMinManaRequired() {
        return 5;
    }

    @Override
    public int attack() {
        boolean lastUse = getRemainingUses() == 1;
        behaviour.decreaseAttacks();

        return getDamage() - (lastUse ? 1 : 0);
    }
}
