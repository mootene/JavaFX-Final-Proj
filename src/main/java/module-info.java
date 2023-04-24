module yalearts {
    requires javafx.controls;
    requires javafx.fxml;

    opens yalearts to javafx.fxml;
    exports yalearts;
}
