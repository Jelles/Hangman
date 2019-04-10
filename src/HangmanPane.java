import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class HangmanPane  extends Pane {

    private Shape[] shapes;
    private int turn;
    private MyScene scene;

    public HangmanPane(MyScene scene){
        this.scene = scene;
        shapes = new Shape[10];
        initShapes();
        setShapesColor(Color.WHITE);
    }

    // 9 Tries
    public void easyStart(){
        getChildren().addAll(shapes[0]);
        turn = 1;
    }

    // 7 Tries
    public void medStart(){
        getChildren().addAll(shapes[0],shapes[1],shapes[2]);
        turn = 3;
    }

    // 5 Tries
    public void hardStart(){
        getChildren().addAll(shapes[0],shapes[1],shapes[2],shapes[3],shapes[4]);
        turn = 5;
    }

    public void nextTurn(){
        if(turn == 9){
            scene.setLost();
            scene.end();
        }
        getChildren().add(shapes[turn]);
        turn++;
    }

    private void setShapesColor(Color color){
        for(Shape x : shapes){
            x.setFill(color);
        }
    }

    private void initShapes(){
        // Move 1
        Line move1 = new Line();
        move1.setStartX(75);
        move1.setStartY(30);
        move1.setEndX(75);
        move1.setEndY(250);
        shapes[0] = move1;

        // Move 2
        Line move2 = new Line();
        move2.setEndY(30);
        move2.setEndX(200);
        move2.setStartY(30);
        move2.setStartX(75);
        shapes[1] = move2;

        // Move 3
        Line move3 = new Line();
        move3.setStartX(100);
        move3.setStartY(30);
        move3.setEndX(75);
        move3.setEndY(55);
        shapes[2] = move3;

        // Move 4
        Line move4 = new Line();
        move4.setStartY(30);
        move4.setStartX(200);
        move4.setEndY(55);
        move4.setEndX(200);
        shapes[3] = move4;

        // Move 5
        Circle move5 = new Circle(200,75,20,Color.rgb(244,244,244));
        move5.setStroke(Color.BLACK);
        shapes[4] = move5;

        // Move 6
        Line move6 = new Line();
        move6.setStartX(200);
        move6.setStartY(95);
        move6.setEndX(200);
        move6.setEndY(175);
        shapes[5] = move6;

        // Move 7
        Line move7 = new Line();
        move7.setStartY(110);
        move7.setStartX(200);
        move7.setEndY(80);
        move7.setEndX(240);
        shapes[6] = move7;

        // Move 8
        Line move8 = new Line();
        move8.setStartY(110);
        move8.setStartX(200);
        move8.setEndY(80);
        move8.setEndX(160);
        shapes[7] = move8;

        // Move 9
        Line move9 = new Line();
        move9.setStartY(175);
        move9.setStartX(200);
        move9.setEndY(215);
        move9.setEndX(170);
        shapes[8] = move9;

        // Move 10
        Line move10 = new Line();
        move10.setStartY(175);
        move10.setStartX(200);
        move10.setEndY(215);
        move10.setEndX(230);
        shapes[9] = move10;
    }
}
