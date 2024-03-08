package main.java.project.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *  The Schedule class serves as the building block for a complete, MultiSchedule. Each generation of schedule instance
 *  is valid, independent, and can be combined to a MultiSchedule for verification.
 */
public class Schedule {

    private int balance;                    // Schedule balance factor
    private ArrayList<Integer> schedule;    // Array representation of schedule

    // Constant default schedules
    private final ArrayList<Integer> ARM6 = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 6, 7, 8, 9, 10}));
    private final ArrayList<Integer> ARM12 = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10}));
    private final ArrayList<Integer> ARM18 = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10}));
    private final ArrayList<Integer> ARM24 = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 9, 10}));

    /**
     * @param balance - balance factor, from list [6, 12, 18, 24]
     */
    public Schedule(int balance) {
        // Check balance good
        if (!((balance > 5) && (balance < 25) && (balance % 6 == 0))) {
            System.out.println(balance);
            throw new IllegalArgumentException("Invalid balance factor!");
        }
        
        // Store instance vars
        this.balance = balance;

        // Initialize schedule
        this.generate();
    }

    public ArrayList<Integer> shuffle() {
        ArrayList<Integer> toShuffle;

        // Populate toShuffle corresponding to balance factor
        if (this.balance == 6) {
            toShuffle = new ArrayList<Integer>(ARM6);
        } else if (this.balance == 12) {
            toShuffle = new ArrayList<Integer>(ARM12);
        } else if (this.balance == 18) {
            toShuffle = new ArrayList<Integer>(ARM18);
        } else {
            toShuffle = new ArrayList<Integer>(ARM24);
        }

        // Obtain random shuffle
        Collections.shuffle(toShuffle);

        return toShuffle;
    }

    /**
     * @param a - arm to flip
     * @return opposite arm
     */
    public int flip(int a) {
        switch(a) {
            case 5:
                return 8;
            case 6:
                return 9;
            case 7:
                return 10;
            case 8:
                return 5;
            case 9:
                return 6;
            case 10:
                return 7;
        }
        throw new IllegalStateException("Invalid flip");
    }

    /**
     * @param s - schedule array to check
     * @return True if schedule follows rule
     */
    public boolean isValid(ArrayList<Integer> s) {
        if (s == null) {
            throw new IllegalArgumentException("Schedule not generated");
        }

        for (int i = 0; i < s.size(); i++) {
            int curr = s.get(i);

            // Check opposite > 2 arms apart
            if ((i + 1 < s.size()) && (curr == flip((int) s.get(i + 1)))) {
                return false;
            }
            if ((i + 2 < s.size()) && (curr == flip((int) s.get(i + 2)))) {
                return false;
            }

            // Check same side < 4 consecutive
            if (i + 3 < s.size()) {
                if ((curr < 8) && (s.get(i + 1) < 8) && (s.get(i + 2) < 8) && (s.get(i + 3) < 8)) {
                    return false;
                }
                if ((curr > 7) && (s.get(i + 1) > 7) && (s.get(i + 2) > 7) && (s.get(i + 3) > 7)) {
                    return false;
                }
            }

            // Check no consecutive 5, 10
            if ((i + 1 < s.size()) && (curr == 5) && (s.get(i + 1) == 10)) {
                return false;
            }
            if ((i + 1 < s.size()) && (curr == 10) && (s.get(i + 1) == 5)) {
                return false;
            }
        }

        return true;
    }

    /**
     *  Generates a valid, new schedule
     */
    public void generate() {
        this.schedule = shuffle();
        while (!isValid(this.schedule)) {
            this.schedule = shuffle();
        }
    }

    /**
     * @return the balance of this schedule
     */
    public int getBalance() {
        return this.balance;
    }
    
    /**
     * @return the integer representation of this schedule
     */
    public ArrayList<Integer> getSchedule() {
        return this.schedule;
    }
}
