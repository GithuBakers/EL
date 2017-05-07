package data;


/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class BoardInfor {
    private static Diamond[][] board = new Diamond[CD.BOARD_SIZE_X][CD.BOARD_SIZE_Y];

    public static Diamond[][] getBoardInformation() {
        return board;
    }

    public static boolean setBoardInformation(Diamond[][] a) {
        board = a;
        return true;
    }

}
