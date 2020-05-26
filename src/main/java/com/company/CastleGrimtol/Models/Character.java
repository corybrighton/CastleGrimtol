package com.company.CastleGrimtol.Models;

public class Character {
    private String name = null;
    private int health = 100;
    private Room currentRoom;

    public Character(String name) {
        this.name = name;
    }

    public void move(Door door) {
        if (currentRoom.hasDoor(door) && !door.isLocked()) {
            currentRoom = door.useDoor(currentRoom);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String hit(int hitPoints) {
        health = (health > hitPoints) ? health - hitPoints : 0;
        return name + " has been hit.";
    }

    public String heal(int healPoints) {
        this.health = (this.health > 0) ? healPoints + health : 0;
        return name + " has been healed.";
    }
}
