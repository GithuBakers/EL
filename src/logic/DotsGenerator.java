package logic;

import data.BoardInfor;

import java.util.Random;

import static data.CD.*;

/**
 *
 * 所有和填充棋盘有关的方法都在这里
 */
public class DotsGenerator {
    private static Random random=new Random();
    private static char generate(){
        int a=random.nextInt(KIND);
        char b;
        switch (a){
            case 0:b='a';break;
            case 1:b='b';break;
            case 2:b='c';break;
            case 4:b='d';break;
            default:b='d';
        }
        return b;



    }
    public static void generateOne(int a,int b){
        char[][] src= BoardInfor.getInformation();
        src[a][b]=generate();
        BoardInfor.setInformation(src);
    }
    public static void generateSpace(){
        char[][] src= BoardInfor.getInformation();
        for(int i = 0; i< BOARD_SIZE; i++){
            for(int j = 0; j< BOARD_SIZE; j++){
                src[i][j]=(src[i][j]=='0')? generate():src[i][j];
            }
        }
        BoardInfor.setInformation(src);
    }
    public static void generateAll(){
        char[][] src= BoardInfor.getInformation();
        for(int i = 0; i< BOARD_SIZE; i++){
            for(int j = 0; j< BOARD_SIZE; j++){
                src[i][j]=generate();
            }
        }
        BoardInfor.setInformation(src);
    }
}
