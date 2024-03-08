package main.java.project.logic;

import main.java.project.client.MainWindow.*;
import java.util.ArrayList;
import javafx.event.ActionEvent;

/**
 * Controller class connects UI to logic implementations and execute functions on user input.
 */
public class Controller {

    private MainWindow window;                  // main window var for access
    private ArrayList<MultiSchedule> history;   // storing schedules and record
    private int currPage;                       // current history index

    /**
     * @param window - main window, for accessing different fields (TextField, Buttons, etc.)
     */
    public Controller(MainWindow window) {
        this.window = window;
        history = new ArrayList<>();
        currPage = -1;

        // Direct actions to buttons
        this.window.setGenerateAction(this::handleGenerate);
        this.window.setDeleteAction(this::handleDelete);
        this.window.setBackAction(this::handleBack);
        this.window.setForwardAction(this::handleForward);
    }

    /**
     * @param event - on click, TextField displays a schedule based on user input of balance factor list
     */
    private void handleGenerate(ActionEvent event) {
        ArrayList<Integer> bfs = new ArrayList<>();
        String toParse = this.window.getbf().trim();
        while (toParse.length() != 0) {
            int comma = toParse.indexOf(",");
            if (comma == -1) {
                bfs.add(Integer.parseInt(toParse));
                toParse = "";
            } else {
                bfs.add(Integer.parseInt(toParse.substring(0, comma)));
                toParse = toParse.substring(comma + 1).trim();
            }
        }

        MultiSchedule currSchedule = new MultiSchedule(bfs);
        history.add(currSchedule);
        currPage++;
        this.window.displayMessage(currSchedule.toString());
    }

    /**
     * @param event - on click, the current displaying schedule is deleted
     */
    private void handleDelete(ActionEvent event) {
        this.history.remove(currPage);
        this.window.displayMessage("Deleted");
    }

    /**
     * @param event - on click, go to the previous generated schedule (no change if doesn't exist)
     */
    private void handleBack(ActionEvent event) {
        if (currPage > 0) {
            currPage--;
        }
        this.window.displayMessage(history.get(currPage).toString());
    }

    /**
     * @param event - on click, go to the next generated schedule (no change if doesn't exist)
     */
    private void handleForward(ActionEvent event) {
        if (currPage < this.history.size() - 1) {
            currPage++;
        }
        this.window.displayMessage(history.get(currPage).toString());
    }
}
