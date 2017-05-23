import data.BoardInfor;
import data.CD;
import data.Diamond;
import logic.BoardManager;
import logic.Judge;
import logic.LogicUtilities;

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
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'd'},
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
        //L/T/LT
        char[][] sample12 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'a', 'a', 'c', 'f', 'c', 'd'},
                {'c', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'c', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        //测试特效
        char[][] sample21 = {
                {'b', 'c', 'd', 'e', 'c', 'f', 'f', 'f'},
                {'a', 'd', 'b', 'b', 'b', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'f', 'f', 'f', 'f'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'d', 'd', 'd', 'a', 'c', 'd', 'd', 'd'}};

        //tm列匹配有毒？？？
        char[][] samplex = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'f', 'c', 'a'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'd'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        //deal with a problem in UI test
        char[][] samplexxz = {
                {'d', 'd', 'a', 'e', 'a', 'a', 'c', 'c'},
                {'a', 'a', 'b', 'e', 'a', 'a', 'd', 'd'},
                {'f', 'c', 'a', 'c', 'a', 'd', 'c', 'c'},
                {'c', 'c', 'f', 'c', 'a', 'f', 'c', 'c'},
                {'e', 'b', 'b', 'f', 'b', 'd', 'd', 'a'},
                {'b', 'b', 'b', 'c', 'b', 'd', 'c', 'd'},
                {'b', 'd', 'b', 'c', 'c', 'e', 'b', 'd'},
                {'a', 'a', 'd', 'a', 'a', 'd', 'a', 'a'}
        };
        char a = 'a', b = 'b', c = 'c', d = 'd', e = 'e', f = 'f';
        char[][] samplexxz2 = {
                {a, b, e, c, f, a, a, a},
                {a, d, b, c, c, a, c, a},
                {d, b, f, a, d, f, c, c},
                {a, c, c, f, c, b, e, d},
                {a, c, b, b, a, a, b, f},
                {d, e, d, f, d, a, d, d},
                {a, b, e, e, a, e, e, e},
                {a, d, a, c, c, f, e, d}
        };

        char[][] samplexxz3 = {
                {a, b, e, c, f, b, d, d},
                {a, d, b, c, c, a, b, c},
                {d, b, f, a, a, b, d, e},
                {a, b, a, c, e, c, f, e},
                {a, c, b, c, c, b, c, d},
                {d, b, d, b, f, b, e, e},
                {a, c, e, d, a, f, d, e},
                {a, d, a, c, c, e, a, f}
        };
        toTest(sample1);

        //测试特效
//        Diamond[][] src = BoardInfor.getBoardInformation();
//        src[0][0].makeSpecial(CD.L);
//        src[7][0].makeSpecial(CD.L);
//        src[0][7].makeSpecial(CD.L);
//        src[7][7].makeSpecial(CD.L);

        System.out.println(Judge.isUnfinished());
//        printProperties(BoardInfor.getBoardInformation());
        LogicUtilities.move(2, 6, 2, 7);
        printProperties(BoardInfor.getBoardInformation());
//        print(BoardInfor.getBoardInformation());
//        printProperties(BoardInfor.getBoardInformation());
        BoardManager.clean();
        print(BoardInfor.getBoardInformation());
        BoardManager.generateSpace();
        print(BoardInfor.getBoardInformation());
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
                if (src[i][j] != null) {
                    System.out.print(" " + src[i][j].toString().charAt(0) + " ");
                } else {
                    System.out.print(" " + "#" + " ");
                }
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
