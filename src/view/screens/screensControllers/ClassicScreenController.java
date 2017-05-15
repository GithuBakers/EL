package view.screens.screensControllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
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
    Pane pane12;

    @FXML
    AnchorPane grid;

    @FXML
    Button fuck;


//    辣鸡一舟，完成下面四个方法

    public void playMusic(){
//    播放


    }

    public void stop(){
//    停止


    }

    public void upper(){
//    增大音量



    }

    public void lower(){
//    减小音量


    }
















    public void toStart(){
        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_SLIDEINRIGHT);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

}
