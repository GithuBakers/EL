import Data.MapInfor;
import Logic.Judge;
import Logic.Match;

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
        MapInfor.setInformation(sample);
        System.out.println(Judge.judgeMatch3('b'));
        Match.match();
        System.out.println(Arrays.deepToString(MapInfor.getInformation()));
    }
}
