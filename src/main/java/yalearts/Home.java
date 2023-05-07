package yalearts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Home {
    

    Text pageTitle;
    Text body1Title;
    Text body1;
    Text body2Title;
    Text body2;
    Text body3Title;
    Text body3;

   

    HBox hb0 = new HBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    HBox hb3 = new HBox();
    HBox hb4 = new HBox();
    HBox hb5 = new HBox();
    HBox hb6 = new HBox();
    HBox hb7 = new HBox();

    VBox vbContent = new VBox();
    VBox vb = new VBox();

    GridPane linkPane = new GridPane();



  
    
    public Home(VBox vb) throws FileNotFoundException {

            StackPane backgroundImageContainer = new StackPane();

        vb.getChildren().clear();
        pageTitle = new Text("Yale School of Art");
        pageTitle.setWrappingWidth(500);
        pageTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
        
        Image image = new Image(new FileInputStream("src/main/java/yalearts/homepage.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(1000);
        imageView.setFitWidth(1000);

        body1Title = new Text(
                "The Yale School of Art is a graduate school that confers Master of Fine Arts Degrees in Graphic Design, Painting/Printmaking, Photography, and Sculpture");
                        body1Title.setWrappingWidth(300);

        body1 = new Text(
                "The Yale School of Art is a graduate school that confers MFAs in Graphic Design, Painting/Printmaking, Photography, and Sculpture; and offers undergraduate-level art courses to Yale College students. Our website exists as an ongoing collaborative experiment in digital publishing and information sharing. It functions as a wiki—all members of the School of Art community have the ability to add new, and edit most existing content.");
                body1.setWrappingWidth(500);

       
          
        hb0.getChildren().addAll(pageTitle);
        hb0.setAlignment(Pos.TOP_CENTER);
        hb0.setPadding(new Insets(20, 0, 0, 0));


        hb1.getChildren().addAll(body1Title);
        hb1.setAlignment(Pos.CENTER);
        hb1.setPadding(new Insets(0, 0, 0, 0));
        
        hb2.getChildren().addAll(body1);
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(0, 0, 0, 0));

        
        backgroundImageContainer.getChildren().addAll(imageView,hb0,hb1, hb2);
       
        
        vbContent.getChildren().addAll(backgroundImageContainer);
          
        vbContent.setAlignment(Pos.CENTER);

        vb.getChildren().add(vbContent);
        

    }
}
