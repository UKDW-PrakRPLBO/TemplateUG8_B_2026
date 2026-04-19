module org.rplbo.app.ug8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.rplbo.app.ug8 to javafx.fxml;
    exports org.rplbo.app.ug8;
    exports org.rplbo.app.ug8.Controller;
    opens org.rplbo.app.ug8.Controller to javafx.fxml;
}