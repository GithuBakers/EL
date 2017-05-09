import data.BoardInfor;
import data.CD;
import data.Diamond;
import logic.xxzNJudge;
import logic.xxzNMatch;

import static data.CD.BOARD_SIZE_X;
import static data.CD.BOARD_SIZE_Y;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class Main {
    public static void main(String[] args) {
        char[][] sample = {
                {'a', 'b', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'a', 'b', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'b', 'b', 'b', 'c', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'c', 'c', 'd'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'a', 'd', 'd', 'd', 'd', 'c', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'd', 'c', 'c', 'a', 'd'}};
        //没有能自动匹配的
        char[][] sample1 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'f', 'c', 'd'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        //测试行特殊匹配5
        char[][] sample2 = {
                {'a', 'f', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'c', 'b', 'b', 'b', 'c', 'c', 'd'},
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}

        };
        //测试行特殊匹配6
        char[][] sample3 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'b', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'f', 'c', 'd'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};

        //测试行特殊匹配7
        char[][] sample4 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'a', 'b', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'b', 'a', 'c', 'f', 'c', 'd'},
                {'a', 'c', 'b', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        //测试一行4／5的单一特效和7的成功消除
        char[][] sample5 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'b', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'd'},
                {'a', 'c', 'c', 'c', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        //列特殊匹配4／5／7
        char[][] sample11 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'b', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'b', 'c', 'a', 'c', 'f', 'c', 'd'},
                {'a', 'b', 'c', 'a', 'b', 'f', 'a', 'd'},
                {'d', 'b', 'c', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'b', 'c', 'd', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        toTest(sample11);

        System.out.println(xxzNJudge.isUnfinished());
        xxzNMatch.mark();
        print(BoardInfor.getBoardInformation());
        printProperties(BoardInfor.getBoardInformation());

    }

    public static void toTest(char[][] c) {
        Diamond[][] diamonds = new Diamond[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                diamonds[i][j] = new Diamond(c[i][j], i, j);
            }
        }
        BoardInfor.setBoardInformation(diamonds);
    }

    public static void print(Diamond[][] src) {
        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                System.out.print(" " + src[i][j].toString().charAt(0) + " ");
            }
            System.out.println();
        }
        System.out.println("__________________________________");
    }

    public static void printProperties(Diamond[][] src) {
        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                System.out.printf("%3x ", Integer.valueOf(src[i][j].toString().split("@")[4]));
            }
            System.out.println();
        }
        System.out.println("__________________________________");

        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                System.out.printf("%3x ", Integer.valueOf(src[i][j].toString().split("@")[3]));
            }
            System.out.println();
        }
        System.out.println("__________________________________");
    }
}
