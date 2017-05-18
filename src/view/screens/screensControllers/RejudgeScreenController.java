package view.screens.screensControllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

import java.time.Duration;

/**
 * Created by 15852 on 2017/5/16 0016.
 */
public class RejudgeScreenController implements ControlledFrame {
    private FramesController framesController;
    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
    public void backToStart(){

        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.rejudgeScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.blackScreenID,AnimatorSetting.ANIMATOR_FADEIN);
        Timeline timeline=new Timeline(
                new KeyFrame(javafx.util.Duration.millis(600),event -> framesController.setScreen(FramesLoader.blackScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_FADEIN))
        );
        timeline.play();

    }

    public void backToGame(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.rejudgeScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
    }

    public void rejudgeMouseEntered(){}
    public void rejudgeMousePressed(){}
}
