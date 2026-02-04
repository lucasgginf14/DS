package e2.Personajes;

import e2.Items.Armor;
import e2.Items.FireBallSpell;
import e2.Items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Warrior w = new Warrior("Guerrero");
    Wizard wi = new Wizard("Mago");

    @Test
    void test() {
        assertEquals(w.getName(), "Guerrero");
        assertEquals(wi.getName(), "Mago");

        assertEquals(w.getHealth().getValue(), 18);
        assertEquals(wi.getHealth().getValue(), 12);

        assertEquals(w.getMana().getValue(), 5);
        assertEquals(wi.getMana().getValue(), 10);

        assertEquals(w.getStrength().getValue(), 6);
        assertEquals(wi.getStrength().getValue(), 4);

        assertEquals(w.getProtection(), 0);
        assertEquals(wi.getProtection(), 0);

        w.equipeOfensiveItem(new FireBallSpell("Fireball"));
        w.equipeOfensiveItem(new Sword("Fireball"));
        w.equipeDefensiveItem(new Armor("Armadura"));

        assertEquals(w.getOfensiveItems().size(), 2);
        assertEquals(w.getDefensiveItems().size(), 1);
    }
}