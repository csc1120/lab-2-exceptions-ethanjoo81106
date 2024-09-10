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
     * Throws runtimeexception and displays message
     * @param errorMessage The message displayed as th eerror
     */
    public DieNotRolledException(String errorMessage){
        super(errorMessage);
    }
}
