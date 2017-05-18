package view.screens.screensControllers;

import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/16 0016.
 */
public class BeginningChoiceScreenController implements ControlledFrame {
    private FramesController framesController;
    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

    public void start(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.beginningChoiceScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
    }

    public void beginningChoiceMouseEntered(){}
    public void beginningChoiceMousePressed(){}
}
