package data;

/**
 * 用词规范（请每位组员在定义 其代表的实际意义从未出现过的 变量时，去查英文字典等资料，然后将推荐的用词写在这里）
 *
 * 整个游戏场地  Board（来源于棋盘：check board）
 * 宝石 Diamond
 * 每个DOT的种类：Kind
 * 消除：Match
 * 判断：Judge（其实check更贴切，考虑到已经写了judge类，懒得改了）← 非常不好的做法
 * 间隔：Interval
 *
 *
 *
 */
public class CD {
    public final static int BOARD_SIZE_X = 8;
    public final static int BOARD_SIZE_Y = 8;
    public final static int KIND=4;
    public final static int DIAMOND_SIZE = 20;
    public final static int INTERVAL=30;
    public final static int DELETE = -1;
    public final static int KEEP = 2;
    public final static int NOP = 0;
    //小L，一共5块（3+3-1），九宫格爆炸效果
    public final static int L = 0x21 << 4;
    //小T／大L，一共6块（3+4-1），十字消除
    public final static int ST = 0x22 << 4;
    //大T，一共7（3+5-1）块，一个可以自由发挥的效果
    public final static int LTC = 3 << 4;
    public final static int LTR = 0x23 << 4;
    //4消，整行整列
    public final static int FOURC = 0x4 << 4;
    public final static int FOURR = 0x24 << 4;
    //5消，清楚场上所有同色宝石,并且可以和任意宝石消除
    public final static int FIVE = 0x5 << 4;

}

