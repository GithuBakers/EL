package view;

import data.BoardInfor;

/**
 * 必须要很荣幸的说，这个用来判断添加颜色的方法，成功消去了所有颜色.
 */
public class ColorSelector {


    public static String getColor(int i,int j){
        char[][] index= BoardInfor.getInformation();
        char indexColor=index[7-j][7-i];
        String finalColor="black";

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
