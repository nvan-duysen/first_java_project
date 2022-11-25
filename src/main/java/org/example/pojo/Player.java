package org.example.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private ArrayList<Integer> coordinates;

    private HashMap<String, Integer> inventory;

    public Player() {
        ArrayList<Integer> newCoordinates = new ArrayList<>();
        newCoordinates.add(0);
        newCoordinates.add(0);

        this.coordinates = newCoordinates;

        this.inventory = new HashMap<String, Integer>(1);

        this.inventory.put("Herbe", 0);
    }

    public Player(ArrayList<Integer> coordinates, HashMap<String, Integer> inventory) {
        this.coordinates = coordinates;
        this.inventory = inventory;
    }

    public ArrayList<Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public HashMap getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }
}
