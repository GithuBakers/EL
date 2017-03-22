package Logic;

import Data.MapInfor;

import java.util.Random;

import static Data.CD.*;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class AnimalGenerator {
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
        char[][] src= MapInfor.getInformation();
        src[a][b]=generate();
        MapInfor.setInformation(src);
    }
    public static void generateSpace(){
        char[][] src=MapInfor.getInformation();
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                src[i][j]=(src[i][j]=='0')? generate():src[i][j];
            }
        }
        MapInfor.setInformation(src);
    }
    public static void generateAll(){
        char[][] src=MapInfor.getInformation();
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                src[i][j]=generate();
            }
        }
        MapInfor.setInformation(src);
    }
}
