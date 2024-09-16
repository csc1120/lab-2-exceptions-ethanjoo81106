/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Ethan
 * Last Updated: Joo
 */
package jooe;

import java.util.Random;

/**
 * The die object stores current value and number of sides
 */
public class Die {
    private int currentValue;
    private final int numSides;

    /**
     * Main constructor for die class
     * @param numSides input of # of sides
     */
    public Die(int numSides){
        currentValue = 0;
        this.numSides = numSides;
    }

    /**
     * returns the value of the die
     * @return currentValue of die
     * @throws DieNotRolledException throws an exception when die getCurrentValue was called
     * before roll was called
     */
    public int getCurrentValue(){
        if (currentValue == 0){
            throw new DieNotRolledException("Die has no not been rolled yet");
        }
        return currentValue;
    }

    /**
     * rolls the die to a random number
     */
    public void roll(){
        Random r = new Random();
        currentValue = r.nextInt(numSides) + 1;
    }


}