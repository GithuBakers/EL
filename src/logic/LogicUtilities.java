package logic;

import data.BoardInfor;
import data.CD;
import data.Diamond;
import javafx.geometry.Point2D;

import static data.CD.INTERVAL;

/**
 * 这个类用来写逻辑层的一些好用的快捷方法
 * All the methods should be static.
 */
public class LogicUtilities {
    //这个构造器确保了这个类永远不会被构造出对象
    private LogicUtilities(){}

    //这个方法被用来将鼠标点击靠近取整
    public static Point2D mouseMagnet(Point2D point) {
        int x = (int) (point.getX() - CD.LAYOUT_INTERVAL);
        int y = (int) (point.getY() - CD.LAYOUT_INTERVAL);
        int dx,dy;
        dx=(x/INTERVAL) + Math.round( (x%INTERVAL) / (INTERVAL*0.5F) );
        dy=(y/INTERVAL) + Math.round( (y%INTERVAL) / (INTERVAL*0.5F) );
        return new Point2D(dx, dy);
    }

    //界面调用这个方法之后，如果可以移动，会生成标记后的地图，如果不可以移动，则返回false
    public static boolean move(Point2D a, Point2D b) {
        a = mouseMagnet(a);
        b = mouseMagnet(b);
        int ax = (int) a.getX(), ay = (int) a.getY();
        int bx = (int) b.getX(), by = (int) b.getY();
        boolean ret = Judge.isValid(ax, ay, bx, by);
        if (ret) {
            //交换
            Diamond[][] src = BoardInfor.getBoardInformation();
            Diamond temp;
            temp = src[ax][ay];
            src[ax][ay] = src[bx][by];
            src[bx][by] = temp;
            BoardInfor.setBoardInformation(src);

            //标记操作当前操作的，并mark，可以识别五连的特效
            src[ax][ay].makeSpecial(CD.FIRED);
            src[bx][by].makeSpecial(CD.FIRED);
            if ((src[ax][ay].getSpecial() & 0xf0) == 0x50) {
                Match.markFive(src[bx][by]);
            } else if ((src[bx][by].getSpecial() & 0xf0) == 0x50) {
                Match.markFive(src[ax][ay]);
            } else {
                Match.mark(ax, ay, bx, by);
            }
            src[ax][ay].makeSpecial(true, 0xff0);
            src[bx][by].makeSpecial(true, 0xff0);

        }
        return ret;

    }


}
