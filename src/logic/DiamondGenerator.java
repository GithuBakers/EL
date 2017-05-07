package logic;

import data.BoardInfor;
import data.Diamond;

import java.util.Random;

import static data.CD.*;

/**
 * 填充棋盘
 */
public class DiamondGenerator {
    private static Random random = new Random();

    private static char generate() {
        int a = random.nextInt(KIND);
        char b;
        switch (a) {
            case 0:
                b = 'a';
                break;
            case 1:
                b = 'b';
                break;
            case 2:
                b = 'c';
                break;
            case 4:
                b = 'd';
                break;
            case 5:
                b = 'e';
                break;
            case 6:
                b = 'f';
                break;
            default:
                b = 'd';
        }
        return b;


    }

    public static void generateOne(int x, int y) {
        Diamond[][] src = BoardInfor.getBoardInformation();
        src[x][y] = new Diamond(generate(), x, y);
        BoardInfor.setBoardInformation(src);
    }

    public static void generateSpace() {
        Diamond[][] src = BoardInfor.getBoardInformation();
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                src[i][j] = (src[i][j].kind == '0') ? new Diamond(generate(), i, j) : src[i][j];
            }
        }
        BoardInfor.setBoardInformation(src);
    }

    public static void generateAll() {
        Diamond[][] src = BoardInfor.getBoardInformation();
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                src[i][j] = new Diamond(generate(), i, j);
            }
        }
        BoardInfor.setBoardInformation(src);
    }
}

