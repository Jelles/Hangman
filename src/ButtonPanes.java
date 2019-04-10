import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;

public class ButtonPanes extends TilePane {

    private ArrayList<Pane>panes;
    private WordPane wordPane;

    public ButtonPanes(WordPane wordPane){
        this.wordPane = wordPane;
        panes = new ArrayList<Pane>();
        for(char x = 'a'; x <= 'z'; x++){
            Pane pane = new Pane();
            pane.setPrefSize(50,50);
            Button button = new Button();
            button.setPrefSize(40,40);
            pane.setPadding(new Insets(10,10,10,10));
            button.setText(Character.toString(x));
            button.setOnAction(e -> checkChar(button));
            pane.getChildren().add(button);
            panes.add(pane);
        }
        setPadding(new Insets(0,0,0,30));
        getChildren().addAll(panes);
    }

    private void checkChar(Button button) {
        char buttonChar = button.getText().toCharArray()[0];
        button.setDisable(true);
        wordPane.checkChar(buttonChar);
    }
}