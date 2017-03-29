package data;

import static data.CD.BOARD_SIZE;

/**
 * 关于棋盘信息
 */
public class BoardInfor {
    private static char[][] BoardCharInformation =new char[BOARD_SIZE][BOARD_SIZE];

    public static char[][] getInformation(){
        return BoardCharInformation;
    }
    public static void setInformation(char[][] a){
        BoardCharInformation =a;
    }
}
