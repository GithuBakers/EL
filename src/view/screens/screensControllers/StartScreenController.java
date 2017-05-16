package view.screens.screensControllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
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
    private FramesController framesController;
    private int time=2000;

    @FXML
    public void toClassic(){
        AnchorPane anchorPane=(AnchorPane) framesController.getScreen(FramesLoader.classicScreenID);
        AnchorPane grid=(AnchorPane)anchorPane.lookup("#grid");
        AnchorPane upPane=(AnchorPane)anchorPane.lookup("#upPane");
        AnchorPane downPane=(AnchorPane)anchorPane.lookup("#downPane");
        StarGenerator starGenerator = new StarGenerator(grid);

//        upPane.translateYProperty().set(-500);
//        downPane.translateYProperty().set(500);
        framesController.setScreen(FramesLoader.startScreenID,FramesLoader.blackScreenID,AnimatorSetting.ANIMATOR_FADEIN);
        Timeline timeline=new Timeline(
                new KeyFrame(Duration.millis(time), event ->
                    framesController.setScreen(
                            FramesLoader.blackScreenID,
                            FramesLoader.classicScreenID,
                            AnimatorSetting.ANIMATOR_FADEIN)
                ),
                new KeyFrame(Duration.millis(time+300),
                        new KeyValue(upPane.translateYProperty(),-500,Interpolator.TANGENT(Duration.millis(150),1)),
                        new KeyValue(downPane.translateYProperty(),500,Interpolator.TANGENT(Duration.millis(150),1))),
                new KeyFrame(Duration.millis(time+700),
                        new KeyValue(upPane.translateYProperty(),0),
                        new KeyValue(downPane.translateYProperty(),0)),
                new KeyFrame(Duration.millis(time+400),event -> framesController.addScreen(FramesLoader.classicScreenID,FramesLoader.beginningChoiceScreenID, AnimatorSetting.ANIMATOR_SLIDEINFROMUP))
        );
        timeline.play();




    }

    @FXML
    public void toSetting(){
        framesController.addScreen(FramesLoader.startScreenID,FramesLoader.settingScreenID,AnimatorSetting.ANIMATOR_SLIDEINFROMUP);
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
