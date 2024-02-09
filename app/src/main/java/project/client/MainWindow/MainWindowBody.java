package main.java.project.client.MainWindow;

import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class MainWindowBody extends HBox{
    private TextArea scheduleDisplay;

    public MainWindowBody() {
        this.scheduleDisplay = new TextArea();
        
        this.getChildren().addAll(scheduleDisplay);
    }

    public String getSchedule() {
        return this.scheduleDisplay.getText();
    }
}
