module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens stuff to javafx.fxml;
    exports stuff;
}