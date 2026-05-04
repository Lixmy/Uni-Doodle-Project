module iut.gon.test3 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens iut.gon.test3 to javafx.fxml;
    exports iut.gon.test3;
}
