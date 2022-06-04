module vitalyprolomov.contactbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens vitalyprolomov.contactbook to javafx.fxml;
    exports vitalyprolomov.contactbook;
}