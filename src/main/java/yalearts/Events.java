package yalearts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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

    Events(VBox s) throws FileNotFoundException {
        
        //clear screen of all nodes
        s.getChildren().clear();
        s.setAlignment(Pos.CENTER);

        Text pageTitle;
        Text body1Title;

        VBox vboxTitle = new VBox();
        VBox vboxBody1 = new VBox();

        //title for page
        pageTitle = new Text("Public Events");
        pageTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
        Label subtitle = new Label("HOSTED BY THE YALE SCHOOL OF THE ARTS");
        subtitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
        Label addy = new Label("Yale School of Art 1156 Chapel Street, POB \n208339 New Haven, Connecticut,\n06520-8339");
        addy.setTextAlignment(TextAlignment.CENTER);
        //vbox title
        vboxTitle.getChildren().addAll(pageTitle, subtitle, addy);

        //title vbox placement
        vboxTitle.setPadding(new Insets(10,0,10,0));
        vboxTitle.setAlignment(Pos.CENTER);
        vboxTitle.setSpacing(10);

        //body text
        body1Title = new Text(
                "Welcome to the School of Art’s public events calendar, initiated in\nthe summer of 2020. To stay updated on new events as they’re \nconfirmed, all members of the public are invited to subscribe this\ncalendar to their own calendaring software by clicking the \n“Subscribe” button below. ");
        Label body1 = new Label("For events open to the Yale community, view our Yale Calendar\nlistings at bit.;y/SoACalendar >>");
        //vbox body text
        vboxBody1.getChildren().addAll(body1Title, body1);

        //body text vbox placement
        vboxBody1.setPadding(new Insets(10, 0, 10, 0));
        vboxBody1.setAlignment(Pos.CENTER);
        vboxBody1.setSpacing(20);

        

        VBox eventsLayout = new VBox();
        GridPane calendarLayout = new GridPane();
        StackPane stackPane = new StackPane();
        // print current month on screen
        LocalDate currenDate = LocalDate.now();
        Month m = currenDate.getMonth();
        Label month = new Label(m.toString());
        month.setStyle("-fx-font-size: 24pt;");
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

        stackPane.getChildren().add(calendarLayout);
        eventsLayout.getChildren().addAll(month, stackPane);
        eventsLayout.setAlignment(Pos.CENTER);
        StackPane lowerThird = lowerBox();
        BorderPane bp = new BorderPane();
        bp.setAlignment(eventsLayout, Pos.CENTER);
        bp.setMargin(eventsLayout, new Insets(10, 200, 50, 300));
        bp.setCenter(eventsLayout);
        VBox topThird = new VBox(vboxTitle, vboxBody1);
        bp.setAlignment(topThird, Pos.CENTER);
        bp.setTop(topThird);
        s.getChildren().addAll(bp, lowerThird);
        s.setAlignment(Pos.CENTER);
    }

    StackPane lowerBox() throws FileNotFoundException {
        String HOVER_STYLE = "-fx-background-color: white;" + "-fx-text-fill: #2B50BA;";
        String IDLE_STYLE = "-fx-background-color: #2B50BA;" + "-fx-text-fill: white;";
        VBox vb = new VBox();
        vb.setPrefWidth(700);
        vb.setMaxHeight(300);
        vb.setSpacing(5);
        StackPane stack = new StackPane();

        Label l1 = new Label("Public events hosted by the Yale School of Arts are also posted on");
        l1.setStyle("-fx-text-fill: black;");
        Button fb = new Button("Facebook Events");
        fb.setStyle(IDLE_STYLE);
        fb.setOnMouseEntered(e -> fb.setStyle(HOVER_STYLE));
        fb.setOnMouseExited(e -> fb.setStyle(IDLE_STYLE));
        Button insta = new Button("Instagram Events");
        insta.setStyle(IDLE_STYLE);
        insta.setOnMouseEntered(e -> insta.setStyle(HOVER_STYLE));
        insta.setOnMouseExited(e -> insta.setStyle(IDLE_STYLE));
        HBox hb1 = new HBox(fb, insta);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(10);
        vb.getChildren().addAll(l1, hb1);

        Label l2 = new Label("\n\nFor a calendar of exhibitions and events hosted/led/featured by members of the School of Arts \ncommunity,");
        l2.setStyle("-fx-text-fill: black;");
        Button world = new Button("Yale School of Art in the World");
        world.setStyle(IDLE_STYLE);
        world.setOnMouseEntered(e -> world.setStyle(HOVER_STYLE));
        world.setOnMouseExited(e -> world.setStyle(IDLE_STYLE));
        HBox hb2 = new HBox(world);
        hb2.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(l2, hb2);

        Label l3 = new Label("\n\nFor questions, please email the School of the Arts Communications Associate");
        l3.setStyle("-fx-text-fill: black;");
        Label contact = new Label("Lindsey Mancini");
        contact.setUnderline(true);
        contact.setStyle("-fx-text-fill: black;");
        contact.setOnMouseEntered(e -> contact.setStyle("-fx-text-fill: #2B50BA;"));
        contact.setOnMouseExited(e -> contact.setStyle("-fx-text-fill: black;"));
        vb.getChildren().addAll(l3, contact);

        vb.setStyle("-fx-background: transparent; -fx-background-color: rgba(255, 255, 255, 0.5); ");
        vb.setPrefWidth(700);
        vb.setAlignment(Pos.TOP_CENTER);
        
        Image image = new Image(new FileInputStream("src/main/java/yalearts/eventspage.png"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(false);
        imageView.setFitHeight(1000);
        imageView.setFitWidth(1930);
        stack.getChildren().add(imageView);
        stack.setMargin(vb, new Insets(10, 615, 690, 615));
        stack.getChildren().add(vb);
        return stack;
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

