package yalearts;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.geometry.Insets;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Events {
    


    Event e1 = new Event("On Collaboration: Qween Jean + Ryan McGinley in Conversation", 
                        "Free and open to the public. All visitors are required to be fully vaccinated and boosted, and should be prepared to show proof of this if asked. Masks are strongly recommended, as per capacity protocol management.On Collaboration, a conversation between Ryan McGinley and Qween Jean about how their artistic collaboration intersects with their independent practices, specifically how Qween Jean worked with other artists in organizing the Stonewall Protests in Brooklyn during the summer of 2020, and Ryan McGinley was one of a group of photographers documenting the protests. Since 2020, McGinley continues to document protests, community gatherings, retreats, and the mutual aids of Qween Jean’s organization Black Trans Liberation. Ryan McGinley and Qween Jean collaborated on the recent publication of Revolution is Love by Aperture.",
                        3);
    Event[] events = {e1};

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
        s.setAlignment(Pos.CENTER);

        Text pageTitle;
        Text body1Title;

        VBox vboxTitle = new VBox();
        VBox vboxBody1 = new VBox();

        //title for page
        pageTitle = new Text("Public Events");
        pageTitle.setWrappingWidth(500);
        pageTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));

        //vbox title
        vboxTitle.getChildren().addAll(pageTitle);

        //title vbox placement
        vboxTitle.setPadding(new Insets(10,0,10,0));
        vboxTitle.setAlignment(Pos.CENTER);

        //body text
        body1Title = new Text(
                "Welcome to the School of Art’s public events calendar, initiated in the summer of 2020. To stay updated on new events as they’re confirmed, all members of the public are invited to subscribe this calendar to their own calendaring software by clicking the “Subscribe” button below. ");
        body1Title.setWrappingWidth(700);

        //vbox body text
        vboxBody1.getChildren().addAll(body1Title);

        //body text vbox placement
        vboxBody1.setPadding(new Insets(10, 0, 10, 0));
        vboxBody1.setAlignment(Pos.CENTER);

        

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
            for (Event e : events) {
                if (e.date == i) {
                    todaysEvents.add(e);
                }
            }
            // if no events today, make an empty day else make full day
            Day today = todaysEvents.isEmpty() ? new Day(i) : new Day(i, todaysEvents, stackPane);
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
        

        eventsLayout.getChildren().addAll(vboxTitle,vboxBody1,calendarLayout);
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
                    hb.setPrefSize(400, 600);
                    hb.setStyle("-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" + 
                    "-fx-border-radius: 5;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-color: black;" +
                    "-fx-background-color: white;");
                    hb.setAlignment(Pos.TOP_LEFT);
                    Label content = new Label(foo.eventDescription);
                    content.setWrapText(true);
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

            dayLayout.setPrefSize(180, 200);
            dayLayout.setStyle("-fx-border-width: 2;" +
                                "-fx-border-insets: 5;" + 
                                "-fx-border-radius: 5;" +
                                "-fx-border-style: solid inside;" +
                                "-fx-border-color: black;");
            return dayLayout;
        }
    }

}

