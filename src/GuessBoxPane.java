import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GuessBoxPane extends BorderPane {

    private TextField guessBox;
    private Text text;
    private VBox centerPane;
    private BorderPane botPane;
    private BorderPane topPane;
    private MyScene scene;

    public GuessBoxPane(MyScene scene){
        this.scene = scene;
        topPane = new BorderPane();
        botPane = new BorderPane();
        centerPane = new VBox();
        text = new Text("Put your guess here.\n");
        guessBox = new TextField();
        guessBox.setOnAction(e -> checkWord());

        topPane.setCenter(text);
        botPane.setCenter(guessBox);
        centerPane.getChildren().addAll(topPane ,botPane);
        setCenter(centerPane);

        this.setPadding(new Insets(20,20,20,20));
    }

    private void checkWord() {
        String word = scene.getThirdPane().getWordPane().getRandomWord();
        String guess = guessBox.getText().toLowerCase();
        if(guess.length() == word.length()){
            if(word.equals(guess)){
                scene.setWon();
                scene.end();
                return;
            }
            scene.getHangmanPane().nextTurn();
        }
    }
}
