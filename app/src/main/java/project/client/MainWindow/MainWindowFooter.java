package main.java.project.client.MainWindow;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class MainWindowFooter extends HBox{
    private Button generateButton;
    private Button backButton;
    private Button forwardButton;
    private Button deleteButton;
    private Label padding;

    public MainWindowFooter() {
        this.generateButton = new Button("Spawn Schedule");
        this.backButton = new Button("< Back");
        this.forwardButton = new Button("Forward >");
        this.deleteButton = new Button("Delete Schedule");
        this.padding = new Label("");
        this.padding.setPadding(new Insets(0, 90, 0, 0));
        this.getChildren().addAll(this.padding, this.backButton, this.generateButton, this.deleteButton, this.forwardButton);
    }
}
