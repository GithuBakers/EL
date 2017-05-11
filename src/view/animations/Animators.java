package view.animations;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Created by 15852 on 2017/5/9 0009.
 */
public class Animators {
    private boolean isSlideInLeft=false;
    private boolean isSlideInRight=false;
    private boolean isFadeIn=false;


    public void setAnimation(AnimatorSetting as){
        switch (as){
            case ANIMATOR_SLIDEINLEFT:
                isSlideInLeft=true;
                break;
            case ANIMATOR_SLIDEINRIGHT:
                isSlideInRight=true;
                break;
            case ANIMATOR_FADEIN:
                isFadeIn=true;
                break;
            default:
                break;
        }
    }


    public Timeline showTime(Node screen1,Node screen2,int durMillis){
        Timeline show=new Timeline();
        if(isSlideInLeft){
            show=slideInLeft(screen1,screen2,durMillis);
        }else if(isSlideInRight){
            show=slideInRight(screen1,screen2,durMillis);
        }else if(isFadeIn){
            show=fadeIn(screen1,screen2,durMillis);
        }

        return show;
    }





    public Timeline slideInLeft(Node screen1,Node screen2,int durMillis){

        Timeline slideInLeft=new Timeline(

                new KeyFrame(Duration.millis(durMillis),new KeyValue(screen1.translateXProperty(),-1000)),

                new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        Timeline slideIn=new Timeline(
                                new KeyFrame(Duration.ZERO,new KeyValue(screen2.translateXProperty(),1000,Interpolator.EASE_OUT)),
                                new KeyFrame(Duration.millis(durMillis),new KeyValue(screen2.translateXProperty(),0)));
                        slideIn.play();
                    }},new KeyValue(screen1.translateXProperty(),0, Interpolator.EASE_IN)));
        return  slideInLeft;
    }




    public Timeline slideInRight(Node screen1,Node screen2,int durMillis){

        Timeline slideInRight=new Timeline(

                new KeyFrame(Duration.millis(durMillis),new KeyValue(screen1.translateXProperty(),1000)),
                new KeyFrame(Duration.millis(0), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        Timeline slideIn=new Timeline(
                                new KeyFrame(Duration.ZERO,new KeyValue(screen2.translateXProperty(),-1000,Interpolator.EASE_OUT)),
                                new KeyFrame(Duration.millis(durMillis),new KeyValue(screen2.translateXProperty(),0)));
                        slideIn.play();
                    }},new KeyValue(screen1.translateXProperty(),0,Interpolator.EASE_IN)));
        return  slideInRight;
    }




    public Timeline fadeIn(Node screen1,Node screen2,int durMillis){
        Timeline fadeIn=new Timeline(
                new KeyFrame(Duration.millis(durMillis),new KeyValue(screen1.opacityProperty(),0)),

                new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        Timeline fadeIn=new Timeline(
                                new KeyFrame(Duration.ZERO,new KeyValue(screen2.opacityProperty(),0)),
                                new KeyFrame(Duration.millis(durMillis),new KeyValue(screen2.opacityProperty(),1)));
                        fadeIn.play();
                    }
                },new KeyValue(screen1.opacityProperty(),1)));
        return fadeIn;


    }

}
