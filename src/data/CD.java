package data;

/**
 * 用词规范（请每位组员在定义 其代表的实际意义从未出现过的 变量时，去查英文字典等资料，然后将推荐的用词写在这里）
 *
 * 整个游戏场地  Board（来源于棋盘：check board）
 * 游戏中的每一个小动物／糖果／汽水……Anyway，在逻辑层的抽象： Dot
 * 每个DOT的种类：Kind
 * 消除：Match
 * 判断：Judge（其实check更贴切，考虑到已经写了judge类，懒得改了）← 非常不好的做法
 * 间隔：Interval
 *
 *
 */
public class CD {
    public final static int BOARD_SIZE =8;
    public final static int KIND=4;
    public final static int DOT_SIZE=20;
    public final static int INTERVAL=30;

}
