package view.screens.screensControllers;

import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/15 0015.
 */
public class SettingScreenController implements ControlledFrame {
    private FramesController framesController;

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

    public void back(){
        framesController.removeScreen(FramesLoader.startScreenID,FramesLoader.settingScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
    }
}
