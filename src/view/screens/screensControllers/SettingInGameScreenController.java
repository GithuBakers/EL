package view.screens.screensControllers;

import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/16 0016.
 */
public class SettingInGameScreenController implements ControlledFrame {
    private FramesController framesController;
    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

    public void backToGame(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.settingInGameScreenID, AnimatorSetting.ANIMATOR_SLIDETORIGHT);
    }

    public void backToStart(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.settingInGameScreenID, AnimatorSetting.ANIMATOR_SLIDETORIGHT);
        framesController.addScreen(FramesLoader.classicScreenID,FramesLoader.rejudgeScreenID,AnimatorSetting.ANIMATOR_SLIDEINFROMUP);

    }

    public void settingMouseEntered(){}
    public void settingMousePressed(){}

    public void changeTheBGMMusic(){}
    public void changeTheGameMusic(){}
    public void changeTheButtonMusic(){}
    public void changeTheMainMusic(){}

}
