package data;

/**
 * Created by xuxiangzhe on 2017/5/7.
 */
public class Diamond {
    public final char kind;
    private int x;
    private int y;
    private int special = 0;
    private int condition = 0;

    public Diamond(char c, int xx, int yy) {
        x = xx;
        y = yy;
        kind = c;
    }

    public boolean isSpecial() {
        return (special != 0) && (special != 3);
    }

    public boolean isMatched() {
        return condition != 0;
    }

    public int getSpecial() {
        return special;
    }

    public void makeSpecial(int a) {
        special = special | a;
    }

    public void matchMe() {
        condition = condition | 1;
        switch (special) {
            //TODO:different types
        }
    }

    @Override
    public boolean equals(Object o) {
        return ((Diamond) o).kind == this.kind;
    }

    @Override
    public String toString() {
        return "" + kind + "@" + x + "@" + y + "@" + special + "@" + condition;
    }

}
