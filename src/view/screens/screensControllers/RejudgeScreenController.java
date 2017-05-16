package view.screens.screensControllers;

import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/16 0016.
 */
public class RejudgeScreenController implements ControlledFrame {
    private FramesController framesController;
    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
}
