package yalearts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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
        // baseline vertical box for page org (THIS IS WHAT IS PASSED TO CLASSES)
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        //testing VB for buttons
        VBox buttonsBox = new VBox();
        // testing HBox
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(buttonsBox, vb);

        // create and set up about button
        Button aboutButton = new Button("About The School");
        aboutButton.setOnAction(e -> {
            // update vb layout
            About about = new About(vb);
        });
        buttonsBox.getChildren().add(aboutButton);

        // create and set up news button
        Button newsButton = new Button("News");
        newsButton.setOnAction(e -> {
            // update vb layout
            News n = new News(vb);
        });
        buttonsBox.getChildren().add(newsButton);

        // create and set up events button
        Button eventsButton = new Button("Public Events");
        eventsButton.setOnAction(e -> {
            // TODO wire events button
        });
        buttonsBox.getChildren().add(eventsButton);

        scene = new Scene(hb, 1280, 720);
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