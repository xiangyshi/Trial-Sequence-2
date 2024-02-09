package main.java.project.client.MainWindow;

import javafx.scene.layout.*;
 
public class MainWindow extends BorderPane {
    private MainWindowHeader header;
    private MainWindowBody body;
    private MainWindowFooter footer;

    public MainWindow() {
        this.header = new MainWindowHeader();
        this.body = new MainWindowBody();
        this.footer = new MainWindowFooter();

        this.setTop(header);
        this.setCenter(body);
        this.setBottom(footer);
    }
    
    public MainWindowHeader getHeader() {
        return this.header;
    }

    public MainWindowBody getBody() {
        return this.body;
    }

    public MainWindowFooter getFooter() {
        return this.footer;
    }
}
