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

    public static boolean move(Point a, Point b) {
        a = mouseMagnet(a);
        b = mouseMagnet(b);
        boolean ret = Judge.isValid(a.x, a.y, b.x, b.y);
        if (ret) {
            Diamond[][] src = BoardInfor.getBoardInformation();
            Diamond temp;
            temp = src[a.x][a.y];
            src[a.x][a.y] = src[b.x][b.y];
            src[b.x][b.y] = temp;
            BoardInfor.setBoardInformation(src);
            src[a.x][a.y].makeSpecial(CD.FIRED);
            src[b.x][b.y].makeSpecial(CD.FIRED);
            if ((src[a.x][a.y].getSpecial() & 0xf0) == 0x50) {
                Match.markFive(src[b.x][b.y]);
            } else if ((src[b.x][b.y].getSpecial() & 0xf0) == 0x50) {
                Match.markFive(src[a.x][a.y]);
            } else {
                Match.mark(a.x, a.y, b.x, b.y);
            }

        }
        return ret;

    }


}
