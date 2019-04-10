import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class FirstPane extends BorderPane {

    public FirstPane(MyScene scene){
        BorderPane topPane = new BorderPane();
        BorderPane botPane = new BorderPane();

        Button startButton = new Button();
        Button quitButton = new Button();

        startButton.setMaxSize(250, 60);
        quitButton.setMaxSize(250, 60);
        startButton.setPadding(new Insets(20,20,20,20));
        quitButton.setPadding(new Insets(20,20,20,20));

        startButton.setText("Start");
        quitButton.setText("Quit");

        quitButton.setOnAction(e -> scene.quit());
        startButton.setOnAction(e -> scene.start());

        topPane.setCenter(startButton);
        botPane.setCenter(quitButton);

        this.setPadding(new Insets(100,0,100,0));
        this.setTop(topPane);
        this.setBottom(botPane);
    }
}
