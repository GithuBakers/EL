package logic;

import data.BoardInfor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static data.CD.BOARD_SIZE;

/**
 * Judge class 应当包含所有和"判断是否有能消去情况"有关的静态方法。
 */
public class Judge {
    private static char toCheck;
    private static char[][] src;

    //This method is used to judge whether there are three same dots or more;
    public static boolean judgeMatch3(char a){
        src= BoardInfor.getInformation();
        toCheck=a;
        return judgeRow()||judgeCol();
    }

    //这个方法用来判断有没有能自动消去的
    public static boolean judgeMatchFinished() {
        boolean flag = false;
        src = BoardInfor.getInformation();
        String s = "aaa+|bbb+|ccc+|ddd+";
        Pattern pattern = Pattern.compile(s);

        for (int i = 0; i < BOARD_SIZE; i++) {
            Matcher matcher = pattern.matcher(new String(src[i]));
            flag = matcher.find() || flag;
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < BOARD_SIZE; j++) {
                stringBuffer.append(src[j][i]);
            }
            String string = stringBuffer.toString();
            Matcher matcher = pattern.matcher(string);
            flag = matcher.find() || flag;
        }

        return flag;
    }
    private static boolean judgeRow(){
        String regPattern;
        Boolean flag=false;
        for(int i = 0; i< BOARD_SIZE; i++){
            switch (toCheck){
                case 'a':regPattern="aa[bcd]a|a[bcd]aa";break;
                 case 'b':regPattern="bb[acd]b|b[acd]bb";break;
                case 'c':regPattern="cc[abd]c|c[abd]cc";break;
                case 'd':regPattern="dd[acb]d|d[acb]dd";break;
                default:regPattern=" ";
            }
            Pattern pattern=Pattern.compile(regPattern);
            flag=flag||pattern.matcher(new String(src[i])).find();

        }
        return flag;
    }
    private static boolean judgeCol(){
        String rePattern;
        StringBuffer stringBuffer=new StringBuffer();
        String str;
        Boolean flag=false;
        for(int j = 0; j< BOARD_SIZE; j++){
            for(int i = 0; i< BOARD_SIZE; i++){
                stringBuffer.append(src[i][j]);
            }
            str=stringBuffer.toString();
            switch (toCheck){
                case 'a':
                    rePattern = "aa[bcd]a|a[bcd]aa";
                    break;
                case 'b':
                    rePattern = "bb[acd]b|b[acd]bb";
                    break;
                case 'c':
                    rePattern = "cc[abd]c|c[abd]cc";
                    break;
                case 'd':
                    rePattern = "dd[acb]d|d[acb]dd";
                    break;
                default:
                    rePattern = " ";
            }
            Pattern pattern = Pattern.compile(rePattern);
            flag=flag||pattern.matcher(str).find();
            stringBuffer.setLength(0);
        }
        return flag;
    }
}
