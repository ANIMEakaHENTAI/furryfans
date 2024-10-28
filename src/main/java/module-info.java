module com.example.furryfans {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.furryfans to javafx.fxml;
    exports com.example.furryfans;
}