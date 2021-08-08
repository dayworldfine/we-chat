package cn.chat.ui.view.chat.element.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * @ClassName：ElementFriendTag
 * @Description: 占位标签；新的朋友、公众号、群组、好友
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class ElementFriendTag {

    private Pane pane;

    public ElementFriendTag(String tagText){
        pane = new Pane();
        pane.setPrefSize(270, 24);
        pane.setStyle("-fx-background-color: transparent;");
        ObservableList<Node> children = pane.getChildren();

        Button label = new Button();
        label.setPrefSize(260,24);
        label.setLayoutX(5);
        label.setText(tagText);
        label.getStyleClass().add("element_friend_tag");
        children.add(label);

    }

    public Pane pane() {
        return pane;
    }

}
