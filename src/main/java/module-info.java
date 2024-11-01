module com.example.furryfans {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.furryfans to javafx.fxml;
    exports com.example.furryfans;
}