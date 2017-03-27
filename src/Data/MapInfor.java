package Data;

import static Data.CD.SIZE;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class MapInfor {
    private static char[][] mapCharInformation =new char[SIZE][SIZE];

    public static char[][] getInformation(){
        return mapCharInformation;
    }
    public static void setInformation(char[][] a){
        mapCharInformation =a;
    }
}
