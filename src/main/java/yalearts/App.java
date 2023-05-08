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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
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
        final ScrollPane sp = new ScrollPane();
        StackPane stack = new StackPane();
        vb.setAlignment(Pos.CENTER);
        vb.setMinHeight(600);

        //main VBOX being passed to scroll pane
        VBox vbMain = new VBox();

        //testing VB for buttons
        HBox buttonsBox = new HBox();
        //buttonsBox.setPadding(new Insets(0, 0, 0, 1160));
        buttonsBox.setMinWidth(1650);
        buttonsBox.setAlignment(Pos.TOP_RIGHT);

        //top nav bar container
        HBox navContainer = new HBox();
        navContainer.setAlignment(Pos.TOP_CENTER);
        navContainer.setStyle("-fx-background-color: darkblue");
        navContainer.setMinHeight(20);
        //navContainer.setPadding(new Insets(20, 0, 0, 0));

        
        // testing HBox
        // HBox hb = new HBox();
        // hb.setAlignment(Pos.CENTER);
        // hb.getChildren().addAll(buttonsBox, vb);

        //bottom of page link container
        HBox bttmContain = new HBox();
        bttmContain.setAlignment(Pos.TOP_CENTER);
        bttmContain.setStyle("-fx-background-color: darkblue");

        //bottom of page containers and text
        VBox bttmVbxOne = new VBox();
        bttmVbxOne.setAlignment(Pos.BOTTOM_CENTER);

        Text bttmTitle = new Text("@2023 Yale School of Art");
        bttmTitle.setFill(Color.WHITE); // setting color of the text to blue

        bttmVbxOne.getChildren().add(bttmTitle);

        //first vbox element of bottom page links
        VBox bttmVbxTwo = new VBox();

        Text elOne = new Text("link");

        Text elTwo = new Text("link");

        Text elThree = new Text("link");

        Text elFour = new Text("link");

        bttmVbxTwo.getChildren().addAll(elOne, elTwo, elThree, elFour);

        //second vbox element of bottom page links
        VBox bttmVbxThree = new VBox();

        Text secOne = new Text("link");

        Text secTwo = new Text("link");

        Text secThree = new Text("link");

        Text secFour = new Text("link");

        bttmVbxThree.getChildren().addAll(secOne, secTwo, secThree, secFour);

        //hbox for the two vbox of link elements at bottom of page
        HBox bttmHBox = new HBox();

        //add two vbox of links to hbox
        bttmHBox.getChildren().addAll(bttmVbxTwo, bttmVbxThree);

        bttmVbxOne.getChildren().add(bttmHBox);

        //top container for school title
        HBox nameContainer = new HBox();
        nameContainer.setAlignment(Pos.TOP_LEFT);

        //button bar school label
        Text schoolName = new Text("Yale School of Art");
        schoolName.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        schoolName.setFill(Color.WHITE); // setting color of the text to white
        schoolName.setStrokeWidth(6);

        //put name into container
        nameContainer.getChildren().add(schoolName);

        Home home = new Home(vb);

        // create and set up about button 
        Button homeButton = new Button("Home");
        homeButton.setOnAction(e -> {
            // update vb layout
            try {
                Home home2 = Home(vb);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        buttonsBox.getChildren().add(homeButton);

        // create and set up about button
        // Button aboutButton = new Button("About The School");
        // aboutButton.setOnAction(e -> {
        //     // update vb layout
        //     About about = new About(vb);
        // });
        // buttonsBox.getChildren().add(aboutButton);

        // create and set up events button
        Button applyButton = new Button("Apply To The School");
        applyButton.setOnAction(e -> {
            // TODO wire events button
            try {
                Apply apply = new Apply(vb);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
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
            Events ev = new Events(vb);
        });
        buttonsBox.getChildren().add(eventsButton);

        //put button box into top right container
        navContainer.getChildren().addAll(nameContainer, buttonsBox);

        //put links in bottom container
        bttmContain.getChildren().add(bttmVbxOne);

        //place page containers on vb main
        vbMain.getChildren().addAll(navContainer, vb, bttmContain, stack);

        // buttonsBox.getChildren().add(eventsButton);
        // stack.getChildren().addAll(buttonsBox);

        //place vb main into the scroll box
        sp.setContent(vbMain);

        scene = new Scene(sp, 1280, 720);
        scene.getStylesheets().addAll("styles.css");
        stage.setScene(scene);
        stage.show();
    }

    
    public Home Home(VBox vb) throws FileNotFoundException {
        return  new Home(vb);
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