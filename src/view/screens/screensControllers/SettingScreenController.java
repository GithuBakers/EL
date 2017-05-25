package view.screens.screensControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import music.BGM;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

import java.util.Random;

/**
 * Created by 15852 on 2017/5/15 0015.
 * developed by xu on 2017/5/15
 */
public class SettingScreenController implements ControlledFrame {

    private FramesController framesController;
    @FXML
    private Button btm;
    @FXML
    private Button bgmB;
    @FXML
    private Button gam;
    @FXML
    private Button all;

//    public SettingScreenController(){
//        fresh();
//    }


    public void setControlledFrame(FramesController framesController) {
        this.framesController = framesController;
        fresh();
    }



    public void fresh(){
        bgmB.getStyleClass().remove(0,bgmB.getStyleClass().size());
        btm.getStyleClass().remove(0,btm.getStyleClass().size());
        gam.getStyleClass().remove(0,gam.getStyleClass().size());
        all.getStyleClass().remove(0,all.getStyleClass().size());
        if(BGM.isFlagBGM()){
            bgmB.getStyleClass().add("on-button");
        }else {
            bgmB.getStyleClass().add("off-button");
        }
        if(BGM.isFlagButton()){
            btm.getStyleClass().add("on-button");
        }else {
            btm.getStyleClass().add("off-button");
        }
        if(BGM.isFlagGame()){
            gam.getStyleClass().add("on-button");
        }
        else{
            gam.getStyleClass().add("off-button");
        }



        if(BGM.isFlagBGM()==false&&BGM.isFlagButton()==false){
            all.getStyleClass().add("off-button");
            gam.getStyleClass().remove(0,gam.getStyleClass().size());
            gam.getStyleClass().add("off-button");
            bgmB.getStyleClass().remove(0,gam.getStyleClass().size());
            bgmB.getStyleClass().add("off-button");
            btm.getStyleClass().remove(0,btm.getStyleClass().size());
            btm.getStyleClass().add("off-button");
        }else {
            all.getStyleClass().add("on-button");
        }
    }

    public void back(){
        framesController.removeScreen(FramesLoader.startScreenID,FramesLoader.settingScreenID, AnimatorSetting.ANIMATOR_SLIDEINTODOWN);
    }
    BGM bgm=new BGM();

    public void settingMouseEntered() {

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
            bgmB.getStyleClass().add("off-button");
            BGM.BGMastop();
        BGM.setFlagBGM(false);
        }else{
            bgmB.getStyleClass().add("on-button");
            BGM.BGMaplay();
           BGM.setFlagBGM(true);
        }
        fresh();
    }
    public void changeTheGameMusic(){
//        gam.getStyleClass().remove(0,gam.getStyleClass().size());
        boolean flag=BGM.isFlagGame();
        if(flag){
//            bgmB.getStyleClass().add("off-button");
            BGM.setFlagGame(false);
        }else{
//            bgmB.getStyleClass().add("on-button");
           BGM.setFlagGame(true);
        }
        fresh();
    }
    public void changeTheButtonMusic(){
        boolean flag=BGM.isFlagButton();
//        btm.getStyleClass().remove(0,btm.getStyleClass().size());
        if(flag){
//            btm.getStyleClass().set(0,"off-button");

            BGM.setFlagButton(false);
        }else{
//            btm.getStyleClass().set(0,"on-button");
            BGM.setFlagButton(true);
        }
        fresh();
    }
    public void changeTheMainMusic(){
        if(BGM.isFlagBGM()==false&&BGM.isFlagButton()==false){
            BGM.setFlagBGM(true);
            BGM.setFlagButton(true);
            BGM.BGMaplay();
        }else{
            BGM.setFlagBGM(false);
            BGM.setFlagButton(false);
            BGM.BGMastop();
        }
        fresh();
    }

//
//    public Button getBgm() {
//        return bgm;
//    }
//
//    public void setBgm(Button bgm) {
//        this.bgm = bgm;
//    }
}
