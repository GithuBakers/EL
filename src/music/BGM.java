package music;

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
    String url=getClass().getClassLoader().getResource("music/startBGM.wav").toString();

    boolean flagBGM=true;
    boolean flagGame=true;
    boolean flagButton=true;
    boolean flagMain=true;
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

    public String getUrl() {
        return url;
    }

    public boolean isFlagBGM() {
        return flagBGM;
    }

    public boolean isFlagButton() {
        return flagButton;
    }

    public boolean isFlagGame() {
        return flagGame;
    }

    public boolean isFlagMain() {
        return flagMain;
    }

    public void setFlagButton(boolean flagButton) {
        this.flagButton = flagButton;
    }

    public void setFlagGame(boolean flagGame) {
        this.flagGame = flagGame;
    }

    public void setFlagMain(boolean flagMain) {
        this.flagMain = flagMain;
    }

    public void setFlagBGM(boolean flagBGM) {
        this.flagBGM = flagBGM;
    }
}
