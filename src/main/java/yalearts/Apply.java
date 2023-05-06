package yalearts;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    VBox vb = new VBox();

    GridPane linkPane = new GridPane();



    public Apply(VBox vb) {
        vb.getChildren().clear();
        pageTitle = new Text("Apply To The School");
        pageTitle.setWrappingWidth(300);
        pageTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
        

        body1Title = new Text(
                "The Yale School of Art is a graduate school that confers Master of Fine Arts Degrees in Graphic Design, Painting/Printmaking, Photography, and Sculpture");
                        body1Title.setWrappingWidth(300);

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

        
        
        linkPane.getChildren().addAll(gradAdmin,tuition,gradStudy,courses,housing,broAndDoc);
          
        hb0.getChildren().addAll( pageTitle);
        
        hb1.getChildren().addAll(body1Title);
        
        hb2.getChildren().addAll(body1);
        
        hb3.getChildren().addAll(body2Title);

        hb4.getChildren().addAll(body2);
        
        
        
        vbContent.getChildren().addAll(hb0, hb1, hb2, hb3, hb4, linkPane);
          
        vbContent.setAlignment(Pos.CENTER);

        vb.getChildren().add(vbContent);
        

    }
    
   
}
