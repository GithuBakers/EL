package view;

import com.sun.javafx.css.StringStore;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

/**
 * Created by DELL on 2017/4/6.
 */
public class Music{
    Media media ;
    MediaPlayer mediaPlayer ;

    public void init(){

        URL mediaUrl = this.getClass().getClassLoader().getResource("music/Nils Frahm - Ambre.mp3");
        media = new Media(mediaUrl.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.8);
        mediaPlayer.setCycleCount(1000000000);
        mediaPlayer.totalDurationProperty();
        System.out.println(mediaPlayer.getStatus());
    }

}
