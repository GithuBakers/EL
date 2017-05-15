package view.screens.screensControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import view.animations.AnimatorSetting;
import view.screens.FramesController;
import view.screens.frameInterface.ControlledFrame;
import view.screens.loader.FramesLoader;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class ClassicScreenController implements ControlledFrame {
    private FramesController framesController;
    String uri=this.getClass().getClassLoader().getResource("music/DISC2_15.mp3").toString();
    javafx.scene.media.Media media=new javafx.scene.media.Media(uri);
    MediaPlayer player=new MediaPlayer(media);
    @FXML
    Button backButton;

    @FXML
    AnchorPane classicPane;

    @FXML
    Pane pane12;

    @FXML
    AnchorPane grid;

    @FXML
    Button fuck;


//    辣鸡小白


    public void playMusic(){
//    播放
        player.play();
        player.setVolume(0.5);

    }

    public void stop(){
//    停止
        player.stop();

    }

    public void upper(){
//    增大音量

        double vol=player.getVolume();
        player.setVolume(vol+0.05);

    }

    public void lower(){
//    减小音量
        double vol=player.getVolume();
        player.setVolume(vol-0.05);

    }
















    public void toStart(){
        framesController.setScreen(FramesLoader.classicScreenID,FramesLoader.startScreenID,AnimatorSetting.ANIMATOR_SLIDEINRIGHT);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

}
