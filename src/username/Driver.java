/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Ethan
 * Last Updated: Joo
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
    private static final int MAXSIDES = 6;
    private static final int MAXDICE = 3;
    private static final int SCALEMULTI = 10;

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

        report(numDice, rollNumbers, findMax(rollNumbers));

    }

    /**
     * gets the integer input of the user
     * @return returns the numbers in an array
     */
    public static int[] getInput(){
        String input = SC.nextLine();
        String[] nums = input.split(" ");
        int[] ary = null;

        boolean allIntegers = false;

        while(!allIntegers){
            while (nums.length != 3) {
                System.out.println("There should only be 3 parameters that are all integers");
                input = SC.nextLine();
                nums = input.split(" ");
            }

            ary = new int[nums.length];

            try{
                int i = 0;
                for(String num : nums) {
                    ary[i] = Integer.parseInt(num);
                    i++;
                }

                if(ary[0] < MAXDICE + 1 && ary[1] < MAXSIDES + 1){
                    allIntegers = true;
                } else{
                    System.out.print("You can have no more than 3 ");
                    System.out.println("dice and a maximum of 6 sides per die");
                    input = SC.nextLine();
                    nums = input.split(" ");
                }

            } catch (NumberFormatException e) {
                System.out.println("please only input numbers");
                input = SC.nextLine();
                nums = input.split(" ");
            }
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

        int[] intList = new int[(dice.length * numSides) - (dice.length-1)];

        for(int x = 0; x < numRolls; x++){
            int total = 0;

            for(Die d: dice){
                d.roll();
                total += d.getCurrentValue();
            }

            intList[total-2]++;
        }

        return intList;

    }

    /**
     * returns the most common roll out of all possibilities
     * @param rolls number of rolls
     * @return returns an int of max value
     */
    public static int findMax(int[] rolls){
        int maxval = -1;
        int maxIndex = -1;

        for (int i = 0; i < rolls.length; i++){
            if(rolls[i] > maxval) {
                maxval = rolls[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * prints out main statistics of class
     * @param numDice number of dice
     * @param rollsData values of rolls
     * @param max max value in array
     */
    public static void report(int numDice, int[] rollsData, int max){
        double scale = (double) rollsData[max] / SCALEMULTI;
        System.out.println(scale);
        String tempStars;

        int currentNum = numDice;
        for (int i = 0; i < rollsData.length; i++){
            tempStars = "";

            for(int n = 0; n < rollsData[i] / scale; n++){
                tempStars += "*";

            }

            System.out.printf("%-2d: %-5d %s %n", currentNum, rollsData[i], tempStars);

            currentNum++;
        }
    }
}
