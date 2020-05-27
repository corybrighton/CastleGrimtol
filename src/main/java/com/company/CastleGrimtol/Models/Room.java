package com.company.CastleGrimtol.Models;

import com.company.CastleGrimtol.Interfaces.IRoom;

import java.util.*;

public class Room implements IRoom {

    private String name = null;
    private String description = null;
    private String helpDescription = null;
    private List<Item> items;
    private final HashMap<String, IRoom> exits;

    public Room(String name, String description, String helpDescription) {
        this.name = name;
        this.description = description;
        this.helpDescription = helpDescription;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getHelpDescription() {
        return helpDescription;
    }

    public boolean hasDoor(Door door) {
        return exits.containsKey(door.getName());
    }

    @Override
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    @Override
    public HashMap<String, IRoom> getExits() {
        return exits;
    }

    @Override
    public void setItem(Item item) {
        items.add(item);
    }

    @Override
    public Item takeItem(String item) {
        for (Item roomItem : items) {
            if(roomItem.getName().equalsIgnoreCase(item)){
                items.remove(roomItem);
                return roomItem;
            }
        }
        return null;
    }
}
