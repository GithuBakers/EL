package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;

import java.util.Random;

import static data.CD.*;

/**
 * 管理  棋盘
 */
public class BoardManager {
    private static Random random = new Random();

    private static char generate() {
        int a = random.nextInt(KIND + 1);
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
                src[i][j] = (src[i][j] == null) ? new Diamond(generate(), i, j) : src[i][j];
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

    //清除掉所有应该被消除的东西并使其余内容缩紧排放,空白处填null;将特殊块的match置零
    public static void clean() {
        Diamond[][] src = BoardInfor.getBoardInformation();
        Diamond[] temp = new Diamond[CD.BOARD_SIZE_Y];
        int cnt;
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            cnt = 0;
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                if ((!src[i][j].isMatched()) || src[i][j].isSpecial()) {
                    temp[cnt++] = src[i][j];
                }
                if (src[i][j].isSpecial()) {
                    src[i][j].cleanMatch();
                }
            }
            for (int j = 0; j < cnt; j++) {
                temp[j].changeLocation(i, j);
                src[i][j] = temp[j];
            }
            for (int j = cnt; j < CD.BOARD_SIZE_Y; j++) {
                src[i][j] = null;
            }
        }
        BoardInfor.setBoardInformation(src);
    }

}

