package view.screens.screensControllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import music.BGM;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

import java.time.Duration;
import java.util.Random;

/**
 * Created by 15852 on 2017/5/16 0016.
 */
public class RejudgeScreenController implements ControlledFrame {
    private FramesController framesController;
    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }
    public void backToStart(){

        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.rejudgeScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.blackScreenID,AnimatorSetting.ANIMATOR_FADEIN);
        Timeline timeline=new Timeline(
                new KeyFrame(javafx.util.Duration.millis(600),event -> framesController.setScreen(FramesLoader.blackScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_FADEIN))
        );
        timeline.play();
        //lajixiaobai
        if(BGM.isFlagBGM()){
            BGM.BGMbstop();
            BGM.BGMaplay();
        }
    }

    public void backToGame(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.rejudgeScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
    }
    BGM bgm=new BGM();
    public void rejudgeMouseEntered(){
        boolean flag = BGM.isFlagButton();
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
    public void rejudgeMousePressed(){
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
