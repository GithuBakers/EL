import data.BoardInfor;
import logic.Judge;
import logic.Match;

import java.util.Arrays;

/**
 * Created by xuxiangzhe on 2017/3/23.
 */
public class Main {
    public static void main(String[] args) {
        char[][] sample={{'a','b','b','b','c','c','a','d'},
                        {'a','b','b','b','c','c','a','d'},
                {'d','b','b','b','d','c','d','a'},
                {'a','b','b','b','c','c','a','d'},
                {'a','b','b','b','c','c','a','d'},
                {'d','b','b','b','d','c','d','a'},
                {'a','b','b','b','c','c','a','d'},
                {'a','b','b','b','c','c','a','d'}};
        BoardInfor.setInformation(sample);
        System.out.println(Judge.judgeMatch3('b'));
        System.out.println(Arrays.deepToString(BoardInfor.getInformation()));
    }
}
