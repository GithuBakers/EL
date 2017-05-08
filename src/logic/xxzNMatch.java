package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;

/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class xxzNMatch {
    private static Diamond src[][];

    public static void mark() {
        src = BoardInfor.getBoardInformation();
        markLine();
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
                        cnt++;
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

    private static void mark3R(int x, int y) {
        int cnt;
        boolean zf, onef, lastf, last2f;
        for (int i = 2; i >= 0; i--) {
            cnt = 0;
            src[x][y - i].matchMe();
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

    public static void mark4R(int x, int y) {
        int cnt = 0;
        boolean zf, onef, lastf, last2f;
        for (int i = 3; i >= 0; i--, cnt = 0) {
            if ((src[x][y - i].getSpecial() & 0xf) == 1) {
                src[x][y - i].makeSpecial(CD.FOURR);
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

    public static void mark5R(int x, int y) {
        int cnt = 0;
        boolean zf, onef, lastf, last2f;
        for (int i = 4; i >= 0; i--, cnt = 0) {
            if ((src[x][y - i].getSpecial() & 0xf) == 1) {
                src[x][y - i].makeSpecial(CD.FIVE);
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
                case 4:
                    src[x][y - i].makeSpecial(CD.LTR);
                    break;
                case 0:
                    break;
            }
        }
    }

    public static void markMoreR(int len, int x, int y) {
        for (int i = len - 1; i >= 0; i--) {
            src[x][y - i].matchMe();
        }
    }

    //如果一列发生移动，则只需要考虑行匹配
    private static void markLine() {
        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            markSingleLine(i);
        }
    }

    //markSingle Line
    private static void markSingleLine(int x) {
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
                    if (now.kind == state) {
                        temp[cnt++] = now;
                    } else {
                        mark5R(x, j - 1);
                        cnt = 1;
                        state = now.kind;
                        temp[3] = null;
                        temp[4] = null;
                        temp[0] = now;
                    }
                    break;
                }
                default: {
                    if (now.kind == state) {
                        temp[cnt++] = now;
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



}
