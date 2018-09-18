package bchmnn;

import bchmnn.styles.Styles;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class example extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();


        ToggleSwitch swtch = new ToggleSwitch();
        /*
        swtch.loadStyle(Styles.WIN8);
        swtch.build();
        */

        root.getChildren().add(swtch);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
