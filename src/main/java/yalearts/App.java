
package yalearts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        final ScrollPane sp = new ScrollPane();
        VBox vb = new VBox();

        //main VBOX being passed to scroll pane
        VBox vbMain = new VBox();
     

        //testing HB for buttons
        HBox buttonsBox = new HBox();
        buttonsBox.setPadding(new Insets(0,0,0,1100));
        buttonsBox.setAlignment(Pos.TOP_RIGHT);


        //top nav bar container
        HBox navContainer = new HBox();
        navContainer.setAlignment(Pos.TOP_CENTER);
        navContainer.setStyle("-fx-background-color: darkblue");
        

        //top container for school title
        HBox nameContainer = new HBox();
        nameContainer.setAlignment(Pos.TOP_LEFT);

        //button bar school label
        Text schoolName = new Text("Yale School of Art");
        schoolName.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        schoolName.setFill(Color.WHITE); // setting color of the text to blue
        schoolName.setStrokeWidth(6);
        
        //put name into container
        nameContainer.getChildren().add(schoolName);
        

        // create and set up about button
        Button aboutButton = new Button("About The School");
        aboutButton.setOnAction(e -> {
            // update vb layout
            About about = new About(vb);
        });
        buttonsBox.getChildren().add(aboutButton);

          // create and set up events button
        Button applyButton = new Button("Apply To The School");
        applyButton.setOnAction(e -> {
            // TODO wire events button
             Apply apply = new Apply(vb);
        });
        buttonsBox.getChildren().add(applyButton);

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

        //put button box into top right container
        navContainer.getChildren().addAll(nameContainer,buttonsBox);

        //place page containers on vb main
        vbMain.getChildren().addAll(navContainer, vb);
        
        //set alignment does not work!!! idk
        vbMain.setAlignment(Pos.CENTER);

        //place vb main into the scroll box
        sp.setContent(vbMain);

        scene = new Scene(sp, 1280, 720);
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