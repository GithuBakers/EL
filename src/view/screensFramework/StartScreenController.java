package view.screensFramework;

import javafx.fxml.FXML;
import view.Begin;
import view.screensFramework.ControlledFrame;
import view.screensFramework.FramesController;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class StartScreenController implements ControlledFrame {
    FramesController framesController;

    @FXML
    public void toClassic(){
        framesController.setScreen(Begin.startScreenID,Begin.classicScreenID);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
}
