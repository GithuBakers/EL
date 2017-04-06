import data.BoardInfor;
import logic.Judge;
import logic.Match;
import logic.Move;
import view.Begin;

import java.util.Arrays;

import static data.CD.BOARD_SIZE;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class Main {
    public static void main(String[] args) {
        char[][] sample = {
                {'a', 'b', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'a', 'b', 'b', 'b', 'c', 'c', 'a', 'd'},
                {'d', 'b', 'b', 'b', 'b', 'c', 'd', 'a'},
                {'a', 'c', 'c', 'a', 'c', 'c', 'c', 'd'},
                {'a', 'c', 'c', 'a', 'b', 'b', 'a', 'd'},
                {'a', 'd', 'd', 'd', 'd', 'c', 'd', 'a'},
                {'a', 'c', 'c', 'd', 'c', 'c', 'a', 'd'},
                {'a', 'd', 'd', 'd', 'c', 'c', 'a', 'd'}};
        BoardInfor.setInformation(sample);
        Begin.main(null);
//        Begin.main(null);
        while (Judge.judgeMatchFinished()) {
            Match.match();
            Move.move();
            print(BoardInfor.getInformation());
        }

    }

    public static void print(char[][] chars) {
        System.out.println("__________________________________");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.println(Arrays.toString(chars[i]));
        }
        System.out.println("__________________________________");
    }
}
