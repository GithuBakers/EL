package view.screens.stars;

import data.BoardInfor;
import data.CD;
import data.Diamond;
import javafx.animation.*;
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
 *
 * bugs:Which method will be called when the "start" button is pressed??
 * There'll be duplicated image in the game board when the START is pressed for the second time.
 */
public class StarGenerator {
    private AnchorPane anchorPane;
    private Point2D begin, end;
    private Diamond[][] src;
    private Diamond[][] old_information;
    private ImageView[][] starViews = new ImageView[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];

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
        //TODO:        Button generateNewStars=new Button("Refresh");
        //*********************

        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                Image image = StarSelector.getImage(src[i][j].kind);
                starViews[i][j] = new ImageView(image);
                starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                starViews[i][j].setLayoutY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * (CD.BOARD_SIZE_Y - 1 - j));
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

    private void generateNewStars() {
        src = BoardInfor.getBoardInformation();

        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                //如果被消除了或不存在
                if (src[i][j] == null) {
                    anchorPane.getChildren().remove(starViews[i][j]);
                    BoardManager.generateOne(i, j);
                    starViews[i][j] = new ImageView(StarSelector.getImage(src[i][j].kind));
                    starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                    starViews[i][j].setLayoutY(0);
                    anchorPane.getChildren().add(starViews[i][j]);
                    TranslateTransition transition = new TranslateTransition(Duration.seconds(2), starViews[i][j]);
                    System.out.println("starVs.getY=" + starViews[i][j].getY());
                    transition.setFromY(starViews[i][j].getY());
                    transition.setByY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * (CD.BOARD_SIZE_Y - 1 - j));
                    transition.setInterpolator(Interpolator.TANGENT(Duration.seconds(1), 1));
                    transition.play();
                    transition.setOnFinished(event -> System.out.println("finish"));
                    continue;
                }
                anchorPane.getChildren().remove(starViews[i][j]);
                starViews[i][j] = new ImageView(StarSelector.getImage(src[i][j].kind));
                starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                starViews[i][j].setLayoutY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * (CD.BOARD_SIZE_Y - 1 - j));
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
        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.seconds(2),
                        new KeyValue(starViews[x1][CD.BOARD_SIZE_Y - 1 - y1].translateXProperty(), dx, Interpolator.EASE_BOTH),
                        new KeyValue(starViews[x1][CD.BOARD_SIZE_Y - 1 - y1].translateYProperty(), dy, Interpolator.EASE_BOTH),
                        new KeyValue(starViews[x2][CD.BOARD_SIZE_Y - 1 - y2].translateXProperty(), -dx, Interpolator.EASE_BOTH),
                        new KeyValue(starViews[x2][CD.BOARD_SIZE_Y - 1 - y2].translateYProperty(), -dy, Interpolator.EASE_BOTH)));
        timeline1.play();
        if (!LogicUtilities.move(x1, CD.BOARD_SIZE_Y - 1 - y1, x2, CD.BOARD_SIZE_Y - 1 - y2)) {
            timeline1.setAutoReverse(true);
            timeline1.setCycleCount(2);
            timeline1.play();
        } else {
            timeline1.play();
            timeline1.setOnFinished(event ->
            {
//              Exchange the reference of the first diamond and the second one
                ImageView temp = starViews[x1][CD.BOARD_SIZE_Y - 1 - y1];
                starViews[x1][CD.BOARD_SIZE_Y - 1 - y1] = starViews[x2][CD.BOARD_SIZE_Y - 1 - y2];
                starViews[x2][CD.BOARD_SIZE_Y - 1 - y2] = temp;
                disappear();
                moveAnimator();
            });



        }
    }

    private void copyOldInformation() {
        old_information = new Diamond[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                old_information[i][j] = src[i][j];
            }
        }
    }


    private void disappear() {
        src = BoardInfor.getBoardInformation();
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                if (src[i][j] != null && src[i][j].isMatched() && !src[i][j].isSpecial()) {

                    starViews[i][j].setImage(StarSelector.getImage('x'));
                    System.out.println("I made starView" + i + "#" + j + " black");

                }
            }
        }
    }

    private void compareAndMove() {
        src = BoardInfor.getBoardInformation();
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                for (int k = 0; k < CD.BOARD_SIZE_Y; k++) {
                    if (old_information[i][j].equals(src[i][k])) {
                        System.out.println("I moved" + i + "#" + j);
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),
                                new KeyValue(starViews[i][j].translateYProperty(),
                                        (int) (starViews[i][j].getTranslateY() + (j - k) * (CD.DIAMOND_SIZE + CD.INTERVAL)), Interpolator.EASE_BOTH)));
                        timeline.play();
                    }
                }
            }
        }
    }

    private void moveAnimator() {
        copyOldInformation();
        printProperties(src);
        BoardManager.clean();
        compareAndMove();
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

    public static void printProperties(Diamond[][] src) {
        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                System.out.printf("%3x ", Integer.valueOf(src[i][j].toString().split("@")[4]));
            }
            System.out.println();
        }
        System.out.println("__________________________________");

        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                System.out.printf("%3x ", Integer.valueOf(src[i][j].toString().split("@")[3]));
            }
            System.out.println();
        }
        System.out.println("__________________________________");
    }

}
