package yalearts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Apply {
    Text pageTitle;
    Text body1Title;
    Text body1;
    Text body2Title;
    Text body2;

    HBox hb0 = new HBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();
    HBox hb3 = new HBox();
    HBox hb4 = new HBox();
    HBox hb5 = new HBox();
    HBox hb6 = new HBox();
    HBox hb7 = new HBox();

    VBox vbContent = new VBox();

    //handed off box
    VBox vb = new VBox();

    FlowPane linkPane = new FlowPane();
    FlowPane linkPane2 = new FlowPane();
    FlowPane linkPane3 = new FlowPane();

    StackPane backgroundImageContainer = new StackPane();

    




    public Apply(VBox vb) throws FileNotFoundException  {
        vb.getChildren().clear();


         Image image = new Image(new FileInputStream("src/main/java/yalearts/applypage.png"));
         ImageView imageView = new ImageView(image);



        pageTitle = new Text("Apply To The School");
        pageTitle.setWrappingWidth(500);
        pageTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
        

        body1Title = new Text(
                "The Yale School of Art is a graduate school that confers Master of Fine Arts Degrees in Graphic Design, Painting/Printmaking, Photography, and Sculpture");
        body1Title.setWrappingWidth(700);
        
                        

        body1 = new Text(
                "For information on applications to the MFA program, please click the Graduate Admission link below.The undergraduate admissions process is handled entirely through Yale College. Please refer all undergraduate admissions questions to the Yale College Undergraduate Admissions Office. ");
                body1.setWrappingWidth(500);

        body2Title = new Text("Fall 2023 Application for Admission is CLOSED Deadline: January 9, 2023 at 11:59pm EST");
                body2Title.setWrappingWidth(300);

                body2 = new Text(
                        "The SoA wiki admission pages provide extensive information about applying to Yale’s MFA program. Use this as your resource while preparing an application.Questions that are not easily answered via these pages may be directed to our office, either via email art.admissions@yale.edu or phone (during business hours), with the understanding that Yale does not provide personalized portfolio review or advisement about the content of applicant submissions.Application status and receipt of documents can be checked within the status portal at the application link above, after an application has been submitted.Applicants SHOULD NOT CONTACT Yale School of Art faculty and/or current students seeking program information, application and/or portfolio advisement. Please respect the personal/private spaces (such as email, social media, direct message, etc.) and time of our community by utilizing the wiki and, when necessary, directing your inquiries appropriately to those whose job it is to assist you.Thank you");
                body2.setWrappingWidth(500);
               
        Button gradAdmin = new Button("Graduate Admission");
        gradAdmin.setOnAction(e -> {
            // reveal text 
        });

         Button tuition = new Button("Tuition,Fees&Financing");
        tuition.setOnAction(e -> {
            // reveal text  
        });

         Button gradStudy = new Button("Graduate Study");
        gradStudy.setOnAction(e -> {
            // reveal text
        });

         Button courses = new Button("Courses");
        courses.setOnAction(e -> {
            // reveal text
        });

         Button housing = new Button("Housing");
        housing.setOnAction(e -> {
            // reveal text
        });

         Button broAndDoc = new Button("Brochures & Documentation");
        broAndDoc.setOnAction(e -> {
            // reveal text
        });

        
        
        linkPane.getChildren().addAll(gradAdmin, tuition, gradStudy);
        linkPane.setAlignment(Pos.CENTER);
        linkPane.setPadding(new Insets(20, 0, 0, 0));
        linkPane.setVgap(8);
        linkPane.setHgap(20);
        linkPane.setPrefWrapLength(300); // preferred width = 300

        linkPane2.getChildren().addAll( courses, housing);
        linkPane2.setAlignment(Pos.CENTER);
        linkPane2.setPadding(new Insets(10, 0, 0, 0));
        linkPane2.setVgap(8);
        linkPane2.setHgap(40);
        linkPane2.setPrefWrapLength(200); // preferred width = 300

        linkPane3.getChildren().addAll(broAndDoc);
        linkPane3.setAlignment(Pos.CENTER);
        linkPane3.setPadding(new Insets(10, 0, 80, 0));
        linkPane3.setVgap(8);
        linkPane3.setHgap(10);
        linkPane3.setPrefWrapLength(200); // preferred width = 300
        
          
        hb0.getChildren().addAll(pageTitle);
        hb0.setAlignment(Pos.CENTER);
        hb0.setPadding(new Insets(80,0,80,0));
        
        
        hb1.getChildren().addAll(body1Title);
        hb1.setAlignment(Pos.CENTER);
        hb1.setPadding(new Insets(0,0,80,0));
        
        hb2.getChildren().addAll(body1);
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(20,0,20,0));
        
        hb3.getChildren().addAll(body2Title);
        hb3.setAlignment(Pos.CENTER);
        hb3.setPadding(new Insets(80,0,20,0));

        hb4.getChildren().addAll(body2);
        hb4.setAlignment(Pos.CENTER);
 
        hb4.setStyle("-fx-background: transparent; -fx-background-color: rgba(255, 255, 255, 0.5); "); 
        hb4.setPadding(new Insets(80,0,20,0));
        
        
        backgroundImageContainer.getChildren().addAll(imageView,hb4);
         
        
        
        vbContent.getChildren().addAll(hb0, hb1,  hb2, hb3, linkPane, linkPane2, linkPane3, backgroundImageContainer);
          
        vbContent.setAlignment(Pos.CENTER);

        vb.getChildren().add(vbContent);
        

    }
    
   
}
