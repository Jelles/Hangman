import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class EndPane extends BorderPane {

	private Text gameStatus;
	private BorderPane topPane;
	private BorderPane botPane;
	private Button quitButton;
	private Button homeButton;
	
	public EndPane(MyScene scene) {
		gameStatus = new Text();

		topPane = new BorderPane();
		botPane = new BorderPane();

		quitButton = new Button();
		homeButton = new Button();

		quitButton.setText("Quit");
		homeButton.setText("Home Screen");

		quitButton.setOnAction(e -> scene.quit());
		homeButton.setOnAction(e -> scene.home());

		homeButton.setMaxSize(250, 60);
		quitButton.setMaxSize(250, 60);

		homeButton.setPadding(new Insets(20, 20, 20, 20));
		quitButton.setPadding(new Insets(20, 20, 20, 20));

		topPane.setCenter(homeButton);
		botPane.setCenter(quitButton);

		setTop(topPane);
		setBottom(botPane);
		setCenter(gameStatus);
		this.setPadding(new Insets(100, 0, 100, 0));
	}

	public void setLost(String word) {
		gameStatus.setText("Sadly you lost the game..\n Better luck next time!\n\n The word was: " + word);
	}

	public void setWon(String word) {
		gameStatus.setText("You've won the game.\n Congratulations! \n\n The word was: " + word);
	}
}
