package e2.Fight;

import e2.Items.Ofensive;
import e2.Personajes.Wizard;
import e2.Personajes.Character;
import e2.Personajes.Stat;
import e2.Personajes.Warrior;
import e2.Items.Item;

import java.util.ArrayList;

public class Game {

    public static void attack(Character attackant, Character defender) {

        ArrayList<Ofensive> ofensives = attackant.getOfensiveItems();
        Ofensive first = ofensives.get(0);
        Stat health = defender.getHealth();

        int damage = first.attack() - defender.getProtection();
        health.setValue(health.getValue() - damage);

        if (first.getUses() == 0)
            ofensives.remove(0);
    }

    public static Character winnerFromBattle(Character a, Character b) {

        // Pierde el primero en quedarse sin puntos de vida o quedarse sin objetos para atacar

        if (a.getHealth().getValue() <= 0 || a.getOfensiveItems().isEmpty())
            return a;

        attack(a, b);

        Character temp = a;
        a = b;
        b = temp;

        return winnerFromBattle(a, b);
    }
}