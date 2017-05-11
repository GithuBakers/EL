package view.screens.screensControllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.Begin;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;
import view.screens.stars.StarSelecter;

import java.awt.*;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class ClassicScreenController implements ControlledFrame {
    private FramesController framesController;

    @FXML
    Button backButton;

    @FXML
    GridPane classicGrid;

    @FXML
    Pane pane12;

    @FXML
    AnchorPane classicAnchor;

    @FXML
    Button fuck;


    public void setFuck(){
        fuck.setText("fuckfuck");
        Image fuck= StarSelecter.getImage('a');
        ImageView imageView=new ImageView(fuck);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setImage(StarSelecter.getModifiedImage('a'));
            }
        });
        classicGrid.add(imageView,0,0);

    }

    public void miaomiaomiao(){
        Rectangle rectangle= new Rectangle(50,50);
        rectangle.setFill(Color.BLUE);

        pane12.getChildren().add(rectangle);
        System.out.println(rectangle.getScene().xProperty());

    }

    public void toStart(){
        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_SLIDEINRIGHT);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

}
