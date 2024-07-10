module com.example.sitaneupanetamangg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sitaneupanetamangg to javafx.fxml;
    exports com.example.sitaneupanetamangg;
}