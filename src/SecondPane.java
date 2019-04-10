import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class SecondPane extends BorderPane {

    private Insets padding;

    public SecondPane(MyScene scene){
        padding = new Insets(50,0,50,0);

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
        BorderPane midPane = new BorderPane();
        BorderPane botPane = new BorderPane();
        BorderPane midTopPane = new BorderPane();
        BorderPane midBotPane = new BorderPane();

        midPane.setTop(midTopPane);
        midPane.setBottom(midBotPane);

        topPane.setCenter(easyButton);
        midTopPane.setCenter(mediumButton);
        midBotPane.setCenter(hardButton);
        botPane.setCenter(backButton);

        midTopPane.setPadding(padding);
        midBotPane.setPadding(padding);
        this.setPadding(padding);

        this.setTop(topPane);
        this.setCenter(midPane);
        this.setBottom(botPane);
    }
}
