package yalearts;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Events {
    private class Event {
        public String eventName;
        public String eventDescription;
        public LocalDate date;

    }
    private class Day {
        Day(int date, Event[] events, Stage stage) {
            // the specific day
            Text day = new Text(Integer.toString(date));
            
            // css for date vb
            String cssVB = "-fx-border-color: black;\n" +
                            "-fx-border-width: 3;\n";

            // individual calendar day box
            VBox vb = new VBox(day);

            vb.setStyle(cssVB);
            vb.setPrefHeight(90);
            vb.setPrefWidth(70);
            vb.setMaxHeight(90);
            vb.setMaxWidth(70);

            vb.setAlignment(Pos.TOP_LEFT);
            for (Event foo : events) {
                Button title = new Button(foo.eventName);
                // popup formatting
                Label descriptLabel = new Label(foo.eventDescription);
                Button closeButton = new Button("X");

                /*  content content content  | X |
                    content content content       */
                HBox hb = new HBox();
                hb.setAlignment(Pos.TOP_LEFT);
                hb.getChildren().addAll(closeButton, descriptLabel);
                // popup contains selected event description
                Popup popup = new Popup();
                popup.getContent().add(hb);
                // when title is clicked, generate popup with details for selected
                title.setOnAction(e -> {
                    popup.show(stage);
                    closeButton.setOnAction(f -> {
                        // close popup on X click
                        popup.hide();
                    });
                });
                // adds event to day view
                vb.getChildren().add(title);
            }
        }
    }

    private class Calendar {
        Calendar() {
            

        }
    }
}
