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

    private static void mark3R(int x, int y) {
        char state = src[x][y].kind;
        int cnt;
        for (int i = 2; i >= 0; i--) {
            cnt = 0;
            src[x][y - i].matchMe();
            //查看纵向是否能形成L等图形
            if (x != 0) {
                if (src[x - 1][y - i].kind == state) {
                    src[x - 1][y - i].matchMe();
                    cnt++;
                    if (x != 1) {
                        if (src[x - 2][y - i].kind == state) {
                            src[x - 2][y - i].matchMe();
                            cnt++;
                        }
                    }
                }
            }
            //TODO:这一段逻辑有问题，明天再想个好办法……(・ω・)ノ
            if (x != CD.BOARD_SIZE_X - 1) {
                if (src[x + 1][y - i].kind == state) {
                    src[x + 1][y - i].matchMe();
                    cnt++;

                    if (x != CD.BOARD_SIZE_X - 2) {
                        if (src[x + 2][y - i].kind == state) {
                            src[x + 2][y - i].matchMe();
                            cnt++;
                        }
                    }
                }
            }

            if (cnt != 0) {
                switch (cnt) {
                    case 2: {
                        src[x][y - i].makeSpecial(CD.L);
                        break;
                    }
                    case 3: {
                        src[x][y - i].makeSpecial(CD.ST);
                        break;
                    }
                    case 4: {
                        src[x][y - i].makeSpecial(CD.LTC);
                        break;
                    }
                }
            }

        }

    }

    public static void mark4R(int x, int y) {
        char state = src[x][y].kind;
        int cnt = 0;
        for (int i = 3; i >= 0; i--, cnt = 0) {
            if ((src[x][y - i].getSpecial() & 0xf) == 1) {
                src[x][y - i].makeSpecial(CD.FOURR);
            }
            src[x][y - i].matchMe();
            //TODO：所以这一段也有问题(´･Д･)」
            //查看纵向是否能形成L等图形
            if (x != 0) {
                if (src[x - 1][y - i].kind == state) {
                    src[x - 1][y - i].matchMe();
                    cnt++;
                    if (x != 1) {
                        if (src[x - 2][y - i].kind == state) {
                            src[x - 2][y - i].matchMe();
                            cnt++;
                        }
                    }
                }
            }
            if (x != CD.BOARD_SIZE_X - 1) {
                if (src[x + 1][y - i].kind == state) {
                    src[x + 1][y - i].matchMe();
                    cnt++;

                    if (x != CD.BOARD_SIZE_X - 2) {
                        if (src[x + 2][y - i].kind == state) {
                            src[x + 2][y - i].matchMe();
                            cnt++;
                        }
                    }
                }
            }

            if (cnt == 2) {
                src[x][y - i].makeSpecial(CD.ST);
            }
        }
    }

    public static void mark5R(int x, int y) {
        char state = src[x][y].kind;
        int cnt = 0;
        for (int i = 4; i >= 0; i--, cnt = 0) {
            if ((src[x][y - i].getSpecial() & 0xf) == 1) {
                src[x][y - i].makeSpecial(CD.FIVE);
            }
            src[x][y - i].matchMe();
            //TODO：还有这一段也是……说好的封装还是变成了复制粘贴🤷‍我也很绝望啊
            //查看纵向是否能形成L等图形
            if (x != 0) {
                if (src[x - 1][y - i].kind == state) {
                    src[x - 1][y - i].matchMe();
                    cnt++;
                    if (x != 1) {
                        if (src[x - 2][y - i].kind == state) {
                            src[x - 2][y - i].matchMe();
                            cnt++;
                        }
                    }
                }
            }
            if (x != CD.BOARD_SIZE_X - 1) {
                if (src[x + 1][y - i].kind == state) {
                    src[x + 1][y - i].matchMe();
                    cnt++;

                    if (x != CD.BOARD_SIZE_X - 2) {
                        if (src[x + 2][y - i].kind == state) {
                            src[x + 2][y - i].matchMe();
                            cnt++;
                        }
                    }
                }
            }

            if (cnt != 0) {
                src[x][y - i].makeSpecial(CD.LTR);
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
                        markMoreR(temp.length, x, j - 1);
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
