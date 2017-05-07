//package logic;
//
//import data.BoardInfor;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import static data.CD.BOARD_SIZE;
//
///**
// * 写了！
// */
//public class Match {
//    private static char[][] src;
//    public static void match() {
//        src = BoardInfor.getInformation();
//        matchRow();
//        matchCol();
//        BoardInfor.setInformation(src);
//    }
//
//    private static void matchRow() {
//        for (int i = 0; i < BOARD_SIZE; i++) {
//            src[i] = replace(src[i]);
//            src[i] = newReplace(src[i], 'a');
//            src[i] = newReplace(src[i], 'b');
//            src[i] = newReplace(src[i], 'c');
//            src[i] = newReplace(src[i], 'd');
//
//        }
//
//    }
//
//    //这 个 方 法 ……  也 太 蠢 了  ┻━┻︵╰(‵□′)╯︵┻━┻
//    private static void matchCol() {
//        char[] temp = new char[BOARD_SIZE];
//        for (int j = 0; j < BOARD_SIZE; j++) {
//
//            for (int i = 0; i < BOARD_SIZE; i++) {
//                temp[i] = src[i][j];
//            }
////            temp = replace(temp);
//
//            temp = newReplace(temp, 'a');
//            temp = newReplace(temp, 'b');
//            temp = newReplace(temp, 'c');
//            temp = newReplace(temp, 'd');
//
//            for (int i = 0; i < BOARD_SIZE; i++) {
//                src[i][j] = temp[i];
//            }
//        }
//    }
//
//    //这 个 方 法 已 经 被 废 除 了
//    private static char[] replace(char[] chars) {
//        return new String(chars).replaceAll("(?i)aaaaa", "AAAAA").replaceAll("(?i)bbbbb", "BBBBB").replaceAll("(?i)ccccc", "CCCCC").
//                replaceAll("(?i)ddddd", "DDDDD").replaceAll("(?i)aaaa", "AAAA").replaceAll("(?i)bbbb", "BBBB").
//                replaceAll("(?i)cccc", "CCCC").replaceAll("(?i)dddd", "DDDD").replaceAll("(?i)aaa", "AAA").
//                replaceAll("(?i)bbb", "BBB").replaceAll("(?i)ccc", "CCC").replaceAll("(?i)ddd", "DDD").toCharArray();
//    }
//
//    private static char[] newReplace(char[] chars, char c) {
//        String toBePattern;
//        switch (c) {
//            case 'a':
//                toBePattern = "aaa+";
//                break;
//            case 'b':
//                toBePattern = "bbb+";
//                break;
//            case 'c':
//                toBePattern = "ccc+";
//                break;
//            case 'd':
//                toBePattern = "ddd+";
//                break;
//            default:
//                toBePattern = "eee+";
//        }
//        Pattern pattern = Pattern.compile(toBePattern);
//
//        Matcher matcher = pattern.matcher(new String(chars));
//        while (matcher.find()) {
//            String dst = matcher.group();
//            int len = dst.length();
//            StringBuffer stringBuffer = new StringBuffer();
//            for (int i = 0; i < len; i++) {
//                stringBuffer.append(c);
//            }
//            String str = stringBuffer.toString().toUpperCase();
//            chars = new String(chars).replaceAll(dst, str).toCharArray();
//
//        }
//        return chars;
//    }
//
//}
