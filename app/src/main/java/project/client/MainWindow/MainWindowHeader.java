package main.java.project.client.MainWindow;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.text.*;

/**
 *  User input UI and Header
 */
public class MainWindowHeader extends VBox{
    private Label bfLabel;
    private TextField bfInput;
    private HBox top;
    private HBox bot;

    public MainWindowHeader() {
        this.top = new HBox();
        this.bot = new HBox();

        this.bfLabel = new Label("Enter balance factors: ");
        this.bfLabel.setPadding(new Insets(0, 35, 0, 0));
        this.bfInput = new TextField();

        this.top.getChildren().addAll(this.bfLabel, this.bfInput);
        this.getChildren().addAll(this.top, this.bot);
    }

    public String getbf() {
        return this.bfInput.getText();
    }
}
