package view.screens.stars;

import data.BoardInfor;
import data.CD;
import data.Diamond;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import logic.LogicUtilities;

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
        });
        anchorPane.setOnMouseDragged(drag -> {
            LogicUtilities.mouseMagnet(new Point2D(drag.getX(), drag.getY()));
        });

    }


}
