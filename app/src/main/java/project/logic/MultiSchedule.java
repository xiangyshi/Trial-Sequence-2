package main.java.project.logic;

import java.util.ArrayList;


/**
 *  The MultiSchedule class is used to formulate complete schedules given a list of balance factors.
 *  Each balance factor represents a building block for MultiShedule to fit.
 */
public class MultiSchedule {

    ArrayList<Integer> bfs;         // balance factor list
    ArrayList<Integer> mschedule;   // integer multi-schedule
    
    /**
     * Constructs a multi-schedule based on balance factors list
     * @param bfs - balance factors for sub-schedules
     */
    public MultiSchedule(ArrayList<Integer> bfs) {

        this.bfs = bfs;
        this.mschedule = new ArrayList<>();

        // Combine x schedules, check if mschedule is valid, if not then regenerate
        for (int i = 0; i < bfs.size(); i++) {
            Schedule currSchedule = new Schedule(bfs.get(i));
            mschedule.addAll(currSchedule.getSchedule());
            if (i == bfs.size() - 1) {
                if (!isValid(mschedule)) {
                    i = -1;
                    mschedule.clear();
                }
            }
        }
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
            if ((i + 1 < s.size()) && (curr == flip(s.get(i + 1)))) {
                return false;
            }
            if ((i + 2 < s.size()) && (curr == flip(s.get(i + 2)))) {
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
     * MultiSchedule toString
     * @return string representation of schedule
     */
    public String toString() {
        String result = "";
        int block = 0;
        int cnt = 0;
        for (int i = 0; i < this.mschedule.size(); i++) {
            if (block == 0) {
                try {
                    block = this.bfs.get(cnt++);
                    result += String.format("\nBalance by %d\n", block);
                } catch (Exception e) {

                }
            }
            block--;
            int curr = this.mschedule.get(i);
            result += String.format("Trial %d: (%d, %d) \n", i + 1, curr, flip(curr));
        }

        return result;
    }
}
