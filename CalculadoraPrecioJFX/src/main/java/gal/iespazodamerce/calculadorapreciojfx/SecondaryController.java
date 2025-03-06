package gal.iespazodamerce.calculadorapreciojfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML private TextField ivaField;
    @FXML private TextField discountField;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void setConfig() throws IOException {
        double iva = (Double.parseDouble(ivaField.getText()) /100) +1;
        double discount = 1 - (Double.parseDouble(discountField.getText()) /100);
        
    }
}