package e2.Personajes;

import e2.Items.Defensive;
import e2.Items.Item;
import e2.Items.Ofensive;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private final String name;
    public String getName() {
        return name;
    }

    private final Stat health = new Stat(0, 20);
    public Stat getHealth() {
        return health;
    }

    private final Stat strength = new Stat(1, 10);
    public Stat getStrength() {
        return strength;
    }

    private final Stat mana = new Stat(0, 10);
    public Stat getMana() {
        return mana;
    }

    private final int MAX_ITEMS = 5;
    private int protection = 0;
    public int getProtection() {
        return protection;
    }

    final ArrayList<Defensive> defensiveItems = new ArrayList<>();
    public ArrayList<Defensive> getDefensiveItems() {
        return defensiveItems;
    }

    final ArrayList<Ofensive> ofensiveItems = new ArrayList<>();
    public ArrayList<Ofensive> getOfensiveItems() {
        return ofensiveItems;
    }

    public Character(String name, int health, int strength, int mana){
        this.name = name;
        this.health.setValue(health);
        this.strength.setValue(strength);
        this.mana.setValue(mana);
    }

    public void equipeOfensiveItem(Ofensive item){
        if(ofensiveItems.size() == MAX_ITEMS)
            throw new IllegalArgumentException("Se ha excedido el maximo de items ofensivos");

        ofensiveItems.add(item);
    }

    public void equipeDefensiveItem(Defensive item){
        if(defensiveItems.size() == MAX_ITEMS)
            throw new IllegalArgumentException("Se ha excedido el maximo de items defensivos");

        defensiveItems.add(item);
        protection += item.getDefense();
    }
}