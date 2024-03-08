package main.java.project.client.MainWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.layout.*;

/**
 *  MainWindow UI
 */
public class MainWindow extends BorderPane {
    private MainWindowHeader header;
    private MainWindowBody body;
    private MainWindowFooter footer;

    public MainWindow() {
        
        // initialize window components
        this.header = new MainWindowHeader();
        this.body = new MainWindowBody();
        this.footer = new MainWindowFooter();

        // format window
        this.setTop(header);
        this.setCenter(body);
        this.setBottom(footer);
    }
    
    /*
     *  Window section getters
     */
    public MainWindowHeader getHeader() {
        return this.header;
    }

    public MainWindowBody getBody() {
        return this.body;
    }

    public MainWindowFooter getFooter() {
        return this.footer;
    }
    
    /*
     *  Get balance factor user input from header
     */
    public String getbf() {
        return this.getHeader().getbf();
    }

    /*
     *  Textfield display setter
     */
    public void displayMessage(String message) {
        this.getBody().setMessage(message);
    }

    /*
     *  Button event setters
     */
    public void setGenerateAction(EventHandler<ActionEvent> eventHandler) {
        this.getFooter().getGenerateButton().setOnAction(eventHandler);
    }

    public void setDeleteAction(EventHandler<ActionEvent> eventHandler) {
        this.getFooter().getDeleteButton().setOnAction(eventHandler);
    }

    public void setBackAction(EventHandler<ActionEvent> eventHandler) {
        this.getFooter().getBackButton().setOnAction(eventHandler);
    }

    public void setForwardAction(EventHandler<ActionEvent> eventHandler) {
        this.getFooter().getForwardButton().setOnAction(eventHandler);
    }
}
