package com.company.Models;

public class Character {
    private String playerName = null;
    private int health = 100;
    private Room currentRoom;

    public Character(String playerName) {
        this.playerName = playerName;
    }

    public void move(Door door) {
        if (currentRoom.hasDoor() && !door.isLocked()) {
            currentRoom = door.goThroughDoor(currentRoom);
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getHealth() {
        return health;
    }

    public void hit(int hitPoints) {
        this.health -= hitPoints;
    }

    public void heal(int healPoints) {
        this.health += healPoints;
    }
}
