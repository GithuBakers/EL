package view.screens;

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import view.animations.AnimatorSetting;
import view.animations.Animators;
import view.screens.frameInterface.ControlledFrame;

import java.util.HashMap;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class FramesController extends StackPane{

    private static HashMap<String,Node> map=new HashMap<>();
    private static HashMap<String,FXMLLoader> loaderHashMap=new HashMap<>();

    public Node getScreen(String name){
        return map.get(name);
    }
    public FXMLLoader getFXMLLoader(String name){ return loaderHashMap.get(name); }

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

//            controlledFrame
            System.out.println("anybody?");
            addMap(name,pane);
            loaderHashMap.put(name,loader);

        }catch (Exception e){
            System.out.println("fxxk");
        }
    }

    public void setScreen(String name){

        System.out.println("???");
        if(map.get(name)!=null){

            DoubleProperty opacity=opacityProperty();
            if(!getChildren().isEmpty()){

                Timeline fade=new Timeline(
                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,1)),
                        new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(0);
                                getChildren().add(0,map.get(name));

                                Timeline fadeIn=new Timeline(
                                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,0)),
                                        new KeyFrame(Duration.millis(300),new KeyValue(opacity,1)));
                                fadeIn.play();
                            }
                        },new KeyValue(opacity,0)));
                fade.play();
            }else {
                getChildren().add(0,map.get(name));

                Timeline fadeIn=new Timeline(
                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,0)),
                        new KeyFrame(Duration.millis(1000),new KeyValue(opacity,1)));
                fadeIn.play();
                System.out.println("???");
            }
        }else{
            System.out.println("fxxk??");
        }

    }

    public void setScreen(String name1, String name2, AnimatorSetting as){

        System.out.println("???");
        if(map.get(name2)!=null){

            DoubleProperty opacity=opacityProperty();
            if(!getChildren().isEmpty()){
                Animators animator=new Animators();
                animator.setAnimation(as);
                Timeline slideInLeft=animator.showTime(map.get(name1),map.get(name2),500);

                getChildren().add(0,map.get(name2));
                slideInLeft.getKeyFrames().add(
                        new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(1);
                            }
                }));
                slideInLeft.play();

            }else {
                getChildren().add(0,map.get(name2));

                Timeline fadeIn=new Timeline(
                        new KeyFrame(Duration.ZERO,new KeyValue(opacity,0)),
                        new KeyFrame(Duration.millis(1000),new KeyValue(opacity,1)));
                fadeIn.play();
                System.out.println("???");
            }
        }else{
            System.out.println("fxxk??");
        }

    }






}
