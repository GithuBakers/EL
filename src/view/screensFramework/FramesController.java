package view.screensFramework;

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
import view.Begin;
import view.screensFramework.ControlledFrame;

import java.util.HashMap;

/**
 * Created by 15852 on 2017/5/7 0007.
 */
public class FramesController extends StackPane{
    private static HashMap<String,Node> map=new HashMap<>();

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

//            controlledFrame
            System.out.println("anybody?");
            addMap(name,pane);

        }catch (Exception e){
            System.out.println("fxxk");
        }
    }

    public void setScreen(String name){

        System.out.println("???");
        if(map.get(name)!=null){

            DoubleProperty opacity=opacityProperty();
            if(!getChildren().isEmpty()){
////                slideOut((AnchorPane)getChildren(),1000).play();
//                System.out.println("fuck");
//                slideOut((AnchorPane)map.get(name))
//                getChildren().remove(0);
//                getChildren().add(0,map.get(name));
//                slideIn((AnchorPane)map.get(name),1000).play();
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

    public void setScreen(String name1,String name2){

        System.out.println("???");
        if(map.get(name2)!=null){

            DoubleProperty opacity=opacityProperty();
            if(!getChildren().isEmpty()){


//                slideIn((AnchorPane)map.get(name2),1000);

//                System.out.println("fuck");
//
//                System.out.println("fuck");
//                getChildren().remove(0);
//                getChildren().add(0,map.get(name2));
//                System.out.println("fuck");
//                slideOut((AnchorPane)map.get(name1),1000);
//
//                new ParallelTransition(
//
//                ).play();
                getChildren().add(0,map.get(name2));
                Timeline fade=new Timeline(

                        new KeyFrame(Duration.ZERO,new KeyValue(map.get(name1).translateXProperty(),0)),
                        new KeyFrame(Duration.millis(500),new KeyValue(map.get(name1).translateXProperty(),-1000)),
                        new KeyFrame(Duration.millis(0), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Timeline fadeIn=new Timeline(
                                        new KeyFrame(Duration.ZERO,new KeyValue(map.get(name2).translateXProperty(),1000)),
                                        new KeyFrame(Duration.millis(500),new KeyValue(map.get(name2).translateXProperty(),0)));
                                fadeIn.play();
                            }}),
                        new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                getChildren().remove(1);
                            }
                        })
                );
                fade.play();

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




    public TranslateTransition slideOut(AnchorPane node, int time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setNode(node);
        slide.setDuration(Duration.millis(time));
//        slide.fromXProperty();
        slide.setFromX(0);
        slide.setToX(-node.getWidth());
//        slide.toXProperty();
        return slide;
    }

    public TranslateTransition slideIn(AnchorPane node, int time) {
        TranslateTransition slide = new TranslateTransition();
        slide.setNode(node);
        slide.setDuration(Duration.millis(time));
        slide.fromXProperty();
        slide.setFromX(node.getWidth());
        slide.setToX(0);
        slide.toXProperty();
        return slide;

    }


}
