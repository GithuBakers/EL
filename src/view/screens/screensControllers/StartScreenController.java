package view.screens.screensControllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;
import view.screens.stars.StarGenerator;

import javax.swing.text.html.ImageView;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class StartScreenController implements ControlledFrame {
    FramesController framesController;

    @FXML
    private ImageView STARTBUTTON1;

    @FXML
    private ImageView STARTBUTTON2;

    @FXML
    public void toClassic(){
        AnchorPane anchorPane=(AnchorPane) framesController.getScreen(FramesLoader.classicScreenID);
        AnchorPane grid=(AnchorPane)anchorPane.lookup("#grid");
        new StarGenerator(grid);

        framesController.setScreen(FramesLoader.startScreenID,FramesLoader.classicScreenID,AnimatorSetting.ANIMATOR_SLIDEINLEFT);

    }

//    public void larger(){
//        STARTBUTTON1.isVisible();
//    }
//    public void smaller(){
//        STARTBUTTON.setSize(200,80);
//    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
}
