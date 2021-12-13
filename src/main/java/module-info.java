module ryan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens ryan.teamproject to javafx.fxml;
    exports ryan.teamproject;
}