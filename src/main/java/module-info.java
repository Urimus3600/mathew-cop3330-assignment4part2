module com.example.mathewcop3330assignment4part2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.mathewcop3330assignment4part2 to javafx.fxml;
    exports com.example.mathewcop3330assignment4part2;
}