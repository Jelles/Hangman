import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class WordPane extends BorderPane {

    private MyScene scene;
    private String randomWord;
    private char[] allCharWord;
    private ArrayList<Text> wordChars;
    private ArrayList<Node> allNodes;
    private ArrayList<Line> lines;
    private HangmanPane hangmanPane;
    private int correctGuesses;

    public WordPane(MyScene scene, HangmanPane hangmanPane) {
        this.scene = scene;
        this.hangmanPane = hangmanPane;
        randomWord = scene.getRandomWord().toLowerCase();
        setPadding(new Insets(10, 0, 0, 0));


        allCharWord = randomWord.toCharArray();
        lines = new ArrayList<Line>();
        wordChars = new ArrayList<Text>();
        allNodes = new ArrayList<Node>();


        int startPos = 10;
        for (char x : allCharWord) {
            Text wordChar = new Text(Character.toString(x));
            Line line = new Line();
            wordChar.setX(startPos);
            wordChar.setY(25);
            line.setEndX(startPos);
            line.setEndY(30);
            line.setStartX(startPos + 10);
            line.setStartY(30);
            startPos += 20;
            lines.add(line);
            wordChars.add(wordChar);
        }

        allNodes.addAll(lines);
        getChildren().addAll(allNodes);
    }

    public String getRandomWord() {
        return this.randomWord;
    }

    public void checkChar(char c) {
        int i = 0;
        boolean correctGuess = false;
        for (char x : allCharWord) {
            if (x == c) {
                getChildren().add(wordChars.get(i));
                correctGuess = true;
                correctGuesses++;
                if(allCharWord.length == correctGuesses){
                    scene.setWon();
                    scene.end();
                    return;
                }
            }
            i++;
        }
        if(correctGuess){
            return;
        }
        hangmanPane.nextTurn();
    }
}
