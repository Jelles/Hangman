import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EndPane extends StackPane {

	private Text gameStatus;
	private Button quitButton;
	private Button homeButton;
	private VBox buttonsPane;

	public EndPane(MyScene scene) {
		getStylesheets().add("end-pane.css");

		gameStatus = new Text();
		buttonsPane = new VBox();
		quitButton = new Button();
		homeButton = new Button();

		quitButton.setText("Quit");
		homeButton.setText("Home Screen");

		quitButton.setOnAction(e -> scene.quit());
		homeButton.setOnAction(e -> scene.home());

		buttonsPane.getChildren().addAll(quitButton,homeButton);
		getChildren().addAll(buttonsPane,gameStatus);
	}

	public void setLost(String word) {
		gameStatus.setText("Sadly you lost the game...\n\nBetter luck next time!\n\nThe word was: " + word);
	}

	public void setWon(String word) {
		gameStatus.setText("Congratulations!\n\nYou've won the game.\n\nThe word was: " + word);
	}
}
