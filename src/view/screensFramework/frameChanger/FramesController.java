package view.screensFramework.frameChanger;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import javax.lang.model.element.Name;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class FramesController extends StackPane{
    private HashMap<String,Node> map=new HashMap<>();
    private Parent pane;

    public Node getScreen(String name){
        return map.get(name);
    }

    public void loadScreen(String name,String sourse){
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource(sourse));
            this.pane=loader.load();
            ControlledFrame controlledFrame=loader.getController();
            controlledFrame.setControlledFrame(this);
            map.put(name,pane);

        }catch (Exception e){}
    }

    public void setScreen(String name){
        if(map.get(name)!=null){
            DoubleProperty opacity=opacityProperty();
            if(!getChildren().isEmpty()){
                Timeline fade=new Timeline(
                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,1)),
                        new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);
                                getChildren().add(0,map.get(name));

                                Timeline fadeIn=new Timeline(
                                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,1)),
                                        new KeyFrame(Duration.millis(300),new KeyValue(opacity,0)));
                                fadeIn.play();
                            }
                        },new KeyValue(opacity,0)));
                fade.play();
            }else {
                getChildren().add(0,map.get(name));
//
//                Timeline fadeIn=new Timeline(
//                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,1)),
//                        new KeyFrame(Duration.millis(300),new KeyValue(opacity,0)));
//                fadeIn.play();
            }
        }


    }



}
