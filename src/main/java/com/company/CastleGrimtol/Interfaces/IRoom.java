package com.company.CastleGrimtol.Interfaces;


import com.company.CastleGrimtol.Models.Door;
import com.company.CastleGrimtol.Models.Item;
import com.company.CastleGrimtol.Models.Room;

import java.util.Map;

public interface IRoom {

    String getName();
    String getDescription();
    String getHelpDescription();
    boolean hasDoor(Door door);
    void setExit(String direction, Room room);
    Map<String, IRoom> getExits();
    void setItem(Item item);
    Item takeItem(String item);

}
