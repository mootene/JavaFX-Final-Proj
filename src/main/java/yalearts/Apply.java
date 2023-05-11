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
import javafx.scene.control.Label;

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
    HBox hb8 = new HBox();
    HBox hb9 = new HBox();
    HBox hb10 = new HBox();

    VBox vboxText = new VBox();

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
        body1Title.setWrappingWidth(600);
        
                        

        body1 = new Text(
                "For information on applications to the MFA program, please click the Graduate Admission link below.The undergraduate admissions process is handled entirely through Yale College. Please refer all undergraduate admissions questions to the Yale College Undergraduate Admissions Office. ");
                body1.setWrappingWidth(600);

        body2Title = new Text("Fall 2023 Application for Admission is CLOSED Deadline: \n                     January 9, 2023 at 11:59pm EST");
        body2Title.setWrappingWidth(550);
        body2Title.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        //body2 = new Text("The SoA wiki admission pages provide extensive information about applying to Yale’s MFA program. Use this as your resource while preparing an application.Questions that are not easily answered via these pages may be directed to our office, either via email art.admissions@yale.edu or phone (during business hours), with the understanding that Yale does not provide personalized portfolio review or advisement about the content of applicant submissions.Application status and receipt of documents can be checked within the status portal at the application link above, after an application has been submitted.Applicants SHOULD NOT CONTACT Yale School of Art faculty and/or current students seeking program information, application and/or portfolio advisement. Please respect the personal/private spaces (such as email, social media, direct message, etc.) and time of our community by utilizing the wiki and, when necessary, directing your inquiries appropriately to those whose job it is to assist you.Thank you");
        //body2.setWrappingWidth(500);
        Label body2 = new Label("The SoA wiki admission pages provide extensive information about applying to Yale’s MFA program. Use this as your resource while preparing an application.\n ");
        body2.setWrapText(true);
        body2.setMaxWidth(500);
        body2.setStyle("-fx-background-color: white; fx-text-fill: Black");
        Label body3 = new Label("Questions that are not easily answered via these pages may be directed to our office, either via email art.admissions@yale.edu or phone (during business hours), with the understanding that Yale does not provide personalized portfolio review or advisement about the content of applicant submissions.\n ");
        body3.setWrapText(true);
        body3.setMaxWidth(500);
        body3.setStyle("-fx-background-color: white; fx-text-fill: Black");
        Label body4 = new Label("Application status and receipt of documents can be checked within the status portal at the application link above, after an application has been submitted.\n ");
        body4.setWrapText(true);
        body4.setMaxWidth(500);
        body4.setStyle("-fx-background-color: white; fx-text-fill: Black");
        Label body5 = new Label("Applicants SHOULD NOT CONTACT Yale School of Art faculty and/or current students seeking program information, application and/or portfolio advisement.\n ");
        body5.setWrapText(true);
        body5.setMaxWidth(500);
        body5.setStyle("-fx-background-color: white; fx-text-fill: Black; -fx-font-weight: bold");
        Label body6 = new Label("Please respect the personal/private spaces (such as email, social media, direct message, etc.) and time of our community by utilizing the wiki and, when necessary, directing your inquiries appropriately to those whose job it is to assist you.\nThank you.\n ");
        body6.setWrapText(true);
        body6.setMaxWidth(500);
        body6.setStyle("-fx-background-color: white; fx-text-fill: Black");

        Button gradAdmin = new Button("Graduate Admission");
        gradAdmin.setOnAction(e -> {
            // reveal text 
        });
        gradAdmin.setId("ApplyPageButtons");

         Button tuition = new Button("Tuition,Fees&Financing");
        tuition.setOnAction(e -> {
            // reveal text  
        });
        tuition.setId("ApplyPageButtons");

         Button gradStudy = new Button("Graduate Study");
        gradStudy.setOnAction(e -> {
            // reveal text
        });
        gradStudy.setId("ApplyPageButtons");

         Button courses = new Button("Courses");
        courses.setOnAction(e -> {
            // reveal text
        });
        courses.setId("ApplyPageButtons");

         Button housing = new Button("Housing");
        housing.setOnAction(e -> {
            // reveal text
        });
        housing.setId("ApplyPageButtons");

         Button broAndDoc = new Button("Brochures & Documentation");
        broAndDoc.setOnAction(e -> {
            // reveal text
        });
        broAndDoc.setId("ApplyPageButtons");
        
        
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
        
        hb5.getChildren().addAll(body2);
        hb5.setAlignment(Pos.CENTER);

        hb6.getChildren().addAll(body3);
        hb6.setAlignment(Pos.CENTER);

        hb7.getChildren().addAll(body4);
        hb7.setAlignment(Pos.CENTER);

        hb8.getChildren().addAll(body5);
        hb8.setAlignment(Pos.CENTER);

        hb9.getChildren().addAll(body6);
        hb9.setAlignment(Pos.CENTER);

        
        vboxText.getChildren().addAll(hb4,hb5,hb6,hb7,hb8,hb9);
        vboxText.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); "); 
        vboxText.setPadding(new Insets(300,0,20,0));

        backgroundImageContainer.getChildren().addAll(imageView,vboxText);
         
        
        
        vbContent.getChildren().addAll(hb0, hb1,  hb2, hb3, linkPane, linkPane2, linkPane3, backgroundImageContainer);
          
        vbContent.setAlignment(Pos.CENTER);

        vb.getChildren().add(vbContent);
        

    }
    
   
}
