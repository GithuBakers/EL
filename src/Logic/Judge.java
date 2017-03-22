package Logic;

import Data.MapInfor;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import java.util.regex.Pattern;

import static Data.CD.SIZE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class Judge {
    private static char toCheck;
    private static char[][] src= MapInfor.getInformation();
    public static boolean judgeMatch3(char a){
        toCheck=a;
        return judgeRow()||judgeCol();
    }
    private static boolean judgeRow(){
        String rePpattern;
        Boolean flag=false;
        for(int i=0;i<SIZE;i++){
            switch (toCheck){
                case 'a':rePpattern="aa[bcd]a|a[bcd]aa";break;
                case 'b':rePpattern="bb[acd]b|b[acd]bb";break;
                case 'c':rePpattern="cc[abd]c|c[abd]cc";break;
                case 'd':rePpattern="dd[acb]d|d[acb]dd";break;
                default:rePpattern=" ";
            }
            Pattern pattern=Pattern.compile(rePpattern);
            flag=flag||pattern.matcher(new String(src[i])).find();

        }
        return flag;
    }
    private static boolean judgeCol(){
        String rePpattern;
        StringBuffer stringBuffer=new StringBuffer();
        String str=new String();
        Boolean flag=false;
        for(int j=0;j<SIZE;j++){
            for(int i=0;i<SIZE;i++){
                stringBuffer.append(src[i][j]);
            }
            str=stringBuffer.toString();
            switch (toCheck){
                case 'a':rePpattern="aa[bcd]a|a[bcd]aa";break;
                case 'b':rePpattern="bb[acd]b|b[acd]bb";break;
                case 'c':rePpattern="cc[abd]c|c[abd]cc";break;
                case 'd':rePpattern="dd[acb]d|d[acb]dd";break;
                default:rePpattern=" ";
            }
            Pattern pattern=Pattern.compile(rePpattern);
            flag=flag||pattern.matcher(str).find();
            stringBuffer.setLength(0);
        }
        return flag;
    }
}
