package com.company.CastleGrimtol.Models;

public class Door {

    private boolean isLocked = true;
    private boolean isHidden = false;
    private final String name;
    private final Room thisSide;
    private final Room otherSide;

    public Door(boolean isLocked, String name, boolean isHidden, Room thisSide, Room otherSide) {
        this.isLocked = isLocked;
        this.name = name;
        this.isHidden = isHidden;
        this.thisSide = thisSide;
        this.otherSide = otherSide;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean lockDoor() {
        isLocked = !isLocked;
        return isLocked;
    }

    public String getName() {
        return name;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden() {
        isHidden = false;
    }

    public Room useDoor(Room currentRoom) {
        setHidden();
        return (isLocked) ? currentRoom : (currentRoom.equals(thisSide)) ? otherSide : thisSide;
    }
}
