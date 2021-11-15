module com.example.mathewcop3330assignment4part2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}