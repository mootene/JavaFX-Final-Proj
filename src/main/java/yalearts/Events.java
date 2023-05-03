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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Events {
    Event[] events;

    Events(VBox vb) {
        //clear screen of all nodes
        vb.getChildren().removeAll();
        HBox hb = new HBox();
        Button add = new Button("+");

        VBox eventsLayout = new VBox();
        GridPane calendarLayout = new GridPane();

        // print current month on screen
        LocalDate currenDate = LocalDate.now();
        Month m = currenDate.getMonth();
        Label month = new Label(m.toString());
        eventsLayout.getChildren().add(month);

        Calendar c = Calendar.getInstance();
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // get starting coord values
        String column = LocalDate.of(currenDate.getYear(),
                                     currenDate.getMonth(),
                                      1).getDayOfWeek().toString();
        int col = Integer.parseInt(column);
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
            Day  today = todaysEvents.isEmpty() ? new Day(i) : new Day(i, todaysEvents.toArray());
            //get coord of current day
            
    
            // add layout to calendar gridpane
            VBox todaysLayout = today.getLayout();
            calendarLayout.add(todaysLayout, col, row);
        }
    }

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

    private class Day {
        VBox dayLayout = new VBox();
        Label day = new Label();

        //constructor for day with no events
        Day(int date) {
            day.setText(Integer.toString(date));
        }

        //constructor for day with event(s)
        Day(int date, Event[] events) {
            day.setText(Integer.toString(date));
            dayLayout.getChildren().add(day);
            for (Event foo : events) {
                Button t = new Button(foo.eventName);
                t.setOnAction(e -> {
                    // TODO show description on click
                });
                dayLayout.getChildren().add(t);
            }
        }

        public VBox getLayout() {
            return dayLayout;
        }
    }

}

