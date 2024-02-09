package main.java.project;

import main.java.project.client.MainWindow.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        MainWindow window = new MainWindow();
        Scene mainScene = new Scene(window, 500, 800);
        primaryStage.setScene(mainScene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
