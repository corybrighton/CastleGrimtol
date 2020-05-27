package com.company.CastleGrimtol.Interfaces;


import com.company.CastleGrimtol.Models.Item;
import java.util.List;

public interface IPlayer{

    String getName();
    List<Item> getInventory();
    String addInventory(Item item);
}
