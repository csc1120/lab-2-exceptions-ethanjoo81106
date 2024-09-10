/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Ethan
 * Last Updated: Joo
 */
package username;

import java.util.Random;

/**
 * The die object stores current value and number of sides
 */
public class Die {
    private int currentValue;
    private final int numSides;
    private Random random;

    /**
     * Main constructor for die class
     * @param numSides input of # of sides
     */
    public Die(int numSides){
        this.numSides = numSides;
    }

    /**
     * returns the value of the die
     * @return currentValue of die
     */
    public int getCurrentValue(){
        return currentValue;
    }

    /**
     * rolls the die to a random number
     */
    public void roll(){
        currentValue = random.nextInt(numSides-1) + 1;
    }


}