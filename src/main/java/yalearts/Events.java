package yalearts;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Events {
    

    Event e1 = new Event("TEST", "THIS IS A TEST", 12);
    Event e2 = new Event("TEST 2", "TESTING", 2);
    Event[] events = {e1, e2};

    private class Event {
        public String eventName;
        public String eventDescription;
        public int date;

        Event(String name, String content, int day) {
            eventName = name;
            eventDescription = content;
            date = day;
        }

    }
    Events(VBox s) {
        //clear screen of all nodes
        s.getChildren().clear();
        

        VBox eventsLayout = new VBox();
        GridPane calendarLayout = new GridPane();
        StackPane stackPane = new StackPane();
        // print current month on screen
        LocalDate currenDate = LocalDate.now();
        Month m = currenDate.getMonth();
        Label month = new Label(m.toString());
        eventsLayout.getChildren().add(month);
        eventsLayout.setAlignment(Pos.TOP_CENTER);
        Calendar c = Calendar.getInstance();
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // get starting coord values
        int col = LocalDate.of(currenDate.getYear(),
                                     currenDate.getMonth(),
                                      1).getDayOfWeek().getValue() - 1;
        // monday = 0, tuesday = 1, wed = 2, thu = 3, fri = 4, sat = 5, sunday= 6
        int row = 0;

        // populate gridpane with days
        for (int i = 1; i <= daysInMonth; i++) {
            ArrayList<Event> todaysEvents = new ArrayList<Event>();
            for (Event e: events) {
                if (e.date == i) {
                    todaysEvents.add(e);
                }
            }
            // if no events today, make an empty day else make full day
            Day  today = todaysEvents.isEmpty() ? new Day(i) : new Day(i, todaysEvents, stackPane);
            System.out.println(i);
            // add layout to calendar gridpane
            VBox todaysLayout = today.getLayout();
            System.out.println("Col: " + col + " Row: " + row); 
            calendarLayout.add(todaysLayout, col, row);
            // logic for row update
            row = col == 6 ? row + 1 : row;
            // is the day a sunday? if it is then col = 1 so the next one is on monday, else col++
            col = col > 5 ? 0 : col + 1;
           
        }
        eventsLayout.getChildren().add(calendarLayout);
        stackPane.getChildren().add(eventsLayout);
        s.getChildren().add(stackPane);
    }

   

    private class Day {
        VBox dayLayout = new VBox();
        Label day = new Label();
        

        //constructor for day with no events
        Day(int date) {
            day.setText(Integer.toString(date));
            dayLayout.getChildren().add(day);
        }

        //constructor for day with event(s)
        Day(int date, ArrayList<Event> events, StackPane stack) {
            day.setText(Integer.toString(date));
            dayLayout.getChildren().add(day);
            for (Event foo : events) {
                Button t = new Button(foo.eventName);
                t.setOnAction(e -> {
                    HBox hb = new HBox();
                    hb.setStyle("-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" + 
                    "-fx-border-radius: 5;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-color: black;" +
                    "-fx-background-color: white;");
                    hb.setAlignment(Pos.TOP_LEFT);
                    Label content = new Label(foo.eventDescription);
                    Button close = new Button("X");
                    close.setOnAction(ee -> {
                        stack.getChildren().remove(hb);
                    });
                    hb.getChildren().addAll(close, content);
                    stack.getChildren().add(hb);
                });
                dayLayout.getChildren().add(t);
            }
        }

        public VBox getLayout() {
            dayLayout.setPrefSize(50, 70);
            dayLayout.setStyle("-fx-border-width: 2;" +
                                "-fx-border-insets: 5;" + 
                                "-fx-border-radius: 5;" +
                                "-fx-border-style: solid inside;" +
                                "-fx-border-color: black;");
            return dayLayout;
        }
    }

}

