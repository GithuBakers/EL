package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;

/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class Match {
    private static Diamond src[][];

    public static void mark() {
        src = BoardInfor.getBoardInformation();
        markRow();
        markColumn();
        BoardInfor.setBoardInformation(src);
    }

    public static void mark(int x1, int y1, int x2, int y2) {
        src = BoardInfor.getBoardInformation();
        if (x1 == x2) {
            markSingleRow(x1);
            markSingleColumn(y1);
            markSingleColumn(y2);
        } else if (y1 == y2) {
            markSingleColumn(y1);
            markSingleRow(x1);
            markSingleRow(x2);
        }
        BoardInfor.setBoardInformation(src);
    }

    //这个方法标记y这一列从x行开始向下5个（包括x）,返回成功匹配的个数
    private static int markAdjacentC(int x, int y) {
        int cnt;
        char state = src[x][y].kind;
        Integer[] loc = new Integer[5];
        Diamond now;
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            now = src[x + i][y];
            switch (cnt) {
                case 0: {
                    loc[0] = i;
                    cnt++;
                    break;
                }

                case 1: {
                    if (now.kind == state) {
                        cnt++;
                        loc[1] = i;
                    } else {
                        cnt = 1;
                        loc[0] = i;
                        state = now.kind;
                    }
                    break;
                }

                case 2: {
                    if (now.kind == state) {
                        cnt++;
                        loc[2] = i;
                    } else {
                        cnt = 1;
                        loc[1] = null;
                        loc[0] = i;
                        state = now.kind;
                    }
                    break;
                }

                case 3: {
                    if (now.kind == state) {
                        cnt++;
                        loc[3] = i;
                    } else {
                        cnt = 9;
                    }
                    break;
                }

                case 4: {
                    if (now.kind == state) {
                        loc[4] = i;
                        cnt = 9;
                    } else {
                        cnt = 9;
                    }
                    break;
                }

                case 9: {
                    break;
                }
            }
        }
        if (cnt == 9) {
            cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (loc[i] != null) {
                    src[x + i][y].matchMe();
                    cnt++;
                }
            }
        } else {
            cnt = 0;
        }

        return cnt;

    }

    //标记x这行从y开始向右5个（包括）
    private static int markAdjacentR(int x, int y) {
        int cnt;
        char state = src[x][y].kind;
        Integer[] loc = new Integer[5];
        Diamond now;
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            now = src[x][y + i];
            switch (cnt) {
                case 0: {
                    loc[0] = i;
                    cnt++;
                    break;
                }

                case 1: {
                    if (now.kind == state) {
                        cnt++;
                        loc[1] = i;
                    } else {
                        cnt = 1;
                        loc[0] = i;
                        state = now.kind;
                    }
                    break;
                }

                case 2: {
                    if (now.kind == state) {
                        cnt++;
                        loc[2] = i;
                    } else {
                        cnt = 1;
                        loc[1] = null;
                        loc[0] = i;
                        state = now.kind;
                    }
                    break;
                }

                case 3: {
                    if (now.kind == state) {
                        cnt++;
                        loc[3] = i;
                    } else {
                        cnt = 9;
                    }
                    break;
                }

                case 4: {
                    if (now.kind == state) {
                        loc[4] = i;
                        cnt = 9;
                    } else {
                        cnt = 9;
                    }
                    break;
                }

                case 9: {
                    break;
                }
            }
        }
        if (cnt == 9) {
            cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (loc[i] != null) {
                    src[x][y + i].matchMe();
                    cnt++;
                }
            }
        } else {
            cnt = 0;
        }

        return cnt;
    }

    private static void mark3R(int x, int y) {
        int cnt;
        boolean zf, onef, lastf, last2f;
        for (int i = 2; i >= 0; i--) {
            cnt = 0;
            src[x][y - i].matchMe();
            src[x][y - i].makeSpecial(true, 0xfff0);
            //查看纵向是否能形成L等图形
            zf = (x == 0);
            onef = (x == 1);
            lastf = (x == (CD.BOARD_SIZE_X - 1));
            last2f = (x == (CD.BOARD_SIZE_X - 2));
            if (zf) {
                cnt = markAdjacentC(x, y - i);
            } else if (onef) {
                cnt = markAdjacentC(x - 1, y - i);
            } else if (last2f) {
                cnt = markAdjacentC(x - 3, y - i);
            } else if (lastf) {
                cnt = markAdjacentC(x - 4, y - i);
            } else {
                cnt = markAdjacentC(x - 2, y - i);
            }

            switch (cnt) {
                case 3:
                    src[x][y - i].makeSpecial(CD.L);
                    break;
                case 4:
                    src[x][y - i].makeSpecial(CD.ST);
                    break;
                case 5:
                    src[x][y - i].makeSpecial(CD.LTC);
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void mark3C(int x, int y) {
        int cnt;
        boolean zf, onef, lastf, last2f;
        for (int i = 2; i >= 0; i--) {

            src[x - i][y].matchMe();
            src[x - i][y].makeSpecial(true, 0xfff0);
            //查看是否能形成L等图形
            zf = (y == 0);
            onef = (y == 1);
            lastf = (y == (CD.BOARD_SIZE_Y - 1));
            last2f = (y == (CD.BOARD_SIZE_Y - 2));
            if (zf) {
                cnt = markAdjacentR(x - i, y);
            } else if (onef) {
                cnt = markAdjacentR(x - i, y - 1);
            } else if (last2f) {
                cnt = markAdjacentR(x - i, y - 3);
            } else if (lastf) {
                cnt = markAdjacentR(x - i, y - 4);
            } else {
                cnt = markAdjacentR(x - i, y - 2);
            }

            switch (cnt) {
                case 3:
                    src[x - i][y].makeSpecial(CD.L);
                    break;
                case 4:
                    src[x - i][y].makeSpecial(CD.ST);
                    break;
                case 5:
                    src[x - i][y].makeSpecial(CD.LTC);
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void mark4R(int x, int y) {
        int cnt = 0;
        boolean zf, onef, lastf, last2f;
        for (int i = 3; i >= 0; i--, cnt = 0) {
            if ((src[x][y - i].getSpecial() & 0xf) == CD.FIRED) {
                src[x][y - i].makeSpecial(CD.FOURR);
                src[x][y - i].makeSpecial(true, 0xfff0);
            }
            src[x][y - i].matchMe();
            zf = (x == 0);
            onef = (x == 1);
            lastf = (x == (CD.BOARD_SIZE_X - 1));
            last2f = (x == (CD.BOARD_SIZE_X - 2));
            if (zf) {
                cnt = markAdjacentC(x, y - i);
            } else if (onef) {
                cnt = markAdjacentC(x - 1, y - i);
            } else if (last2f) {
                cnt = markAdjacentC(x - 3, y - i);
            } else if (lastf) {
                cnt = markAdjacentC(x - 4, y - i);
            } else {
                cnt = markAdjacentC(x - 2, y - i);
            }
            switch (cnt) {
                case 3:
                    src[x][y - i].makeSpecial(CD.ST);
                    break;
                case 4:
                    src[x][y - i].makeSpecial(CD.LTC);
                    break;
                case 0:
                    break;
            }

        }
    }

    private static void mark4C(int x, int y) {
        int cnt;
        boolean zf, onef, lastf, last2f;
        for (int i = 3; i >= 0; i--) {
            if ((src[x - i][y].getSpecial() & 0xf) == CD.FIRED) {
                src[x - i][y].makeSpecial(CD.FOURC);
                src[x - i][y].makeSpecial(true, 0xfff0);
            }
            src[x - i][y].matchMe();
            //查看是否能形成L等图形
            zf = (y == 0);
            onef = (y == 1);
            lastf = (y == (CD.BOARD_SIZE_Y - 1));
            last2f = (y == (CD.BOARD_SIZE_Y - 2));
            if (zf) {
                cnt = markAdjacentR(x - i, y);
            } else if (onef) {
                cnt = markAdjacentR(x - i, y - 1);
            } else if (last2f) {
                cnt = markAdjacentR(x - i, y - 3);
            } else if (lastf) {
                cnt = markAdjacentR(x - i, y - 4);
            } else {
                cnt = markAdjacentR(x - i, y - 2);
            }

            switch (cnt) {
                case 3:
                    src[x - i][y].makeSpecial(CD.ST);
                    break;
                case 4:
                    src[x - i][y].makeSpecial(CD.LTC);
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void mark5R(int x, int y) {
        int cnt = 0;
        boolean zf, onef, lastf, last2f;
        for (int i = 4; i >= 0; i--, cnt = 0) {
            if ((src[x][y - i].getSpecial() & 0xf) == CD.FIRED) {
                src[x][y - i].makeSpecial(CD.FIVE);
                src[x][y - i].makeSpecial(true, 0xfff0);
            }
            src[x][y - i].matchMe();
            zf = (x == 0);
            onef = (x == 1);
            lastf = (x == (CD.BOARD_SIZE_X - 1));
            last2f = (x == (CD.BOARD_SIZE_X - 2));
            if (zf) {
                cnt = markAdjacentC(x, y - i);
            } else if (onef) {
                cnt = markAdjacentC(x - 1, y - i);
            } else if (last2f) {
                cnt = markAdjacentC(x - 3, y - i);
            } else if (lastf) {
                cnt = markAdjacentC(x - 4, y - i);
            } else {
                cnt = markAdjacentC(x - 2, y - i);
            }
            switch (cnt) {
                case 3:
                    src[x][y - i].makeSpecial(CD.LTR);
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void mark5C(int x, int y) {
        int cnt;
        boolean zf, onef, lastf, last2f;
        for (int i = 4; i >= 0; i--) {
            if ((src[x - i][y].getSpecial() & 0xf) == CD.FIRED) {
                src[x - i][y].makeSpecial(CD.FIVE);
                src[x - i][y].makeSpecial(true, 0xfff0);
            }
            src[x - i][y].matchMe();
            //查看是否能形成L等图形
            zf = (y == 0);
            onef = (y == 1);
            lastf = (y == (CD.BOARD_SIZE_Y - 1));
            last2f = (y == (CD.BOARD_SIZE_Y - 2));
            if (zf) {
                cnt = markAdjacentR(x - i, y);
            } else if (onef) {
                cnt = markAdjacentR(x - i, y - 1);
            } else if (last2f) {
                cnt = markAdjacentR(x - i, y - 3);
            } else if (lastf) {
                cnt = markAdjacentR(x - i, y - 4);
            } else {
                cnt = markAdjacentR(x - i, y - 2);
            }

            switch (cnt) {
                case 3:
                    src[x - i][y].makeSpecial(CD.LTC);
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void markMoreR(int len, int x, int y) {
        for (int i = len - 1; i >= 0; i--) {
            src[x][y - i].matchMe();
            src[x][y - i].makeSpecial(true, 0xfff0);
        }
    }

    private static void markMoreC(int len, int x, int y) {
        for (int i = len - 1; i >= 0; i--) {
            src[x - i][y].matchMe();
            src[x - i][y].makeSpecial(true, 0xfff0);
        }
    }

    //如果一列发生移动，则只需要考虑行匹配
    private static void markRow() {
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            markSingleRow(i);
        }
    }

    private static void markColumn() {
        for (int i = 0; i < CD.BOARD_SIZE_Y; i++) {
            markSingleColumn(i);
        }
    }
    //markSingle Line
    private static void markSingleRow(int x) {
        int cnt = 0;
        char state = '0';
        Diamond[] temp = new Diamond[CD.BOARD_SIZE_Y];
        Diamond now;
        for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
            now = src[x][j];
            switch (cnt) {
                case 0: {
                    cnt++;
                    state = now.kind;
                    temp[0] = now;
                    break;
                }
                case 1: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                    } else {
                        cnt = 1;
                        state = now.kind;
                        temp[0] = now;
                    }
                    break;
                }
                case 2: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (j == CD.BOARD_SIZE_Y - 1) {
                            mark3R(x, j);
                        }

                    } else {
                        cnt = 1;
                        state = now.kind;
                        temp[0] = now;
                    }
                    break;
                }
                case 3: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (j == CD.BOARD_SIZE_Y - 1) {
                            mark4R(x, j);
                        }
                    } else {
                        mark3R(x, j - 1);
                        cnt = 1;
                        state = now.kind;
                        temp[0] = now;
                    }
                    break;
                }
                case 4: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (j == CD.BOARD_SIZE_Y - 1) {
                            mark5R(x, j);
                        }
                    } else {
                        mark4R(x, j - 1);
                        cnt = 1;
                        state = now.kind;
                        temp[3] = null;
                        temp[0] = now;
                    }
                    break;
                }
                case 5: {
                    if (now.kind != state) {
                        mark5R(x, j - 1);
                        cnt = 1;
                        state = now.kind;
                        temp[3] = null;
                        temp[4] = null;
                        temp[0] = now;
                    } else {
                        temp[cnt++] = now;
                        if (j == CD.BOARD_SIZE_Y - 1) {
                            markMoreR(cnt, x, j);
                        }
                    }
                    break;
                }
                default: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (j == CD.BOARD_SIZE_Y - 1) {
                            markMoreR(cnt, x, j);
                        }
                    } else {
                        markMoreR(cnt, x, j - 1);
                        temp = new Diamond[CD.BOARD_SIZE_Y];
                        temp[0] = now;
                        cnt = 1;
                        state = now.kind;
                    }
                }
            }
        }


    }

    //markSingle Column
    private static void markSingleColumn(int y) {
        int cnt = 0;
        char state = '0';
        Diamond[] temp = new Diamond[CD.BOARD_SIZE_Y];
        Diamond now;
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            now = src[i][y];
            switch (cnt) {
                case 0: {
                    cnt++;
                    state = now.kind;
                    temp[0] = now;
                    break;
                }
                case 1: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                    } else {
                        cnt = 1;
                        state = now.kind;
                        temp[0] = now;
                    }
                    break;
                }
                case 2: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (i == CD.BOARD_SIZE_X - 1) {
                            mark3C(i, y);
                        }

                    } else {
                        cnt = 1;
                        state = now.kind;
                        temp[0] = now;
                    }
                    break;
                }
                case 3: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (i == CD.BOARD_SIZE_X - 1) {
                            mark4C(i, y);
                        }
                    } else {
                        mark3C(i - 1, y);
                        cnt = 1;
                        state = now.kind;
                        temp[0] = now;
                    }
                    break;
                }
                case 4: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (i == CD.BOARD_SIZE_X - 1) {
                            mark5C(i, y);
                        }
                    } else {
                        mark4C(i - 1, y);
                        cnt = 1;
                        state = now.kind;
                        temp[3] = null;
                        temp[0] = now;
                    }
                    break;
                }
                case 5: {
                    if (now.kind != state) {
                        mark5C(i - 1, y);
                        cnt = 1;
                        state = now.kind;
                        temp[3] = null;
                        temp[4] = null;
                        temp[0] = now;
                    } else {
                        if (i == CD.BOARD_SIZE_X - 1) {
                            markMoreR(cnt, i, y);
                        }
                    }
                    break;
                }
                default: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
                        if (i == CD.BOARD_SIZE_Y - 1) {
                            markMoreR(cnt, i, y);
                        }
                    } else {
                        markMoreC(cnt, i - 1, y);
                        temp = new Diamond[CD.BOARD_SIZE_Y];
                        temp[0] = now;
                        cnt = 1;
                        state = now.kind;
                    }
                }
            }
        }
    }

    //mark special five
    public static void markFive(Diamond diamond) {
        markFive(diamond.kind);
    }

    public static void markFive(char kind) {
        Diamond[][] special = BoardInfor.getBoardInformation();
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                if (special[i][j].kind == kind) {
                    special[i][j].matchMe();
                }
            }
            BoardInfor.setBoardInformation(special);
        }
    }



}
