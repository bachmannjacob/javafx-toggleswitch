package resources;

import bchmnn.ToggleSwitch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML VBox root;
    @FXML ToggleSwitch tgglswtch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller initializing ...");
    }
}
