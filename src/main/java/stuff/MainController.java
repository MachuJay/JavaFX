package stuff;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class MainController {

    @FXML
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10;

    @FXML
    private Button closeButton, resetButton;

    @FXML
    private Button p01btn01;

    @FXML
    private TextField p01field;

    @FXML
    private TextArea p01area;

    @FXML
    private ImageView imageView;

    // Instantiate New Stage then Hide Main Stage
    public void loadWindow(String xmlfile, String title, int subStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(xmlfile));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage tempstage = new Stage();
        tempstage.setScene(scene);
        tempstage.setTitle(title);
        tempstage.setResizable(false);
        tempstage.initStyle(StageStyle.UTILITY);
        MainApp.setSubStage(subStage);
        tempstage.show();
        btn01.getScene().getWindow().hide();
    }

    // Unhide Main Stage then Close Secondary Window
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        closeButton.getParent().getScene().getWindow().hide();
        MainApp.getMainStage().show();
        stage.close();
    }

    // Reset Subprogram's Nodes
    @FXML
    private void resetButtonAction(){
        switch(MainApp.getSubStage()){
            case 1:
                p01field.setText("");
                p01area.setText("");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
    }

    // Secondary Programs' Execution Buttons
    public void p01reverse(){
        // Split User Input Into Separate Words to a String Array
        String[] userinput = p01field.getText().split("\\s+");

        // Reverse Traversal of String Array and Appending to String Variable
        String output = "";
        for (int x=userinput.length-1; x>=0; x--) {
            output = output.concat(userinput[x] + " ");
        }

        // Output String Variable Value to Text Area
        p01area.setText(output);
    }

    // Load Secondary Programs' Windows
    @FXML
    private void load(String fxml, String title, int subStage) throws IOException {
        loadWindow(fxml, title, subStage);
    }

    @FXML
    protected void prog01() throws IOException {
        load("prog01-view.fxml", "Word Reversal", 1);
    }

    @FXML
    protected void prog02() throws IOException {
        load("prog02-view.fxml", "Find the Word", 2);
    }

    @FXML
    protected void prog03() throws IOException {
        load("prog03-view.fxml", "Word Search", 3);
    }

    @FXML
    protected void prog04() throws IOException {
        load("prog04-view.fxml", "Anagrams", 4);
    }

    @FXML
    protected void prog05() throws IOException {
        load("prog05-view.fxml", "Pangrams", 5);
    }

    @FXML
    protected void prog06() throws IOException {
        load("prog06-view.fxml", "Number Reversal", 6);
    }

    @FXML
    protected void prog07() throws IOException {
        load("prog07-view.fxml", "Armstrong Numbers", 7);
    }

    @FXML
    protected void prog08() throws IOException {
        load("prog08-view.fxml", "Product Maximizer", 8);
    }

    @FXML
    protected void prog09() throws IOException {
        load("prog09-view.fxml", "Prime Number Checker", 9);
    }

    @FXML
    protected void prog10() throws IOException {
        load("prog10-view.fxml", "Prime Factorization", 10);
    }

}