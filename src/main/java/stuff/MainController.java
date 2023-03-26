package stuff;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    @FXML
    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn10;

    @FXML
    private Button closeButton, resetButton, aboutButton;

    @FXML
    private Button subButton01;

    @FXML
    private TextField subField01, subField02;

    @FXML
    private TextArea subArea01;

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

    // Reset Subprogram's Nodes' Text Values
    @FXML
    private void resetButtonAction(){
        switch(MainApp.getSubStage()){
            case 1:
                subField01.setText("");
                subArea01.setText("");
                break;
            case 2:
            case 3:
                subField01.setText("");
                subField02.setText("");
                subArea01.setText("");
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

    // Display Subprogram Context -----------------------------------------------------------------
    @FXML
    private void aboutButtonAction(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        switch (MainApp.getSubStage()) {
            case 1 -> {
                alert.setHeaderText("1. Word Reversal");
                alert.setContentText("For this challenge, the input is a string of words, and the output should be " +
                        "the words in reverse but with the letters in the original order. For example, " +
                        "the string “Dog bites man” should output as “man bites Dog.”");
            }
            case 2 -> {
                alert.setHeaderText("2. Find the Word");
                alert.setContentText("""
                        Starting with an input string of words, find the second-to-last word of the string. For example, an input of “I love Codecademy” should return “love.”

                        To make your program more challenging, allow for a second numerical input, n, that results in returning the nth word of a string. So, for the string “I can program in Java” and n = 3, the output should be the third word, “program.”""");
            }
            case 3 -> {
                alert.setHeaderText("3. Word Search");
                alert.setContentText("""
                        For a given input string, return a Boolean TRUE if the string starts with a given input word. So, for an input string of “hello world” and input word “hello,” the program should return TRUE.

                        For a more advanced word searcher, create a program that returns the number of times a word appears in an input string. For example, given an input word “new” and an input string “I’m the new newt,” the program should return a value of 2.""");
            }
            case 4 -> {
                alert.setHeaderText("4. Anagrams");
                alert.setContentText("""
                        Two words are anagrams if they contain the same letters but in a different order. Here are a few examples of anagram pairs:

                        “listen” and “silent”
                        “binary” and “brainy”
                        “Paris” and “pairs”
                        For a given input of two strings, return a Boolean TRUE if the two strings are anagrams.

                        As an added challenge, for a given array of strings, return separate lists that group anagrams together. For example, the input {“tar,” “rat,” “art,” “meats,” “steam”}, the output should look something like {[“tar,” “rat,” “art”], [“meats,” “steam”]}.""");
            }
            case 5 -> {
                alert.setHeaderText("5. Pangrams");
                alert.setContentText("""
                        A pangram is a sentence that contains all 26 letters of the English alphabet. One of the most well-known examples of a pangram is, “The quick brown fox jumps over the lazy dog.” Create a pangram checker that returns a Boolean TRUE if an input string is a pangram and FALSE if it isn’t.

                        For an added pangram challenge, create a perfect pangram checker. A perfect pangram is a sentence that uses each letter of the alphabet only once, such as, “Mr. Jock, TV quiz Ph.D., bags few lynx.”""");
            }
            case 6 -> {
                alert.setHeaderText("6. Number Reversal");
                alert.setContentText("""
                        This one is a technical interview favorite. For a given input number, return the number in reverse. So, an input of 3956 should return 6593.

                        If you’re ready for a bigger challenge, reverse a decimal number. The decimal point should stay in the same place. So, the number 193.56 should output 653.91.""");
            }
            case 7 -> {
                alert.setHeaderText("7. Armstrong Numbers");
                alert.setContentText("""
                        An Armstrong number is a whole number that’s equal to the sum of its digits raised to the power of the total number of digits. For example, 153 is an Armstrong number because there are three digits, and 153 = 13 + 53 + 33. The four-digit number 8208 is also an Armstrong number, as 8208 = 84 + 24 + 04 + 84.

                        Create an Armstrong number checker that returns a Boolean TRUE if the input number is an Armstrong number. Hint: to extract each digit from a given number, try using the remainder/modulo operator.

                        If you’re looking for something a little more challenging, create an Armstrong number calculator that returns all Armstrong numbers between 0 and the input number.""");
            }
            case 8 -> {
                alert.setHeaderText("8. Product Maximizer");
                alert.setContentText("""
                        For a given input array of numbers, find the two that result in the largest product. The output should include the two numbers in the array along with their product.

                        As an extra challenge, use an input of two arrays of numbers and find two numbers — one from each input array — that results in the largest product.""");
            }
            case 9 -> {
                alert.setHeaderText("9. Prime Number Checker");
                alert.setContentText("""
                        A prime number is any whole number greater than 1 whose only factors are 1 and itself. For example, 7 is a prime number because it’s only divisible by 1 and 7.

                        Create a function that returns TRUE if an input number is prime. The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, and 19.

                        For a slightly harder challenge, create a prime number calculator that outputs all prime numbers between 2 and the input number.""");
            }
            case 10 -> {
                alert.setHeaderText("10. Prime Factorization");
                alert.setContentText("""
                        The prime factors of a number are all of the integers below that number that are divisible into the number as well as 1. For example, the prime factors of 12 are 1,2,3,4,6, and 12.

                        Create a prime factorization calculator that returns the prime factors of any number between 2 and 100. If you’re looking for a more advanced version of this challenge, use exercise 9 to create a prime factorization calculator for any number. Hint: think about using square roots to cut your work in half.""");
            }
        }
        alert.show();
    }

    // Secondary Programs' Execution Buttons ------------------------------------------------------
    public void p01reverse(){
        // Split User Input Into Separate Words to a String Array
        String[] phraseinput = subField01.getText().split("[\\s+]");

        // Reverse Traversal of String Array and Appending to String Variable
        String output = "";
        for (int x=phraseinput.length-1; x>=0; x--) {
            output = output.concat(phraseinput[x] + " ");
        }

        // Output String Variable Value to Text Area
        subArea01.setText(output);
    }

    public void p02find(){
        // Split User Input Into Separate Words to a String Array and Retrieve Parsed Integer
        String[] phraseinput = subField01.getText().split("[\\s+]");
        int numinput = Integer.parseInt(subField02.getText().trim());

        // Retrieve nth Element from String Array
        String output = phraseinput[numinput-1];

        // Output nth Word String Value
        subArea01.setText("The nth word from your phrase is " + output);
    }

    public void p03search(){
        // Retrieve User String Inputs
        String phraseinput = subField01.getText().trim();
        String stringinput = subField02.getText().trim();

        // Check if at Least One Instance of the String Exists Within the Phrase
        int instances = 0;
        if (phraseinput.contains(stringinput) && !stringinput.isBlank()){
            //
            Matcher regex = Pattern.compile(stringinput).matcher(phraseinput);
            while (regex.find()) {
                instances++;
            }
        }

        // Output Total Number of Instances Found
        subArea01.setText("There are " + instances + " instance/s of the String");
    }

    public void p04anagram(){

    }

    public void p05pangram(){

    }

    public void p06numreverse(){

    }

    public void p07armstrong(){

    }

    public void p08maximize(){

    }

    public void p09checker(){

    }

    public void p10factorize(){

    }

    // Set ActionEvent for "Enter" Key User Input -------------------------------------------------
    public void OnEnter(){
        switch (MainApp.getSubStage()) {
            case 1 -> p01reverse();
            case 2 -> p02find();
            case 3 -> p03search();
            case 4 -> p04anagram();
            case 5 -> p05pangram();
            case 6 -> p06numreverse();
            case 7 -> p07armstrong();
            case 8 -> p08maximize();
            case 9 -> p09checker();
            case 10 -> p10factorize();
        }
    }

    // Load Secondary Programs' Windows -----------------------------------------------------------
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