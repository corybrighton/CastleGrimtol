package com.company.CastleGrimtol;


import com.company.CastleGrimtol.Interfaces.IGameService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameService implements IGameService {
    List<String> inputs;

    @Override
    public void Setup() {

    }

    @Override
    public void Reset() {

    }

    @Override
    public void StartGame() {

    }

    @Override
    @GetMapping("/grimtol")
    public @ResponseBody
    String GetUserInput(@RequestParam String input) {
        inputs = Arrays.asList(input.toLowerCase().split(" "));
        String output = "I don't know what you are trying to do.";

        if (inputs.contains("go")) {
            output = Go();
        } else if (inputs.contains("quit")) {
            output = Quit();
        } else if (inputs.contains("help")) {
            output = Help();
        }
        return output;
    }

    @Override
    public String Quit() {
        return "End of Game. Good bye.";
    }

    @Override
    public String Help() {

        return null;
    }

    @Override
    public String Go() {
        String[] directions = {"n", "north", "s", "south", "e", "east", "w", "west"};
        for (String d: directions) {
            if(inputs.contains(d))
                return d;
        }
        return "Unable to go that way";
    }

    @Override
    public String TakeItem(String itemName) {

        return itemName;
    }

    @Override
    public String UseItem(String itemName) {

        return itemName;
    }

    @Override
    public String Inventory() {

        return null;
    }

    @Override
    public String Look() {

        return null;
    }
}
