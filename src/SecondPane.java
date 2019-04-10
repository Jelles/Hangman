import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SecondPane extends VBox {

    private Insets padding;

    public SecondPane(MyScene scene){
        padding = new Insets(50,0,50,0);
        getStylesheets().add("second-pane.css");

        Button easyButton = new Button();
        Button mediumButton = new Button();
        Button hardButton = new Button();
        Button backButton = new Button();

        easyButton.setText("Easy");
        mediumButton.setText("Medium");
        hardButton.setText("Hard");
        backButton.setText("Back");

        easyButton.setOnAction(e -> scene.setEasy());
        mediumButton.setOnAction(e -> scene.setMedium());
        hardButton.setOnAction(e -> scene.setHard());
        backButton.setOnAction(e -> scene.backHome());

        easyButton.setPrefSize(250,60);
        mediumButton.setPrefSize(250,60);
        hardButton.setPrefSize(250,60);
        backButton.setPrefSize(250,60);

        BorderPane topPane = new BorderPane();
        BorderPane botPane = new BorderPane();
        BorderPane midTopPane = new BorderPane();
        BorderPane midBotPane = new BorderPane();


        topPane.setCenter(easyButton);
        midTopPane.setCenter(mediumButton);
        midBotPane.setCenter(hardButton);
        botPane.setCenter(backButton);

//        this.setTop(topPane);
//        this.setCenter(midPane);
//        this.setBottom(botPane);
        getChildren().addAll(topPane,midTopPane,midBotPane,botPane);
    }
}
