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
        buttonsBox.setPadding(new Insets(10, 0, 10, 0));
        buttonsBox.setMinWidth(1585);
        buttonsBox.setAlignment(Pos.TOP_RIGHT);
        buttonsBox.setSpacing(5);

        //top nav bar container
        HBox navContainer = new HBox();
        navContainer.setAlignment(Pos.TOP_CENTER);
        navContainer.setStyle("-fx-background-color: #212A3E");
        navContainer.setMinHeight(20);
        navContainer.setPadding(new Insets(10, 15,10,50)); //top,right,bott,left

        //bottom of page link container
        HBox bttmContain = new HBox();
        bttmContain.setAlignment(Pos.TOP_CENTER);
        bttmContain.setStyle("-fx-background-color: #212A3E");

        //bottom of page containers and text
        VBox bttmVbxOne = new VBox();
        bttmVbxOne.setAlignment(Pos.BOTTOM_CENTER);

        Text bttmTitle = new Text("@2023 Yale School of Art");
        bttmTitle.setFill(Color.WHITE); // setting color of the text to blue

        bttmVbxOne.getChildren().add(bttmTitle);

        //first vbox element of bottom page links
        VBox bttmVbxTwo = new VBox();

        Text elOne = new Text("Support the School");
        elOne.setId("footText");

        Text elTwo = new Text("Visiting");
        elTwo.setId("footText");

        Text elThree = new Text("Instragram");
        elThree.setId("footText");

        Text elFour = new Text("Facebook");
        elFour.setId("footText");

        bttmVbxTwo.getChildren().addAll(elOne, elTwo, elThree, elFour);

        //second vbox element of bottom page links
        VBox bttmVbxThree = new VBox();

        Text secOne = new Text("Accessibility at Yale");
        secOne.setId("footText");

        Text secTwo = new Text("YouTube");
        secTwo.setId("footText");

        Text secThree = new Text("Contract");
        secThree.setId("footText");

        Text secFour = new Text("Sitemap");
        secFour.setId("footText");

        bttmVbxThree.getChildren().addAll(secOne, secTwo, secThree, secFour);

        //hbox for the two vbox of link elements at bottom of page
        HBox bttmHBox = new HBox();

        //add two vbox of links to hbox
        bttmHBox.getChildren().addAll(bttmVbxTwo, bttmVbxThree);

        bttmVbxOne.getChildren().add(bttmHBox);
        bttmVbxOne.setPadding(new Insets(10,0,10,0));

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
        homeButton.setStyle("-fx-padding: 10 20 10 20; -fx-background-color: #E7EDFF;");
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

        // create and set up events button
        Button eventsButton = new Button("Public Events");
        eventsButton.setStyle("-fx-padding: 10 20 10 20; -fx-background-color: #E7EDFF");
        eventsButton.setOnAction(e -> {
            Events ev = new Events(vb);
        });
        buttonsBox.getChildren().add(eventsButton);

        // create and set up about button
        // Button aboutButton = new Button("About The School");
        // aboutButton.setOnAction(e -> {
        //     // update vb layout
        //     About about = new About(vb);
        // });
        // buttonsBox.getChildren().add(aboutButton);

        // create and set up events button
        Button applyButton = new Button("Apply to School");
        applyButton.setStyle("-fx-padding: 10 20 10 20; -fx-background-color: #FF9200 ;");
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

//        // create and set up news button
//        Button newsButton = new Button("News");
//        newsButton.setOnAction(e -> {
//            // update vb layout
//            News n = new News(vb);
//        });
//        buttonsBox.getChildren().add(newsButton);


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