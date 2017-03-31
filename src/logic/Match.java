package logic;

import data.BoardInfor;

import static data.CD.BOARD_SIZE;

/**
 * 写了！
 */
public class Match {
    private static char[][] src;
    public static void match() {
        src = BoardInfor.getInformation();
        matchRow();
        matchCol();
        BoardInfor.setInformation(src);
    }

    private static void matchRow() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            src[i] = replace(src[i]);
        }

    }

    //这 个 方 法 ……  也 太 蠢 了  ┻━┻︵╰(‵□′)╯︵┻━┻
    private static void matchCol() {
        char[] temp = new char[BOARD_SIZE];
        for (int j = 0; j < BOARD_SIZE; j++) {

            for (int i = 0; i < BOARD_SIZE; i++) {
                temp[i] = src[i][j];
            }

            temp = replace(temp);

            for (int i = 0; i < BOARD_SIZE; i++) {
                src[i][j] = temp[i];
            }
        }
    }

    //这 个 方 法 写 的 实 在 是 太 难 看 了 ……    ⁄(⁄ ⁄ ⁄ω⁄ ⁄ ⁄)⁄
    private static char[] replace(char[] chars) {
        return new String(chars).replaceAll("(?i)aaaaa", "AAAAA").replaceAll("(?i)bbbbb", "BBBBB").replaceAll("(?i)ccccc", "CCCCC").
                replaceAll("(?i)ddddd", "DDDDD").replaceAll("(?i)aaaa", "AAAA").replaceAll("(?i)bbbb", "BBBB").
                replaceAll("(?i)cccc", "CCCC").replaceAll("(?i)dddd", "DDDD").replaceAll("(?i)aaa", "AAA").
                replaceAll("(?i)bbb", "BBB").replaceAll("(?i)ccc", "CCC").replaceAll("(?i)ddd", "DDD").toCharArray();
    }

}
