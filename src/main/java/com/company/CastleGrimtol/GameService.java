package com.company.CastleGrimtol;


import com.company.CastleGrimtol.Interfaces.IGameService;
import com.company.CastleGrimtol.Models.Room;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameService implements IGameService {
    @Override
    public void Setup() {

    }

    @Override
    public void Reset() {

    }

    @Override
    public void StartGame() {
        Room study = new Room();
        study.setExits("North", new Room());
    }

    @Override
    @GetMapping("/grimtol")
    public @ResponseBody String GetUserInput(@RequestBody String input){
        return "New Game";
    }

    @Override
    public String Quit() {

        return null;
    }

    @Override
    public String Help() {

        return null;
    }

    @Override
    public String Go(String direction) {

        return direction;
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
