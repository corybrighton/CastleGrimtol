package com.company.CastleGrimtol.Models;

import java.util.List;
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
            List<Room> exits = currentRoom.getExits();
            Random random = new Random();
            currentRoom = exits.get(random.nextInt(exits.size()));
        }
        return currentRoom;
    }
}
