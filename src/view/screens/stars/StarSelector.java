package view.screens.stars;

import data.CD;
import data.Diamond;
import javafx.scene.image.Image;

/**
 * Created by 15852 on 2017/5/11 0011.
 */
public class StarSelector {

    private static Image myImage;

    public static Image getImage(Diamond a){
        int special=a.getSpecial()&0xfff0;
        boolean fourC=special==CD.FOURC;
        boolean fourR=special==CD.FOURR;
        boolean five=special==CD.FIVE;
        boolean boom=special==CD.L;
        boolean cross=special==CD.ST;
        boolean replaceall=(special==CD.LTC)&&(special==CD.LTR);
        if(a.isSpecial()){
            if(five){
                //5
                myImage = new Image("/view/resources/star-MAX.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
            }else if(fourC){
                //4C
                switch (a.kind) {
                    case 'a':
                        myImage = new Image("/view/resources/special-I/star-1-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'b':
                        myImage = new Image("/view/resources/special-I/star-2-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'c':
                        myImage = new Image("/view/resources/special-I/star-3-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'd':
                        myImage = new Image("/view/resources/special-I/star-4-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'e':
                        myImage = new Image("/view/resources/special-I/star-5-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'f':
                        myImage = new Image("/view/resources/special-I/star-6-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    default:
//                        myImage = new Image("/view/resources/special-I/star-3-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                }
            }else if(fourR){
                //4R
                switch (a.kind) {
                    case 'a':
                        myImage = new Image("/view/resources/special--/star-1--.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'b':
                        myImage = new Image("/view/resources/special--/star-2--.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'c':
                        myImage = new Image("/view/resources/special--/star-3--.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'd':
                        myImage = new Image("/view/resources/special--/star-4--.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'e':
                        myImage = new Image("/view/resources/special--/star-5--.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'f':
                        myImage = new Image("/view/resources/special--/star-6--.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    default:
//                        myImage = new Image("/view/resources/special-I/star-3-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                }
            }else if(boom){
                //9
                switch (a.kind) {
                    case 'a':
                        myImage = new Image("/view/resources/star-1-hover.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'b':
                        myImage = new Image("/view/resources/star-2-hover.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'c':
                        myImage = new Image("/view/resources/star-3-hover.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'd':
                        myImage = new Image("/view/resources/star-4-hover.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'e':
                        myImage = new Image("/view/resources/star-5-hover.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'f':
                        myImage = new Image("/view/resources/star-6-hover.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    default:
//                        myImage = new Image("/view/resources/starBlackSpecial.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                }
            }else if(cross){
                //cross
                switch (a.kind) {
                    case 'a':
                        myImage = new Image("/view/resources/special-+/star-1-+.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'b':
                        myImage = new Image("/view/resources/special-+/star-2-+.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'c':
                        myImage = new Image("/view/resources/special-+/star-3-+.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'd':
                        myImage = new Image("/view/resources/special-+/star-4-+.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'e':
                        myImage = new Image("/view/resources/special-+/star-5-+.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    case 'f':
                        myImage = new Image("/view/resources/special-+/star-6-+.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                    default:
//                        myImage = new Image("/view/resources/special-I/star-3-I.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                        break;
                }
            }else if(replaceall){
                //the most horrible one
                myImage = new Image("/view/resources/star-MAX.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
            }
        }else {
            switch (a.kind) {
                case 'a':
                    myImage = new Image("/view/resources/star-1-normal.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
                case 'b':
                    myImage = new Image("/view/resources/star-2-normal.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
                case 'c':
                    myImage = new Image("/view/resources/star-3-normal.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
                case 'd':
                    myImage = new Image("/view/resources/star-4-normal.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
                case 'e':
                    myImage = new Image("/view/resources/star-5-normal.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
                case 'f':
                    myImage = new Image("/view/resources/star-6-normal.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
                default:
                    myImage = new Image("/view/resources/starBlackSpecial.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                    break;
            }
        }
        return myImage;
    }

    public static Image getModifiedImage(char a) {
        switch (a) {
            case 'a':
                myImage = new Image("/view/resources/fade/star-1-fade.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
            case 'b':
                myImage = new Image("/view/resources/fade/star-2-fade.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
            case 'c':
                myImage = new Image("/view/resources/fade/star-3-fade.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
            case 'd':
                myImage = new Image("/view/resources/fade/star-4-fade.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
            case 'e':
                myImage = new Image("/view/resources/fade/star-5-fade.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
            case 'f':
                myImage = new Image("/view/resources/fade/star-6-fade.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
            default:
//                myImage = new Image("/view/resources/starBlackSpecial.PNG", CD.DIAMOND_SIZE, CD.DIAMOND_SIZE, true, true);
                break;
        }
        return myImage;
    }
}
