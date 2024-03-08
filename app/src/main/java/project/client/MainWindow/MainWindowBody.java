package main.java.project.client.MainWindow;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

/**
 * Schedule display UI
 */
public class MainWindowBody extends HBox{
    private TextArea scheduleDisplay; // schedule, message display area

    public MainWindowBody() {
        this.scheduleDisplay = new TextArea();
        
        this.getChildren().addAll(scheduleDisplay);
    }

    /**
     * Setter for TextArea
     * @param - to display
     */
    public void setMessage(String message) {
        this.scheduleDisplay.setText(message);
    }

    /**
     * Getter for TextArea
     * @return - current display
     */
    public String getSchedule() {
        return this.scheduleDisplay.getText();
    }
}
