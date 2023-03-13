package stuff;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10;

    // Instantiate New Stage then Hide Main Stage
    public void loadWindow(String xmlfile, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(xmlfile));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage tempstage = new Stage();
        tempstage.setScene(scene);
        tempstage.setTitle(title);
        tempstage.setResizable(false);
        tempstage.initStyle(StageStyle.UNDECORATED);
        tempstage.show();
        btn01.getScene().getWindow().hide();
    }

    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        closeButton.getParent().getScene().getWindow().hide();
        MainApp.getMainStage().show();
        stage.close();
    }

    // Load Secondary Programs' Windows
    @FXML
    private void load(String fxml, String title) throws IOException {
        loadWindow(fxml, title);
    }

    @FXML
    protected void prog01() throws IOException {
        load("prog01-view.fxml", "Word Reversal");
    }

    @FXML
    protected void prog02() throws IOException {
        load("prog02-view.fxml", "Find the Word");
    }

    @FXML
    protected void prog03() throws IOException {
        load("prog03-view.fxml", "Word Search");
    }

    @FXML
    protected void prog04() throws IOException {
        load("prog04-view.fxml", "Anagrams");
    }

    @FXML
    protected void prog05() throws IOException {
        load("prog05-view.fxml", "Pangrams");
    }

    @FXML
    protected void prog06() throws IOException {
        load("prog06-view.fxml", "Number Reversal");
    }

    @FXML
    protected void prog07() throws IOException {
        load("prog07-view.fxml", "Armstrong Numbers");
    }

    @FXML
    protected void prog08() throws IOException {
        load("prog08-view.fxml", "Product Maximizer");
    }

    @FXML
    protected void prog09() throws IOException {
        load("prog09-view.fxml", "Prime Number Checker");
    }

    @FXML
    protected void prog10() throws IOException {
        load("prog10-view.fxml", "Prime Factorization");
    }

}