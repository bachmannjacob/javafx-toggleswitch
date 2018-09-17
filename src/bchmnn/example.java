package bchmnn;

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
        root.getChildren().add(new ToggleSwitch());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
