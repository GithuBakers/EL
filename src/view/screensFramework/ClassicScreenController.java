package view.screensFramework;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.Rectangle;
import view.Begin;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class ClassicScreenController implements ControlledFrame {
    private FramesController framesController;

    @FXML
    Button backButton;

    @FXML
    GridPane classicGrid;

    @FXML
    Pane pane12;

    @FXML
    AnchorPane classicAnchor;

    @FXML
    Button fuck;


    public void setFuck(){
        fuck.setText("fuckfuck");
    }

    public void miaomiaomiao(){
        Rectangle rectangle= new Rectangle(50,50);
        rectangle.setFill(Color.BLUE);

        pane12.getChildren().add(rectangle);
        System.out.println(rectangle.getScene().xProperty());

    }

    public void toStart(){
        framesController.setScreen(Begin.classicScreenID,Begin.startScreenID);
    }

    @Override
    public void setControlledFrame(FramesController framesController) {
        this.framesController=framesController;
    }

}
