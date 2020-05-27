package com.company.CastleGrimtol.Models;

import com.company.CastleGrimtol.Interfaces.IRoom;

import java.util.HashMap;
import java.util.Random;

public class Monster extends Character {

    private final boolean movable;
    private Room currentRoom;

    public Monster(String name, boolean movable, Room currentRoom) {
        super(name);
        this.movable = movable;
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean sameRoom(Room playerCurrentRoom){
        return playerCurrentRoom.equals(currentRoom);
    }

    public Room moveRoom(){
        if (movable){
            HashMap<String, IRoom> exits = currentRoom.getExits();
            String[] keys = (String[]) exits.keySet().toArray();
            Random random = new Random();
            currentRoom = (Room) exits.get(keys[random.nextInt(keys.length)]);
        }
        return currentRoom;
    }
}
