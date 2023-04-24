package yalearts;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class News {
    private class NewsPost {
        Text content; 
        Button title;
        
        public NewsPost() {
            content = new Text();
            title = new Button();
            title.setOnAction(e -> {
                
            });
        }
        public void setTitle(String t) {
            title.setText(t);
        }

        public void setContent(String c) {
            content.setText(c);
        }
    }
    private NewsPost[] news;

    public String getNews() {
        return "TODO";
    }

    private void setNews() {
        TextField titleInput = new TextField("Set Title");
        TextField contentInput = new TextField("Set content");

        NewsPost newPost = new NewsPost();

        newPost.setTitle(titleInput.getText());
        newPost.setContent(contentInput.getText());
    }


    public void PublicEvents() {
        VBox nlayout = new VBox();
        nlayout.setAlignment(Pos.CENTER);

        for (NewsPost n : news) {
            nlayout.getChildren().add(n.title);
        }

    }
}
