package view.screens.stars;

import data.CD;
import javafx.scene.image.Image;

/**
 * Created by 15852 on 2017/5/11 0011.
 */
public class StarSelector {

    private static Image myImage;

    public static Image getImage(char a){
        switch (a) {
            case 'a':
                myImage=new Image("/view/resources/star-1-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'b':
                myImage=new Image("/view/resources/star-2-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'c':
                myImage=new Image("/view/resources/star-3-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'd':
                myImage=new Image("/view/resources/star-4-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'e':
                myImage=new Image("/view/resources/star-5-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'f':
                myImage=new Image("/view/resources/star-6-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            default:
                myImage=new Image("/view/resources/starBlackSpecial.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
        }
        return myImage;
    }

    public static Image getModifiedImage(char a){
        switch (a){
            case 'a':
                myImage=new Image("/view/resources/star-1-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'b':
                myImage=new Image("/view/resources/star-2-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'c':
                myImage=new Image("/view/resources/star-3-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'd':
                myImage=new Image("/view/resources/star-4-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'e':
                myImage=new Image("/view/resources/star-5-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            case 'f':
                myImage=new Image("/view/resources/star-6-hover.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
            default:
                myImage=new Image("/view/resources/starBlackSpecial.PNG", CD.DIAMOND_SIZE,CD.DIAMOND_SIZE,true,true);
                break;
        }
        return myImage;
    }
}
