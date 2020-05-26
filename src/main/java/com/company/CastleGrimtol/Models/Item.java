package com.company.CastleGrimtol.Models;


import com.company.CastleGrimtol.Interfaces.IItem;

public class Item implements IItem {

    private final String name;
    private String description = null;
    private boolean takable = true;

    public Item(String name, String description, boolean takable) {
        this.name = name;
        this.description = description;
        this.takable = takable;
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
    public boolean getTakable() {
        return takable;
    }
}
