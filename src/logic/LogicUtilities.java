package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;

import java.awt.*;

import static data.CD.INTERVAL;

/**
 * 这个类用来写逻辑层的一些好用的快捷方法
 * All the methods should be static.
 */
public class LogicUtilities {
    //这个构造器确保了这个类永远不会被构造出对象
    private LogicUtilities(){}

    //这个方法被用来将鼠标点击靠近取整
    public static Point mouseMagnet(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        int dx,dy;
        dx=(x/INTERVAL) + Math.round( (x%INTERVAL) / (INTERVAL*0.5F) );
        dy=(y/INTERVAL) + Math.round( (y%INTERVAL) / (INTERVAL*0.5F) );
        return new Point(dx,dy);
    }

    //界面调用这个方法之后，如果可以移动，会生成标记后的地图，如果不可以移动，则返回false
    public static boolean move(Point a, Point b) {
        a = mouseMagnet(a);
        b = mouseMagnet(b);
        boolean ret = Judge.isValid(a.x, a.y, b.x, b.y);
        if (ret) {
            //交换
            Diamond[][] src = BoardInfor.getBoardInformation();
            Diamond temp;
            temp = src[a.x][a.y];
            src[a.x][a.y] = src[b.x][b.y];
            src[b.x][b.y] = temp;
            BoardInfor.setBoardInformation(src);

            //标记操作当前操作的，并mark，可以识别五连的特效
            src[a.x][a.y].makeSpecial(CD.FIRED);
            src[b.x][b.y].makeSpecial(CD.FIRED);
            if ((src[a.x][a.y].getSpecial() & 0xf0) == 0x50) {
                Match.markFive(src[b.x][b.y]);
            } else if ((src[b.x][b.y].getSpecial() & 0xf0) == 0x50) {
                Match.markFive(src[a.x][a.y]);
            } else {
                Match.mark(a.x, a.y, b.x, b.y);
            }
            src[a.x][a.y].makeSpecial(true, 0xff0);
            src[b.x][b.y].makeSpecial(true, 0xff0);

        }
        return ret;

    }


}
