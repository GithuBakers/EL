package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;

/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class xxzNJudge {
    private static Diamond[][] src;

    //检查全图中是否可还有可以自动去掉的东西
    public static boolean isUnfinished(Boolean... x) {
        if (x.length == 0) {
            src = BoardInfor.getBoardInformation();
        }
        int cnt = 0;
        char state = '0';
        Diamond now;

        for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
            for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
                now = src[i][j];
                switch (cnt) {
                    case 0: {
                        cnt++;
                        state = now.kind;
                        break;
                    }
                    case 1: {
                        if (now.kind == state) {
                            cnt++;
                        } else {
                            cnt = 0;
                            state = now.kind;
                        }
                        break;
                    }
                    case 2: {
                        if (now.kind == state) {
                            cnt++;
                        } else {
                            cnt = 0;
                            state = now.kind;
                        }
                        break;
                    }
                    case 3: {
                        cnt = 0;
                        return true;
                    }
                }
            }
        }

        for (int j = 0; j < CD.BOARD_SIZE_Y; j++) {
            for (int i = 0; i < CD.BOARD_SIZE_X; i++) {
                now = src[i][j];
                switch (cnt) {
                    case 0: {
                        cnt++;
                        state = now.kind;
                        break;
                    }
                    case 1: {
                        if (now.kind == state) {
                            cnt++;
                        } else {
                            cnt = 0;
                            state = now.kind;
                        }
                        break;
                    }
                    case 2: {
                        if (now.kind == state) {
                            cnt++;
                        } else {
                            cnt = 0;
                            state = now.kind;
                        }
                        break;
                    }
                    case 3: {
                        cnt = 0;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //检查一步移动是不是合理
    public static boolean isValid(int x1, int y1, int x2, int y2) {
        boolean ret = false;
        int deltaX = Math.abs(x1 - x2);
        int deltaY = Math.abs(y1 - y2);
        Diamond temp;
        if ((deltaX + deltaY) == 1) {
            src = BoardInfor.getBoardInformation();
            temp = src[x1][y1];
            src[x1][y1] = src[x2][y2];
            src[x2][y2] = temp;
            ret = isUnfinished(false);
        }
        return ret;
    }

    //检查是否是一张合理的地图
    public static boolean isMapValid() {
        boolean ret = false;
        //TODO:unfinished
        return ret;
    }
}
