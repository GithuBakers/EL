package view.screens.stars;

import data.BoardInfor;
import javafx.scene.image.Image;

/**
 * Created by 15852 on 2017/5/11 0011.
 */
public class StarSelecter {

    private static Image myImage;

    public static Image getImage(char a){
        switch (a) {
            case 'a':
                myImage=new Image("/view/resources/starYellow1.PNG");
                break;
            case 'b':
                myImage=new Image("/view/resources/starRed1.PNG");
                break;
            case 'c':
                myImage=new Image("/view/resources/starGreen1.PNG");
                break;
            case 'd':
                myImage=new Image("/view/resources/starBlue1.PNG");
                break;
            case 'e':
                myImage=new Image("/view/resources/starPink1.PNG");
                break;
            case 'f':
                myImage=new Image("/view/resources/starBrown1.PNG");
                break;
            default:
                myImage=new Image("/view/resources/starBlack.PNG");
                break;
        }
        return myImage;
    }

    public static Image getModifiedImage(char a){
        switch (a){
            case 'a':
                myImage=new Image("/view/resources/starYellow2.PNG");
                break;
            case 'b':
                myImage=new Image("/view/resources/starRed2.PNG");
                break;
            case 'c':
                myImage=new Image("/view/resources/starGreen2.PNG");
                break;
            case 'd':
                myImage=new Image("/view/resources/starBlue2.PNG");
                break;
            case 'e':
                myImage=new Image("/view/resources/starPink2.PNG");
                break;
            case 'f':
                myImage=new Image("/view/resources/starBrown2.PNG");
                break;
            default:
                myImage=new Image("/view/resources/starBlack.PNG");
                break;
        }
        return myImage;
    }
}
