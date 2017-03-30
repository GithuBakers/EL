package logic;

import data.BoardInfor;
import java.util.LinkedList;
import static data.CD.BOARD_SIZE;
/**
 * Created by DELL on 2017/3/30.
 * 用于模拟下落过程
 */
public class Move {
    private static LinkedList<Character> NumberList = new LinkedList<>();
    private static char[][] src;

    public static void move() {
        src = BoardInfor.getInformation();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0;j<BOARD_SIZE;j++){
                NumberList.add(src[i][j]);
            }

            int cnt=0;
            for (int k = 0; k < BOARD_SIZE-cnt; k++) {
                if (NumberList.get(k).equals('A') || NumberList.get(k).equals('B') || NumberList.get(k).equals('C') || NumberList.get(k).equals('D')) {
                    NumberList.remove(k);
                    cnt++;
                    k--;
                }
            }

            do {
                NumberList.add('0');
            }while (NumberList.size()<BOARD_SIZE);

            for(int l = 0;l<BOARD_SIZE;l++){
                src[i][l] = NumberList.get(l);
            }
            NumberList = new LinkedList<>();
        }
        BoardInfor.setInformation(src);
    }
}


