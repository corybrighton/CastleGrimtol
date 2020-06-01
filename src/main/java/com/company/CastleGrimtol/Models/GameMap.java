package com.company.CastleGrimtol.Models;

import java.util.ArrayList;

public class GameMap {
    private ArrayList rooms;

    //Rooms
    private final Room entrance = new Room("Entrance",
            "The ceiling is covered with bloodstains, and several pieces of rotten bread are scattered throughout the room",
            "The ceiling is covered with bloodstains, and several pieces of rotten bread are scattered throughout the room");

    //    private final Room

    //Monsters
    Monster drider = new Monster("Drider", true, entrance);

    public GameMap() {
        rooms = new ArrayList();
        rooms.add(entrance);
        entrance.setExit("west", entrance);
    }

//    public Room goToRoom(Room currentRoom){
//
//    }

}
