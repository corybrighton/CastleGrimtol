package com.company.CastleGrimtol.Models;


import com.company.CastleGrimtol.Interfaces.IPlayer;

import java.util.List;

public class Player extends Character implements IPlayer {

    public Player(String playerName) {
        super(playerName);
    }

    @Override
    public List<Item> getInventory() {
        return null;
    }

    @Override
    public void addInventory(Item item) {

    }
}
