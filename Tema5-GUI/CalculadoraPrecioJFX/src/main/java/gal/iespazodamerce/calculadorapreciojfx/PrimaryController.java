package gal.iespazodamerce.calculadorapreciojfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController{
    @FXML private TextField unitsField;
    @FXML private TextField precioField;
    @FXML private TextField totalField;
    private double iva = 1.21;
    private double discount = 1;
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void calculatePrice() throws IOException{
        double total = Double.parseDouble(unitsField.getText()) * 
                Double.parseDouble(precioField.getText()) * iva * discount; 
        totalField.setText(Double.toString(total));
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    
}
