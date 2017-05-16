package view.screens.stars;

import data.BoardInfor;
import data.CD;
import data.Diamond;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import logic.BoardManager;
import logic.LogicUtilities;

import static data.CD.BOARD_SIZE_X;
import static data.CD.BOARD_SIZE_Y;

/**
 * Created by Bay on 2017/5/15 0015.
 * 贩卖星星与钻石的黑市商人----翔哲
 */
public class StarGenerator {
    private AnchorPane anchorPane;
    private Point2D begin, end;
    Diamond[][] src = BoardInfor.getBoardInformation();
    ImageView[][] starViews = new ImageView[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];

    public StarGenerator(AnchorPane anchorPane){
        this.anchorPane=anchorPane;


        char[][] sample1 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'f', 'c', 'd'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        toTest(sample1);
        go();
    }

    public void go() {
        src = BoardInfor.getBoardInformation();
        starViews = new ImageView[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];
        //TODO:        Button refresh=new Button("Refresh");
        //        anchorPane.getChildren().add(refresh);
        //*********************

        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                Image image = StarSelecter.getImage(src[i][j].kind);
                starViews[i][j] = new ImageView(image);
                starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                starViews[i][j].setLayoutY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * j);
                anchorPane.getChildren().add(starViews[i][j]);
            }
        }
        anchorPane.setOnDragDetected(drag -> {
            anchorPane.startFullDrag();
            Point2D point2D = LogicUtilities.mouseMagnet(new Point2D(drag.getX(), drag.getY()));
            setBegin(point2D);
        });
        anchorPane.setOnMouseDragReleased(drag -> {
            setEnd(LogicUtilities.mouseMagnet(new Point2D(drag.getX(), drag.getY())));
            moveAStep();

        });

    }

    private void fresh() {
        src = BoardInfor.getBoardInformation();
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                anchorPane.getChildren().remove(starViews[i][j]);
                Image image = StarSelecter.getImage(src[i][j].kind);
                starViews[i][j] = new ImageView(image);
                starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                starViews[i][j].setLayoutY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * j);
                anchorPane.getChildren().add(starViews[i][j]);
            }
        }
    }

    private void setBegin(Point2D point2D) {
        begin = point2D;
    }

    private void setEnd(Point2D point2D) {
        end = point2D;
    }

    private void moveAStep() {
        int x1 = (int) begin.getX(), y1 = (int) begin.getY();
        int x2 = (int) end.getX(), y2 = (int) end.getY();
        int dx = (int) (end.getX() - begin.getX()) * (CD.DIAMOND_SIZE + CD.INTERVAL);
        int dy = (int) (end.getY() - begin.getY()) * (CD.DIAMOND_SIZE + CD.INTERVAL);
        TranslateTransition translate1 = new TranslateTransition(Duration.seconds(2), starViews[x1][y1]);
        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(2), starViews[x2][y2]);
        translate1.setFromX(starViews[x1][y1].getX());
        translate1.setFromY(starViews[x1][y1].getY());
        translate1.setByX(dx);
        translate1.setByY(dy);
//        translate1.play();
        translate2.setFromX(starViews[x2][y2].getX());
        translate2.setFromY(starViews[x2][y2].getY());
        translate2.setByX(-dx);
        translate2.setByY(-dy);
        translate1.setInterpolator(Interpolator.SPLINE(.7, .1, .7, .1));
//        translate2.play();
        ParallelTransition parallelTransition = new ParallelTransition(translate1, translate2);
        print(src);
        if (!LogicUtilities.move(x1, y1, x2, y2)) {
            System.out.println("here");
            parallelTransition.setAutoReverse(true);
            parallelTransition.setCycleCount(2);
            parallelTransition.play();
        } else {
            parallelTransition.play();
            parallelTransition.setOnFinished(event ->
            {
                fresh();
                BoardManager.clean();
                print(src);
                BoardManager.generateSpace();
                print(src);
                fresh();
            });

//            print(src);


        }
    }

    //下面几个方法都是测试用的
    public static void print(Diamond[][] src) {
        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                if (src[i][j] != null) {
                    System.out.print(" " + src[i][j].toString().charAt(0) + " ");
                } else {
                    System.out.print(" " + "#" + " ");
                }
            }
            System.out.println();
        }
        System.out.println("__________________________________");
    }

    public static void toTest(char[][] c) {
        Diamond[][] diamonds = new Diamond[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                diamonds[i][j] = new Diamond(c[i][j], i, j);
            }
        }
        BoardInfor.setBoardInformation(diamonds);
    }

}
