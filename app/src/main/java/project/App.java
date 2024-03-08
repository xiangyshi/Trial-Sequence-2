package main.java.project;

import main.java.project.client.MainWindow.*;
import main.java.project.logic.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        // Initialize window, connect window to controller
        MainWindow window = new MainWindow();
        Controller controller = new Controller(window);

        // Create scene for window and set primary stage
        Scene mainScene = new Scene(window, 500, 800);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
