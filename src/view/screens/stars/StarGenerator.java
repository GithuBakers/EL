package view.screens.stars;

import data.BoardInfor;
import data.CD;
import data.Diamond;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.LogicUtilities;

import static data.CD.BOARD_SIZE_X;
import static data.CD.BOARD_SIZE_Y;

/**
 * Created by Bay on 2017/5/15 0015.
 * 贩卖星星与钻石的黑市商人----翔哲
 */
public class StarGenerator {
    private AnchorPane anchorPane;

    public StarGenerator(AnchorPane anchorPane){
        this.anchorPane=anchorPane;
        go();
    }

    public void go() {
        Diamond[][] src = BoardInfor.getBoardInformation();
        ImageView[][] starViews = new ImageView[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];
        //TODO:        Button refresh=new Button("Refresh");
        //        anchorPane.getChildren().add(refresh);
        //*********************
        print(src);
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                Image image = StarSelector.getImage(src[i][j].kind);
                starViews[i][j] = new ImageView(image);
                starViews[i][j].setLayoutX(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * i);
                starViews[i][j].setLayoutY(CD.LAYOUT_INTERVAL + (CD.DIAMOND_SIZE + CD.INTERVAL) * j);
                anchorPane.getChildren().add(starViews[i][j]);
            }
        }
        anchorPane.setOnDragDetected(drag -> anchorPane.startFullDrag());
        anchorPane.setOnMouseDragged(drag -> {
            System.out.println("x:" + drag.getX() + "y:" + drag.getY());
            Point2D point2D = LogicUtilities.mouseMagnet(new Point2D(drag.getX(), drag.getY()));
            System.out.println("x:" + point2D.getX() + "y:" + point2D.getY());
            System.out.println("here");
//            starViews[(int)point2D.getX()][(int)point2D.getY()].setImage(StarSelecter.getImage('g'));
        });

    }

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
}
