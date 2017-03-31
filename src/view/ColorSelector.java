package view;

import data.BoardInfor;

/**
 * Created by 15852 on 2017/3/31 0031.
 */
public class ColorSelector {


    public static String getColor(int i,int j){
        char[][] index= BoardInfor.getInformation();
        char indexColor=index[j][7-i];
        String finalColor="white";

        switch (indexColor){
            case 'a':
                finalColor="blue";
                break;
            case 'b':
                finalColor="red";
                break;
            case 'c':
                finalColor="yellow";
                break;
            case 'd':
                finalColor="green";
                break;
            default:
                break;
        }

        return finalColor;
    }


}
