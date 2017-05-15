package view.screens.stars;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import view.animations.AnimatorSetting;
import view.screens.loader.FramesLoader;

/**
 * Created by Bay on 2017/5/15 0015.
 * 贩卖星星与钻石的黑市商人----翔哲
 */
public class StarGenerator {
    private AnchorPane anchorPane;

    public StarGenerator(AnchorPane anchorPane){
        this.anchorPane=anchorPane;
        go();
    }

    public void go(){
        Image fuck= StarSelecter.getImage('a');
        javafx.scene.image.ImageView imageView=new javafx.scene.image.ImageView(fuck);

        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setImage(StarSelecter.getModifiedImage('m'));
            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setImage(StarSelecter.getImage('a'));
            }
        });

        imageView.setLayoutX(20);
        imageView.setLayoutY(20);
        anchorPane.getChildren().add(imageView);


        System.out.printf("%f%f",imageView.getLayoutX(),imageView.getLayoutY());

    }






}
