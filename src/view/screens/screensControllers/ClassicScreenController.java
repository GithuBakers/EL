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

    @FXML
    Button backButton;

    @FXML
    AnchorPane classicPane;

    @FXML
    Pane pane12;

    @FXML
    AnchorPane grid;

    @FXML
    Button fuck;


//    辣鸡一舟，完成下面四个方法

    public void playMusic(){
//    播放
        GaussianBlur gaussianBlur=new GaussianBlur();
        gaussianBlur.setRadius(10);
        classicPane.setEffect(gaussianBlur);

    }

    public void stop(){
//    停止

    }

    public void upper(){
//    增大音量


//        Animators animator=new Animators();
//        animator.setAnimation();
//        Timeline timeline=animator.showTime(framesController.getScreen(FramesLoader.settingScreenID),300);
//        timeline.play();

    }

    public void lower(){
//    减小音量

    }
















    public void toStart(){
//        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_FADEIN);
        framesController.addScreen(FramesLoader.classicScreenID,FramesLoader.settingInGameScreenID,AnimatorSetting.ANIMATOR_SLIDEFROMRIGHT);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

}
