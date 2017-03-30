package logic;

import data.BoardInfor;

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
        String rePpattern;
        StringBuffer stringBuffer=new StringBuffer();
        String str;
        Boolean flag=false;
        for(int j = 0; j< BOARD_SIZE; j++){
            for(int i = 0; i< BOARD_SIZE; i++){
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
