package view.screens.screensControllers;

import javafx.fxml.FXML;
import view.Begin;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class StartScreenController implements ControlledFrame {
    FramesController framesController;

    @FXML
    public void toClassic(){
        framesController.setScreen(FramesLoader.startScreenID,FramesLoader.classicScreenID,AnimatorSetting.ANIMATOR_SLIDEINLEFT);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
}
