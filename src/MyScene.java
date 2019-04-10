import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class MyScene extends Scene {

    private BorderPane rootPane;
    private FirstPane firstPane;
    private SecondPane secondPane;
    private ThirdPane thirdPane;
    private ArrayList<String> wordList;
    private EndPane endPane;

    public MyScene() {
        super(new Pane(), 400,600);
        reset();
    }

    private void reset(){
        wordList = new ArrayList<String>();
        initWordList();
        rootPane = new BorderPane();
        firstPane = new FirstPane(this);
        secondPane = new SecondPane(this);
        thirdPane = new ThirdPane(this);
        endPane = new EndPane(this);
        rootPane.setCenter(firstPane);
        setRoot(rootPane);
    }

    private void initWordList(){
        wordList.add("cheese");
        wordList.add("apple");
        wordList.add("horse");
        wordList.add("sausage");
        wordList.add("house");
        wordList.add("car");
        wordList.add("mouse");
    }

    public String getRandomWord(){
        Random rnd = new Random();
        return wordList.get(rnd.nextInt(wordList.size()));
    }

    public void quit() {
        System.exit(0);
    }

    public EndPane getEndPane(){
        return this.endPane;
    }

    public ThirdPane getThirdPane(){
        return this.thirdPane;
    }

    public HangmanPane getHangmanPane(){
        return this.thirdPane.getHangmanPane();
    }

    public void setWon(){
        getEndPane().setWon(getThirdPane().getWordPane().getRandomWord());
    }

    public void setLost(){
        getEndPane().setLost(getThirdPane().getWordPane().getRandomWord());
    }

    public void end(){
        rootPane.setCenter(endPane);
    }

    public void home(){
        rootPane.setCenter(firstPane);
        reset();
    }

    public void start() {
        rootPane.setCenter(secondPane);
    }

    public void setEasy() {
        thirdPane.setEasy();
        rootPane.setCenter(thirdPane);
    }

    public void setMedium() {
        thirdPane.setMedium();
        rootPane.setCenter(thirdPane);
    }

    public void setHard() {
        thirdPane.setHard();
        rootPane.setCenter(thirdPane);
    }

    public void backHome() {
        rootPane.setCenter(firstPane);
    }
}
