import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ThirdPane extends BorderPane {

    private HangmanPane hangmanPane;
    private ButtonPanes buttonPanes;
    private WordPane wordPane;
    private GuessBoxPane guessBoxPane;
    private VBox bottomPane;

    public ThirdPane(MyScene scene){
        hangmanPane = new HangmanPane(scene);
        wordPane = new WordPane(scene, hangmanPane);
        buttonPanes = new ButtonPanes(wordPane);
        guessBoxPane = new GuessBoxPane(scene);
        bottomPane = new VBox();

        BorderPane topPane = new BorderPane();
        BorderPane botPane = new BorderPane();

        topPane.setCenter(buttonPanes);
        botPane.setCenter(guessBoxPane);

        bottomPane.getChildren().addAll(topPane, botPane);
        setTop(wordPane);
        setCenter(hangmanPane);
        setBottom(bottomPane);
    }

    public WordPane getWordPane(){
        return this.wordPane;
    }

    public HangmanPane getHangmanPane(){
        return this.hangmanPane;
    }

    public void setEasy() {
        hangmanPane.easyStart();
    }

    public void setMedium() {
        hangmanPane.medStart();
    }

    public void setHard() {
        hangmanPane.hardStart();
    }
}
