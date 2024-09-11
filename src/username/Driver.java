/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Ethan
 * Last Updated: FIX
 */
package username;

import java.util.Scanner;

/**
 * Main class of the program
 */
public class Driver {
    private static int numDice;
    private static int sidesPerDie;
    private static int rolls;
    private static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("please enter the # of dice, how many sides per die");
        System.out.println(", and the number of roles in the following format");
        System.out.println("(Dice) (Sides) (Rolls)");
        int[] die = getInput();
        numDice = die[0];
        sidesPerDie = die[1];
        rolls = die[2];

        Die[] dice = createDice(numDice, sidesPerDie);

        int[] rollNumbers = rollDice(dice, sidesPerDie, rolls);

        for(int num: rollNumbers){
            System.out.println(num);
        }


    }

    /**
     * gets the integer input of the user
     * @return returns the numbers in an array
     */
    public static int[] getInput(){
        String input = SC.nextLine();
        String[] nums = input.split(" ");

        while (nums.length != 3) {
            System.out.println("There should only be 3 parameters that are all integers");
            input = SC.nextLine();
            nums = input.split(" ");
        }

        int[] ary = new int[nums.length];

        try{
            int i = 0;
            for(String num : nums) {
                ary[i] = Integer.parseInt(num);
                i++;
            }
        } catch (NumberFormatException e) {
            System.out.println("please only input numbers");
        }

        return ary;
    }

    /**
     * returns an array of all dice object created in accordance to the parameters
     * @param numDice number of total dice
     * @param numSides number of sides per die
     * @return returns array of all dice object
     */
    public static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; i < numDice; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    /**
     * returns an array of integers for rolling each die
     * @param dice arraylist of dice
     * @param numSides number of sides per die
     * @param numRolls total number of rolls
     * @return returns array of int
     */
    public static int[] rollDice(Die[] dice, int numSides, int numRolls){

        int[] intList = new int[dice.length];

        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
            intList[i] = dice[i].getCurrentValue();
        }

        return intList;

        /*
        FIX THIS FUNCTION TMR
         */

    }

    /**
     * returns the most common roll out of all possibilities
     * @param rolls number of rolls
     * @return returns an int of max value
     */
    public static int findMax(int[] rolls){
        return 0;
    }

    /**
     * prints out main statistics of class
     * @param numDice number of dice
     * @param rolls values of rolls
     * @param max max value in array
     */
    public static void report(int numDice, int[] rolls, int max){

    }
}
