module com.accenture.steelbody
{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    exports com.accenture.steelbody.controller;
    opens com.accenture.steelbody.controller to javafx.fxml;
    exports com.accenture.steelbody.container;
    opens com.accenture.steelbody.container to javafx.fxml;
    exports com.accenture.steelbody;
    opens com.accenture.steelbody to javafx.fxml;
}