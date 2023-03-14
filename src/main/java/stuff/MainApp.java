package stuff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    private static Stage MainStage;

    // Initialize and Display Main Window
    @Override
    public void start(Stage stage) throws IOException {
        setMainStage(stage);
        MainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        MainStage.setTitle("Java Refresher Program");
        //MainStage.setResizable(false);
        MainStage.setScene(scene);
        MainStage.show();
    }

    public static Stage getMainStage(){
        return MainStage;
    }

    private void setMainStage(Stage mainstage){
        MainStage = mainstage;
    }

    public static void main(String[] args) {
        launch();
    }
}