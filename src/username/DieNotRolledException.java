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
     * returns the messgae of Die not rolling
     * @return returns the message
     */
    public String getMessage(){
        return "Die did not roll";
    }
}
