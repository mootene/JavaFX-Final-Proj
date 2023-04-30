package yalearts;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;

public class News {
    private class NewsPost {
        Text content; 
        Button title;
        public NewsPost(String t, String c) {
            content.setText(c);
            title.setText(t);
        }
        public NewsPost(VBox vb) {
            content = new Text();
            title = new Button();
            title.setOnAction(e -> {
                int i = vb.getChildren().indexOf(title);
                vb.getChildren().add(i + 1, content);
            });
        }
        public void setTitle(String t) {
            title.setText(t);
        }

        public void setContent(String c) {
            content.setText(c);
        }
    }
    private List<NewsPost> newsPosts = new ArrayList<NewsPost>(); 
    private ObservableList<NewsPost> news = FXCollections.observableList(newsPosts);
    
    public String getNews() {
        return "TODO";
    }

    private void setNews(VBox vb) {
        TextField titleInput = new TextField("Set Title");
        TextField contentInput = new TextField("Set content");
        vb.getChildren().removeAll();
        vb.getChildren().addAll(titleInput, contentInput);
        NewsPost newPost = new NewsPost(vb);

        newPost.setTitle(titleInput.getText());
        newPost.setContent(contentInput.getText());
    }


    News(VBox vb) {
        VBox nlayout = new VBox();
        nlayout.setAlignment(Pos.CENTER);
        Button update = new Button("Add new post");
        update.setOnAction(e -> {
            setNews(nlayout);
        });
        for (NewsPost n : news) {
            nlayout.getChildren().add(n.title);
        }
        vb.getChildren().removeAll();
        vb.getChildren().addAll(nlayout, update);

    }
}
