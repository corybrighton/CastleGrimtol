package com.company.CastleGrimtol;


import com.company.CastleGrimtol.Interfaces.IGameService;
import com.company.CastleGrimtol.Models.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameService implements IGameService {
    List<String> inputs;
    String lastMove;
    GameMap gameMap;
    Player player;
    Room currentRoom;
    Random random = new Random();

    @Override
    public void Setup() {
        gameMap = new GameMap();
        player = new Player("Sir Han");
    }

    @Override
    public void Reset() {
        Setup();
    }

    @Override
    public void StartGame() {
        Setup();
    }

    @Override
    @GetMapping("/grimtol")
    public @ResponseBody
    Reply GetUserInput(@RequestParam String input) {
        if (gameMap == null) {
            StartGame();
        }
        if (inputs.size() > 0) {
            lastMove = "";
            for (String in : inputs) lastMove += in;
        }
        inputs = Arrays.asList(input.toLowerCase().split(" "));
        String output = "I don't know what you are trying to do.";

        if (inputs.contains("go")) {
            output = Go();
        } else if (inputs.contains("help")) {
            output = Help();
        } else if (inputs.contains("look")) {
            output = Look();
        } else if (inputs.contains("inventory")) {
            output = Inventory();
        } else if (inputs.contains("reset")) {
            Reset();
            output = "Starting new game.";
        } else if (inputs.contains("quit")) {
            output = Quit();
        }
        return new Reply(output);
    }

    @Override
    public String Quit() {
        return "End of Game. Good bye.";
    }

    @Override
    public String Help() {
        return "Tell me what you want to do, Go some where, Take something, " +
                "Look around, See what is in your Inventory, Maybe use something.";
    }

    @Override
    public String Go() {
        String[] directions = {"n", "north", "s", "south", "e", "east", "w", "west"};
        for (String d : directions) {
            if (inputs.contains(d))
                return d;
        }
        String[] unable = {"Unable to go that way.",
                "You want to go where?",
                "Did you look that way?",
                "As much fun as it is to watch you walk into to a wall, you might was to go a different way."};
        return unable[random.nextInt(unable.length)];
    }

    @Override
    public String TakeItem(String itemName) {
        Item item = currentRoom.takeItem(itemName);
        if (item == null) {
            String[] nothing = {
                    "Are you sure that is here?",
                    "Maybe look around and find something useful you can take.",
                    "You might have think that will be useful but it relay won't be."};
            return nothing[random.nextInt(nothing.length)];
        }
        if (!item.getTakable()) {
            String[] cant = {
                    "You can take that, what are you thinking?",
                    "That would break your back, just leave it there.",
                    "Nope.... just nope."};
            return cant[random.nextInt(cant.length)];
        }
        return "Cool a new " + itemName;
    }

    @Override
    public String UseItem(String itemName) {

        return itemName;
    }

    @Override
    public String Inventory() {
        StringBuilder inventory = new StringBuilder();
        if (player.getInventory().size() > 0)
            for (Item item : player.getInventory()) {
                inventory.append(item.getName()).append(" ");
            }
        return (inventory.length() == 0) ? "Nothing, you might want to find something, you know before you are killed" :
                inventory.toString();
    }

    @Override
    public String Look() {
        return currentRoom.getHelpDescription();
    }
}
