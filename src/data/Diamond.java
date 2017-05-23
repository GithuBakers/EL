package data;

import logic.BoardManager;

/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class Diamond {
    public final char kind;
    private int x;
    private int y;
    private int special = 0;
    private int condition = 0;
    private boolean thisTime = false;
    public Diamond(char c, int xx, int yy) {
        x = xx;
        y = yy;
        kind = c;
    }

    public boolean isSpecial() {
        return (special != 0);
    }

    public boolean isMatched() {
        return condition != 0;
    }

    public int getSpecial() {
        return special;
    }

    public void makeSpecial(int a) {
        if (a != CD.FIRED) {
            thisTime = true;
        }
        special = special | a;
    }

    public void makeSpecial(boolean flag, int a) {
        special &= a;
    }

    public void matchMe() {
        if (condition == 0 && !thisTime) {
            int temp = special & 0xfff0;
            special &= 0xf00f;
            switch (temp) {
                case 0x210: {
                    Diamond[][] src = BoardInfor.getBoardInformation();
                    boolean xzf = (x == 0), yzf = (y == 0);
                    boolean xof = (x == CD.BOARD_SIZE_X - 1), yof = (y == CD.BOARD_SIZE_Y - 1);
                    //upper-left
                    if ((!yzf) && (!xzf)) {
                        src[x - 1][y - 1].matchMe();
                    }
                    //up
                    if (!xzf) {
                        src[x - 1][y].matchMe();
                    }
                    //upper-right
                    if ((!yof) && (!xzf)) {
                        src[x - 1][y + 1].matchMe();
                    }
                    //left
                    if (!yzf) {
                        src[x][y - 1].matchMe();
                    }
                    //right
                    if (!yof) {
                        src[x][y + 1].matchMe();
                    }
                    //downer-right
                    if ((!yof) && (!xof)) {
                        src[x + 1][y + 1].matchMe();
                    }
                    //down
                    if (!xof) {
                        src[x + 1][y].matchMe();
                    }
                    //downer-left
                    if ((!yzf) && (!xof)) {
                        src[x + 1][y - 1].matchMe();
                    }
                    break;
                }
                case 0x220: {
                    Diamond[][] src = BoardInfor.getBoardInformation();
                    for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
                        src[i][y].matchMe();
                    }

                    for (int i = 0; i < CD.BOARD_SIZE_Y; i++) {
                        src[x][i].matchMe();
                    }
                    break;
                }
                case 0x30:
                case 0x230: {
                    BoardManager.generateAll();
                    break;
                }
                case CD.FOURR: {
                    Diamond[][] src = BoardInfor.getBoardInformation();
                    for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
                        src[i][y].matchMe();
                    }
                    break;
                }
                case CD.FOURC: {
                    Diamond[][] src = BoardInfor.getBoardInformation();
                    for (int i = 0; i < CD.BOARD_SIZE_Y; i++) {
                        src[x][i].matchMe();
                    }
                    break;
                }
                case CD.FIVE: {
                    special &= 0x0fff;
                    Diamond[][] src = BoardInfor.getBoardInformation();
                    for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
                        for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                            if (src[i][j].kind == kind) {
                                src[i][j].matchMe();
                            }
                        }
                    }
                    break;
                }
            }
        }
        condition = condition | 1;
    }

    public void changeLocation(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public void cleanMatch() {
        condition = 0;
    }

    public void cleanThisTime() {
        thisTime = false;
    }
//    @Override
//    public boolean equals(Object o) {
//        return ((Diamond) o).kind == this.kind;
//    }

    @Override
    public String toString() {
        return "" + kind + "@" + x + "@" + y + "@" + special + "@" + condition;
    }

}
