package e2.Items;

public class OfensiveBehaviour {

    private int remainingUses;

    public int getRemainingUses() {
        return remainingUses;
    }

    public OfensiveBehaviour(int uses) {
        remainingUses = uses;
    }

    public void decreaseAttacks() {
        if (remainingUses == 0)
            throw new IllegalStateException("Objeto sin usos restantes");

        remainingUses--;
    }
}