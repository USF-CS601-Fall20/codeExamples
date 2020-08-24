package javaBasics;

import java.util.ArrayList;
import java.util.List;

/** The driver class for the Game example */
public class GameExample {
    public static void main(String[] args) {

        Game game = new Game(3);
        List<Die> gameDice = game.getDice();
        System.out.println("Before: " + game);
        gameDice.clear(); // will not be allowed; will throw an exception
        // since the "good" getter returns unmodifiable read-only view of the list
        // If you change getDice to the "bad" one that breaks encapsulation, you can see what will happen
        System.out.println("After: " + game);

        // Set dice example
       /* List<Die> newArr = new ArrayList<>();
        Die die1 = new Die();
        die1.roll();
        Die die2 = new Die();
        die2.roll();
        newArr.add(die1);
        newArr.add(die2);
        System.out.println("newArr: " + die1 + " " + die2);
        game.setDice(newArr);
        newArr.clear();
        System.out.println("After:" + System.lineSeparator() +  "Game = " + game);
        */

    }
}
