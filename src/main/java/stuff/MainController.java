package stuff;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

    @FXML
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10;

    // Instantiate New Stage then Hide Main Stage
    public void loadWindow(String xmlfile, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(xmlfile));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage tempstage = new Stage();
        tempstage.setTitle("Java Refresher Program");
        tempstage.setResizable(false);
        tempstage.setScene(scene);
        tempstage.show();
        btn01.getScene().getWindow().hide();
    }

    @FXML
    protected void progWordReversal() throws IOException {
        loadWindow("prog01-view.fxml", "Word Reversal");
    }

}