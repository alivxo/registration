module org.alivxo.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;

    opens org.alivxo.javafxdemo to javafx.fxml;
    exports org.alivxo.javafxdemo;
    exports org.alivxo.javafxdemo.controller;
    opens org.alivxo.javafxdemo.controller to javafx.fxml;
}