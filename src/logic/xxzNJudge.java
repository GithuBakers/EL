package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;

/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class xxzNJudge {
    private static Diamond[][] src;

    //
    public static boolean isFinished() {
        src = BoardInfor.getBoardInformation();
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
}
