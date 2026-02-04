package e2;

import e2.Items.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Sword sword = new Sword("Excalibur");
    Wand wand = new Wand("Vara magica");
    FireBallSpell fireBall = new FireBallSpell("Fireball");
    Armor armor = new Armor("Armadura");

    @Test
    void testName() {
        assertEquals(sword.getCodeName(), "Excalibur");
        assertEquals(wand.getCodeName(), "Vara magica");
        assertEquals(fireBall.getCodeName(), "Fireball");
        assertEquals(armor.getCodeName(), "Armadura");
    }

    @Test
    void testType() {
        assertTrue(armor instanceof Defensive);
        assertFalse(armor instanceof Ofensive);

        assertTrue(sword instanceof Defensive);
        assertTrue(sword instanceof Ofensive);

        assertTrue(wand instanceof Defensive);
        assertTrue(wand instanceof Ofensive);

        assertFalse(fireBall instanceof Defensive);
        assertTrue(fireBall instanceof Ofensive);
    }

    @Test
    void testStats() {
        assertEquals(armor.getDefense(), 6);
        assertEquals(armor.getMinStrength(), 2);

        assertEquals(sword.getMinStrength(), 6);
        assertEquals(sword.getUses(), 10);
        assertEquals(sword.getMinManaRequired(), 1);
        assertEquals(sword.getDamage(), 6);
        assertEquals(sword.getDefense(), 4);

        assertEquals(wand.getMinStrength(), 4);
        assertEquals(wand.getUses(), 7);
        assertEquals(wand.getMinManaRequired(), 2);
        assertEquals(wand.getDamage(), 5);
        assertEquals(wand.getDefense(), 5);

        assertEquals(fireBall.getUses(), 3);
        assertEquals(fireBall.getMinManaRequired(), 5);
        assertEquals(fireBall.getDamage(), 7);
    }
}