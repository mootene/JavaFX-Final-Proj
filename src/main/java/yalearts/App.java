package yalearts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // baseline vertical box for page org
        VBox vb = new VBox();

        // create and set up news button
        Button newsButton = new Button("News");
        newsButton.setOnAction(e -> {
            // TODO wire news button
        });
        
        // create and set up events button
        Button eventsButton = new Button("Public Events");
        eventsButton.setOnAction(e -> {
            // TODO wire events button
        });
        
        scene = new Scene(loadFXML("primary"), 640, 480);
        scene.getStylesheets().addAll("styles.css");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}