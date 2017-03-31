package view;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 写这个完全是为了凸显界面的存在感……(╯°Д°）╯︵ /(.□ . \)←小白
 */

public class Begin extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene sceneGrid=new Scene(grid,1000,1000);
        primaryStage.setTitle("EL version 1.0");
        primaryStage.setScene(sceneGrid);
        primaryStage.show();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ColorSelector colorSelector=new ColorSelector();
                Rectangle rect=new Rectangle(80,80,Color.web(colorSelector.getColor(i,j)));
                grid.add(rect,i,j);
            }
        }



    }
}
