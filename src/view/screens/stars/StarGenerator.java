package view.screens.stars;

import data.BoardInfor;
import data.CD;
import data.Diamond;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import logic.BoardManager;
import logic.Judge;
import logic.LogicUtilities;
import logic.Match;

import java.util.ArrayList;

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
    private int[] disapperaCnt;
    int cntxxz = 0;

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

    synchronized public void go() {
//        anchorPane.setCursor(new ImageCursor(new Image());
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
        //TODO:to be deleted
        anchorPane.setOnMouseClicked(click -> {
            if (click.getClickCount() == 3) {
                System.out.println("here");
                refresh();
                ObservableList list = anchorPane.getChildren();
                System.out.println("pause");
            }
        });

    }

    synchronized private void generateNewStars() {
        src = BoardInfor.getBoardInformation();
        ArrayList<Timeline> timeline = new ArrayList<>();
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = CD.BOARD_SIZE_Y - 1; j >= 0; j--) {

                //如果被消除了或不存在
                if (src[i][j] == null) {
                    BoardManager.generateOne(i, j);
                    ImageView temp = new ImageView(StarSelector.getImage(src[i][j].kind));
                    temp.setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                    int bias = -j * (CD.INTERVAL + CD.DIAMOND_SIZE);
                    temp.setLayoutY(bias);
                    anchorPane.getChildren().add(temp);
                    timeline.add(0, new Timeline(new KeyFrame(Duration.seconds(1),
                            new KeyValue(temp.translateYProperty(), 8 - bias + CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * (CD.BOARD_SIZE_Y - 1 - j), Interpolator.TANGENT(Duration.seconds(1), -1))
                    ),
                            new KeyFrame(Duration.seconds(1.3),
                                    new KeyValue(temp.translateYProperty(), -bias + CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * (CD.BOARD_SIZE_Y - 1 - j), Interpolator.TANGENT(Duration.seconds(1), -1)))
                    ));

                    disapperaCnt[i]--;
                    System.out.println("the disappear" + i + " is" + disapperaCnt[i]);
                    timeline.get(0).play();

                    System.out.println(cntxxz++);
                    timeline.get(0).setOnFinished(event -> {


                        System.out.println(anchorPane.getChildren().remove(temp));

                    });

//                    }
                }
            }
        }
        int cnt = 0;
        System.out.println(cnt++);
        timeline.get(0).setOnFinished(event -> {
            System.out.println(anchorPane.getChildren().remove(anchorPane.getChildren().size() - 1));
            System.out.println("count here");
            refresh();
            if (Judge.isUnfinished()) {
                Match.mark();
                moveAnimator();
            }
        });

    }

    synchronized private void refresh() {
        System.out.println("fresh has been called");
        src = BoardInfor.getBoardInformation();
        print(src);
//        anchorPane.getChildren().remove(1,anchorPane.getChildren().size());
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                anchorPane.getChildren().removeAll(starViews[i][j]);

//                System.out.println("I've removed "+i+"#"+j);

                starViews[i][j] = new ImageView(StarSelector.getImage(src[i][j].kind));
                starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                starViews[i][j].setLayoutY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * (CD.BOARD_SIZE_Y - 1 - j));
                anchorPane.getChildren().add(starViews[i][j]);
            }
        }

    }

    synchronized private void setBegin(Point2D point2D) {
        begin = point2D;
    }

    synchronized private void setEnd(Point2D point2D) {
        end = point2D;
    }

    synchronized private void moveAStep() {
        int x1 = (int) begin.getX(), y1 = (int) begin.getY();
        int x2 = (int) end.getX(), y2 = (int) end.getY();
        int dx = (int) (end.getX() - begin.getX()) * (CD.DIAMOND_SIZE + CD.INTERVAL);
        int dy = (int) (end.getY() - begin.getY()) * (CD.DIAMOND_SIZE + CD.INTERVAL);
        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.seconds(0.5),
                        new KeyValue(starViews[x1][CD.BOARD_SIZE_Y - 1 - y1].translateXProperty(), dx, Interpolator.EASE_BOTH),
                        new KeyValue(starViews[x1][CD.BOARD_SIZE_Y - 1 - y1].translateYProperty(), dy, Interpolator.EASE_BOTH),
                        new KeyValue(starViews[x2][CD.BOARD_SIZE_Y - 1 - y2].translateXProperty(), -dx, Interpolator.EASE_BOTH),
                        new KeyValue(starViews[x2][CD.BOARD_SIZE_Y - 1 - y2].translateYProperty(), -dy, Interpolator.EASE_BOTH)));

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
                moveAnimator();
            });



        }
    }

    synchronized private void copyOldInformation() {
        old_information = new Diamond[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                old_information[i][j] = src[i][j];
            }
        }
    }


    synchronized private void disappear() {
        src = BoardInfor.getBoardInformation();
        disapperaCnt = new int[CD.BOARD_SIZE_X];
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            disapperaCnt[i] = 0;
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                if (src[i][j] != null && src[i][j].isMatched() && !src[i][j].isSpecial()) {
                    disapperaCnt[i]++;
                    starViews[i][j].setImage(StarSelector.getImage('x'));
                    System.out.println("I made starView" + i + "#" + j + " black");

                }
            }
        }
    }

    synchronized private void compareAndMove() {
        src = BoardInfor.getBoardInformation();
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                for (int k = 0; k < CD.BOARD_SIZE_Y; k++) {
                    if (old_information[i][j].equals(src[i][k])) {
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                                new KeyValue(starViews[i][j].translateYProperty(),
                                        (int) (starViews[i][j].getTranslateY() + (j - k) * (CD.DIAMOND_SIZE + CD.INTERVAL)), Interpolator.EASE_BOTH)));
                        timeline.play();
                    }
                }
            }
        }
    }

    synchronized private void moveAnimator() {
        disappear();
        copyOldInformation();
        BoardManager.clean();
        compareAndMove();
        generateNewStars();
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
