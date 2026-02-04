package e2.Fight;

import e2.Items.*;
import e2.Personajes.Character;
import e2.Personajes.Warrior;
import e2.Personajes.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testVictoria() {

        Character wizard = new Wizard("Mago electrico");
        Character warrior = new Warrior("Megacaballero");

        for (int i = 0; i < 10; i++)
        {
            wizard.getOfensiveItems().add(new FireBallSpell("bola de fuego"));
            wizard.getOfensiveItems().add(new Wand("varita"));
        }
        wizard.getDefensiveItems().add(new Armor("armadura"));

        for (int i = 0; i < 5; i++)
            warrior.getOfensiveItems().add(new Sword("espada"));

        warrior.getDefensiveItems().add((new Sword("espada")));
        warrior.getDefensiveItems().add((new Sword("espada")));
        warrior.getDefensiveItems().add((new Armor("armadura")));
        warrior.getDefensiveItems().add((new Armor("armadura")));


        Character winner = Game.winnerFromBattle(warrior, wizard);
        assertEquals(winner.getName(), "Mago electrico");
    }
}