package logic;

import java.awt.*;
import java.awt.event.MouseEvent;

import static data.CD.INTERVAL;

/**
 * 这个类用来写逻辑层的一些好用的快捷方法
 * All the methods should be static.
 */
public class LogicUtilities {
    //这个构造器确保了这个类永远不会被构造出对象
    private LogicUtilities(){}

    //这个方法被用来将鼠标点击靠近取整
    public static Point mouseMagnet(MouseEvent event){
        int x=event.getX();
        int y=event.getY();
        int dx,dy;
        dx=(x/INTERVAL) + Math.round( (x%INTERVAL) / (INTERVAL*0.5F) );
        dy=(y/INTERVAL) + Math.round( (y%INTERVAL) / (INTERVAL*0.5F) );
        return new Point(dx,dy);
    }


}
