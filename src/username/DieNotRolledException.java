/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Ethan
 * Last Updated: Joo
 */
package username;

/**
 * Class to throw an exception
 */
public class DieNotRolledException extends RuntimeException {
    /**
     * Main constructor for exception
     * @param s input string for cusotm message
     */
    public DieNotRolledException(String s){
        super(s);
    }

}
