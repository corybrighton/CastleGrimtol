package com.company.CastleGrimtol.Interfaces;


import com.company.CastleGrimtol.Models.Player;
import com.company.CastleGrimtol.Models.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IGameService {
    Room CurrentRoom = null;
    Player CurrentPlayer = null;

    //Initializes the game, creates rooms, their exits, and add items to rooms
    void Setup();

    //Restarts the game
    void Reset();

    //Setup and Starts the Game loop
    void StartGame();

    //Gets the user input and calls the appropriate command

    //#Console Commands ======================

    @GetMapping("/grimtol")
    @ResponseBody
    String GetUserInput(@RequestBody String input);

    //Stops the application
    String Quit();

    //Should display a list of commands to the console
    String Help();

    //Validate CurrentRoom.Exits contains the desired direction
    //if it does change the CurrentRoom
    String Go(String direction);

    //When taking an item be sure the item is in the current room
    //before adding it to the player inventory, Also don't forget to
    //remove the item from the room it was picked up in
    String TakeItem(String itemName);

    //No need to Pass a room since Items can only be used in the CurrentRoom
    //Make sure you validate the item is in the room or player inventory before
    //being able to use the item
    String UseItem(String itemName);

    //Print the list of items in the players inventory to the console
    String Inventory();

    //Display the CurrentRoom Description, Exits, and Items
    String Look();

    //============================================
}
