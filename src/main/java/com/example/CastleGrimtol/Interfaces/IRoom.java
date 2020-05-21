package com.company.Interfaces;

import com.company.Models.Item;

import java.util.List;
import java.util.Map;

public interface IRoom {
    String name = null;
    String description = null;
    List<Item> items = null;
    Map<String, IRoom> Exits = null;
}
