package data;

import static data.CD.BOARD_SIZE_X;
import static data.CD.BOARD_SIZE_Y;

/**
 * 关于棋盘信息
 */
public class BoardInfor {
    private static char[][] BoardCharInformation = new char[BOARD_SIZE_X][BOARD_SIZE_Y];

    public static char[][] getInformation(){
        return BoardCharInformation;
    }
    public static void setInformation(char[][] a){
        BoardCharInformation =a;
    }
}
