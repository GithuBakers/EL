package Logic;

import Data.MapInfor;

import static Data.CD.SIZE;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class Match {
    private static char[][] src;
    public static void match(){
        matchRow();
        matchCol();
        MapInfor.setInformation(src);

    }
    private static void matchRow(){
        src= MapInfor.getInformation();
        for(int i=0;i<SIZE;i++){
            String str=new String(src[i]);
            str=str.replaceAll("aaaaa|bbbbb|ccccc|ddddd","00000");
            str=str.replaceAll("aaaa|bbbb|cccc|dddd","0000");
            str=str.replaceAll("aaa|bbb|ccc|ddd","000");
            src[i]=str.toCharArray();
        }
    }
    private static void matchCol(){
        src=MapInfor.getInformation();
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                stringBuffer.append(src[j][i]);
            }
            String str=new String(stringBuffer);
            str=str.replaceAll("aaaaa|bbbbb|ccccc|ddddd","00000");
            str=str.replaceAll("aaaa|bbbb|cccc|dddd","0000");
            str=str.replaceAll("aaa|bbb|ccc|ddd","000");
            src[i]=str.toCharArray();
            stringBuffer.setLength(0);
        }
    }
}
