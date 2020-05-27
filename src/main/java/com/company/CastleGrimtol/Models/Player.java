package com.company.CastleGrimtol.Models;


import com.company.CastleGrimtol.Interfaces.IPlayer;

import java.util.ArrayList;

public class Player extends Character implements IPlayer {

    private final ArrayList<Item> inventory;

    public Player(String playerName) {
        super(playerName);
        inventory = new ArrayList<>();
    }

    @Override
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    @Override
    public String addInventory(Item item) {
        if (item.getTakable()) {
            inventory.add(item);
            return item.getName() + " added to inventory.";
        }
        return "Unable to take "+item.getName();
    }
}
