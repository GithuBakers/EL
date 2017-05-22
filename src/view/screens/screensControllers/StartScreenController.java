package view.screens.screensControllers;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import music.BGM;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;
import view.screens.stars.StarGenerator;

import java.util.Random;

/**
 * Created by 15852 on 2017/5/7 0007.
 * developed by xu on 2017/5/15
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






//        lajixiaobai
        if(BGM.isFlagBGM()){
            BGM.BGMastop();
            BGM.BGMbplay();
        }
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
    BGM bgm=new BGM();
    public void startMouseEntered() {
//        鼠标移入音效
        boolean flag = bgm.isFlagButton();
        if (flag) {
            Random random = new Random();
            int mark = random.nextInt(4);
            Media media = new Media(bgm.getUrl1());
            switch (mark) {
                case 0: {
                    media = new Media(bgm.getUrl1());
                    break;
                }
                case 1: {
                    media = new Media(bgm.getUrl2());
                    break;
                }
                case 2: {
                    media = new Media(bgm.getUrl3());
                    break;
                }
                case 3: {
                    media = new Media(bgm.getUrl4());
                    break;
                }
            }
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.play();
        }
    }
    public void startMousePressed() {
//        鼠标点击
        boolean flag = bgm.isFlagButton();
        if (flag) {
            Random random = new Random();
            int mark = random.nextInt(5);
            Media media = new Media(bgm.getUrl5());
            switch (mark) {
                case 0: {
                    media = new Media(bgm.getUrl5());
                    break;
                }
                case 1: {
                    media = new Media(bgm.getUrl6());
                    break;
                }
                case 2: {
                    media = new Media(bgm.getUrl7());
                    break;
                }
                case 3: {
                    media = new Media(bgm.getUrl8());
                    break;
                }
                case 4: {
                    media = new Media(bgm.getUrl9());
                    break;
                }
            }
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.play();
        }
    }

}
