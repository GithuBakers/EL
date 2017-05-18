package view.screens.screensControllers;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import view.animations.AnimatorSetting;
import view.animations.Animators;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class ClassicScreenController implements ControlledFrame {
    private FramesController framesController;


    public void toStart(){
//        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_FADEIN);
        framesController.addScreen(FramesLoader.classicScreenID,FramesLoader.settingInGameScreenID,AnimatorSetting.ANIMATOR_SLIDEFROMRIGHT);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

    public void classicMouseEntered(){}
    public void classicMousePressed(){}
}
