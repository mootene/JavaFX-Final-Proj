package yalearts;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;

public class News {
    private class NewsPost {
        public Text content; 
        public Button title;
        public Boolean isClicked = false;
        public NewsPost(String t, String c) {
            title = new Button(t);
            content = new Text(c);
        }
    
        public void setTitle(String t) {
            title.setText(t);
        }

        public void setContent(String c) {
            content.setText(c);
        }
    }
    // TODO create news list
    NewsPost news1 = new NewsPost("TEST", "CONTENT");
    NewsPost news2 = new NewsPost("TEST 2", "CONTENT 2");
    NewsPost[] news = {news1, news2};
    
    News(VBox vb) {
        System.out.println("in News(vb)");
       
        vb.getChildren().clear();
        vb.setAlignment(Pos.CENTER);
        for (NewsPost n : news) {
            vb.getChildren().add(n.title);

            n.title.setOnAction(e -> {
                n.isClicked = !n.isClicked;
                int i = vb.getChildren().indexOf(n.title);
                if (n.isClicked) {
                    vb.getChildren().add(i + 1, n.content);
                } else {
                    vb.getChildren().remove(i + 1);
                }
            });
        }
        
    }
}
