package Data;

import java.awt.*;

/**
 * Created by xuxiangzhe on 2017/3/27.
 */
public class Dot extends Point {
    private  char kind;
    public void setKind(char a){
        kind=a;
    }
    public char getKind(){
        return kind;
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
