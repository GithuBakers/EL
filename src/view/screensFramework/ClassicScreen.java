package view.screensFramework;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class ClassicScreen implements ControlledPane {
    Pane pane;

    @Override
    public void initMyPane(Node pane) {
        this.pane=(Pane)pane;
    }

    @Override
    public void adjustMyPane() {
        Rectangle rectangle=new Rectangle(100,100);
        rectangle.setFill(Color.CHARTREUSE);
        pane.getChildren().add(rectangle);
    }
}
