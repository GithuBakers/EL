package data;

import java.awt.*;

/**
 * 每个点的抽象
 */

public class Dot extends Point {
    private char kind;

    public void setKind(char a){
        kind=a;
    }
    public char getKind(){
        return kind;
    }

    //下面是几种构造器
    public Dot(){
        super();
    }

    public Dot(int x,int y){
        super(x,y);
    }

    public Dot(int x,int y,char c){
        super(x,y);
        kind=c;
    }

    public Dot(Point p){
        super(p.x,p.y);
    }

    public Dot(Point p,char c){
        super(p.x,p.y);
        kind=c;
    }

    @Override
    public boolean equals(Object a){
        Dot b=(Dot)a;
        if(b.x==this.x && b.y==this.y && b.getKind()==this.kind){
            return true;
        }else {
            return false;
        }
    }
}
