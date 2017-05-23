package music;

import javafx.scene.media.MediaPlayer;

/**
 * Created by lenovo on 2017/5/18.
 */
public class BGM {
    String url1=getClass().getClassLoader().getResource("music/button1.wav").toString();
    String url2=getClass().getClassLoader().getResource("music/button2.wav").toString();
    String url3=getClass().getClassLoader().getResource("music/button3.wav").toString();
    String url4=getClass().getClassLoader().getResource("music/button4.wav").toString();
    String url5=getClass().getClassLoader().getResource("music/button5.wav").toString();
    String url6=getClass().getClassLoader().getResource("music/button6.wav").toString();
    String url7=getClass().getClassLoader().getResource("music/button7.wav").toString();
    String url8=getClass().getClassLoader().getResource("music/button8.wav").toString();
    String url9=getClass().getClassLoader().getResource("music/button9.wav").toString();
    String urla =getClass().getClassLoader().getResource("music/startBGM.wav").toString();
    String urlb=getClass().getClassLoader().getResource("music/gameBGM.wav").toString();

    static boolean flagBGM=true;
    static boolean flagGame=true;
    static boolean flagButton=true;
    public String getUrl1() {
        return url1;
    }

    public String getUrl2() {
        return url2;
    }

    public String getUrl3() {
        return url3;
    }

    public String getUrl4() {
        return url4;
    }

    public String getUrl5() {
        return url5;
    }

    public String getUrl6() {
        return url6;
    }
    public String getUrl7() {
        return url7;
    }
    public String getUrl8() {
        return url8;
    }

    public String getUrl9() {
        return url9;
    }

    public String getUrla() {
        return urla;
    }

    public String getUrlb() {
        return urlb;
    }

    public static boolean isFlagBGM() {
        return flagBGM;
    }

    public static boolean isFlagButton() {
        return flagButton;
    }

    public static boolean isFlagGame() {
        return flagGame;
    }


    public static void setFlagButton(boolean flag) {
        flagButton = flag;
    }

    public static void setFlagGame(boolean flag) {
        flagGame = flag;
    }

    public static void setFlagBGM(boolean flag) {
        flagBGM = flag;
    }
    static BGM bgm=new BGM();
    static javafx.scene.media.Media mediaa=new javafx.scene.media.Media(bgm.getUrla());
    static MediaPlayer mediaPlayera=new MediaPlayer(mediaa);
    public static void BGMaplay(){
        mediaPlayera.setVolume(0.3);
        mediaPlayera.play();
        mediaPlayera.setCycleCount(1000000000);
    }
    public static void BGMastop(){
        mediaPlayera.stop();
    }
    static javafx.scene.media.Media mediab=new javafx.scene.media.Media(bgm.getUrlb());
    static MediaPlayer mediaPlayerb=new MediaPlayer(mediab);
    public static void BGMbplay(){
        mediaPlayerb.setVolume(0.3);
        mediaPlayerb.play();
        mediaPlayerb.setCycleCount(1000000000);
    }
    public static void BGMbstop(){
        mediaPlayerb.stop();
    }
}
