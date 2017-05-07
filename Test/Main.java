import data.BoardInfor;
import data.CD;
import data.Diamond;
import logic.xxzNJudge;

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
        char[][] sample1 = {
                {'a', 'b', 'b', 'e', 'c', 'f', 'a', 'd'},
                {'a', 'd', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'a', 'b', 'b', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'f', 'c', 'd'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'d', 'b', 'e', 'd', 'd', 'f', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'a', 'c', 'c', 'a', 'd'}};
        toTest(sample1);


        System.out.println(xxzNJudge.judge());
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
                System.out.print(" " + src[i][j].toString().charAt(0) + " ");
            }
            System.out.println();
        }
        System.out.println("__________________________________");
    }
}
