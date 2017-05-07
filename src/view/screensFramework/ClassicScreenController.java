package view.screensFramework;

import javafx.fxml.FXML;
import view.Begin;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class ClassicScreenController implements ControlledFrame {
    FramesController framesController;

    @FXML
    public void toStart(){
        framesController.setScreen(Begin.startScreenID);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
}
