package view.screensFramework;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import view.screensFramework.ControlledFrame;

import java.util.HashMap;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class FramesController extends StackPane{
    private HashMap<String,Node> map=new HashMap<>();

    public Node getScreen(String name){
        return map.get(name);
    }

    public void addMap(String name,Node pane){
        map.put(name,pane);
    }

    public void loadScreen(String name,String sourse){
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource(sourse));
            Parent pane=loader.load();
            System.out.println(name);
            ControlledFrame controlledFrame=loader.getController();
            controlledFrame.setControlledFrame(this);
            System.out.println("anybody?");
            addMap(name,pane);

        }catch (Exception e){
            System.out.println("fxxk");
        }
    }

    public void setScreen(String name){
        System.out.println(map);
        System.out.println("???");
        if(map.get(name)!=null){
            DoubleProperty opacity=opacityProperty();
            if(!getChildren().isEmpty()){
                Timeline fade=new Timeline(
                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,1)),
                        new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);
                                getChildren().add(0,map.get(name));

                                Timeline fadeIn=new Timeline(
                                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,0)),
                                        new KeyFrame(Duration.millis(800),new KeyValue(opacity,1)));
                                fadeIn.play();
                            }
                        },new KeyValue(opacity,0)));
                fade.play();
            }else {
                getChildren().add(0,map.get(name));

                Timeline fadeIn=new Timeline(
                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,0)),
                        new KeyFrame(Duration.millis(800),new KeyValue(opacity,1)));
                fadeIn.play();
                System.out.println("???");
            }
        }else{
            System.out.println("fxxk??");
        }

    }



}
