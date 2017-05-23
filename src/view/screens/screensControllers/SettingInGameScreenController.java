package view.screens.screensControllers;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import music.BGM;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

import java.util.Random;

/**
 * Created by 15852 on 2017/5/16 0016.
 */
public class SettingInGameScreenController implements ControlledFrame {
    private FramesController framesController;
    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

    public void backToGame(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.settingInGameScreenID, AnimatorSetting.ANIMATOR_SLIDETORIGHT);
    }

    public void backToStart(){
        framesController.removeScreen(FramesLoader.classicScreenID,FramesLoader.settingInGameScreenID, AnimatorSetting.ANIMATOR_SLIDETORIGHT);
        framesController.addScreen(FramesLoader.classicScreenID,FramesLoader.rejudgeScreenID,AnimatorSetting.ANIMATOR_SLIDEINFROMUP);
    }
    BGM bgm=new BGM();
    public void settingMouseEntered(){
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
    public void settingMousePressed(){
        boolean flag=BGM.isFlagButton();
        if(flag){
            Random random=new Random();
            int mark=random.nextInt(5);
            Media media=new Media(bgm.getUrl5());
            switch (mark){
                case 0:{
                    media=new Media(bgm.getUrl5());
                    break;
                }
                case 1:{
                    media=new Media(bgm.getUrl6());
                    break;
                }
                case 2:{
                    media=new Media(bgm.getUrl7());
                    break;
                }
                case 3:{
                    media=new Media(bgm.getUrl8());
                    break;
                }
                case 4:{
                    media=new Media(bgm.getUrl9());
                    break;
                }
            }
            MediaPlayer mediaPlayer=new MediaPlayer(media);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.play();
        }
    }

    public void changeTheBGMMusic(){
        boolean flag=BGM.isFlagBGM();
        if(flag){
            BGM.BGMbstop();
            BGM.setFlagBGM(false);
        }else{
            BGM.BGMbplay();
            BGM.setFlagBGM(true);
        }
    }
    public void changeTheGameMusic(){
        boolean flag=BGM.isFlagGame();
        if(flag){
            BGM.setFlagGame(false);
        }else{
            BGM.setFlagGame(true);
        }
    }
    public void changeTheButtonMusic(){
        boolean flag=BGM.isFlagButton();
        if(flag){
            BGM.setFlagButton(false);
        }else{
            BGM.setFlagButton(true);
        }
    }
    public void changeTheMainMusic(){
        if(BGM.isFlagBGM()==false&&BGM.isFlagButton()==false){
            BGM.setFlagBGM(true);
            BGM.setFlagButton(true);
            BGM.BGMbplay();
        }else{
            BGM.setFlagBGM(false);
            BGM.setFlagButton(false);
            BGM.BGMbstop();
        }
    }

}
