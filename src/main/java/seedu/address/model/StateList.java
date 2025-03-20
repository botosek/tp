package seedu.address.model;

import java.util.ArrayList;

/**
 * StateManager class that contains the states of TaskLists
 */
public class StateList {
    private static final ArrayList<AddressBook> states = new ArrayList<>();
    private static int currentState = 0;

    /**
     * Instantiate task list with old task list data loaded in.
     */
    public StateList() {
    }

    /**
     * Add a new state and move current state number forward by one.
     */
    public static void addState(AddressBook state) {
        while (states.size() > currentState) {
            states.remove(states.size() - 1);
        }

        StateList.states.add(new AddressBook(state));
        StateList.currentState++;
    }

    /**
     * Move current state number back by one
     */
    public static void undo() {
        if (currentState > 1) {
            currentState--;
        }
    }

    /**
     * Get the current state.
     */
    public static AddressBook getCurrentState() {
        return states.get(currentState - 1);
    }

    /**
     * Print all states and their respective task lists for debugging.
     */
    public static void printStates() {
        System.out.println("All States:");
        for (int i = 0; i < states.size(); i++) {
            System.out.println("------------------\n" + "State " + i + ":\n" + states.get(i).toString());
        }
        System.out.println("Current State Pointer: " + currentState);
    }
}

