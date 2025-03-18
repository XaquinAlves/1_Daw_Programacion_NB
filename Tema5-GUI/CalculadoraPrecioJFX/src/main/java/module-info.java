module gal.iespazodamerce.calculadorapreciojfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens gal.iespazodamerce.calculadorapreciojfx to javafx.fxml;
    exports gal.iespazodamerce.calculadorapreciojfx;
}
