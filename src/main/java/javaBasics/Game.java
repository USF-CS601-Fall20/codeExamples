package javaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A class that represents some board game that requires several rolling dice */
public class Game {
    private List<Die> dice; // rolling dice

    /**
     * Creates a given number of dice and adds them to the ArrayList defined above
     * @param numberDice number of dice to create
     */
    public Game(int numberDice) {
        dice = new ArrayList<>();
        for (int i = 0; i < numberDice; i++) {
            Die currDie = new Die();
            currDie.roll();
            dice.add(currDie);
        }
    }


    /**
     * Play the game
     */
    public void play() {
        // Play some game where we need to roll dice
        // Not important for the point I am trying to make so left blank
    }

    /**
     * toString
     * @return a string representation of the game - for now, just contains face values of the dice
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dice.size(); i++) {
            Die currDie = dice.get(i);
            sb.append(currDie.toString() + System.lineSeparator());
        }
        return sb.toString();
    }


    /** This getter does not break encapsulation, because unmodifiableList will return
     * a "read-only" view of the ArrayList dice.
     * @return
     */
    public List<Die> getDice() {
        return Collections.unmodifiableList(dice);
    }

    public void setDice(List<Die> dice) {
        this.dice = new ArrayList<>();
        for (int i = 0; i < dice.size(); i++) {
            Die copyDie = new Die(dice.get(i));
            this.dice.add((copyDie));
        }
    }

    // The methods below break encapsulation!! Do NOT do it. Points taken off for this.
    /*
    public List<Die> getDice() {
        return this.dice;
    }
    public void setDice(List<Die> dice) { // How can we implement it instead?
        this.dice = dice;
    }
    */

}
