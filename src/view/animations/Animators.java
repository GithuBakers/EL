package view.animations;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Lighting;
import javafx.util.Duration;

/**
 * Created by 15852 on 2017/5/9 0009.
 */
public class Animators {
    private boolean isSlideInLeft=false;
    private boolean isSlideInRight=false;
    private boolean isFadeIn=false;
    private boolean isSlideFromUp=false;
    private boolean isSlideToDown=false;
    private boolean isSlideFromRight=false;
    private boolean isSlideToRight=true;

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
            case ANIMATOR_SLIDEINFROMUP:
                isSlideFromUp=true;
                break;
            case ANIMATOR_SLIDEINTODOWN:
                isSlideToDown=true;
                break;
            case ANIMATOR_SLIDEFROMRIGHT:
                isSlideFromRight=true;
                break;
            case ANIMATOR_SLIDETORIGHT:
                isSlideToRight=true;
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
        }else if(isSlideFromUp){
            show=slideInFromUp(screen1,screen2,durMillis);
        }else if(isSlideToDown){
            show=slideInToDown(screen1,screen2,durMillis);
        }else if(isSlideFromRight){
            show=slideFromRight(screen1,screen2,durMillis);
        }else if(isSlideToRight){
            show=slideToRight(screen1,screen2,durMillis);
        }

        return show;
    }







    public Timeline slideInLeft(Node screen1,Node screen2,int durMillis){
        screen2.translateXProperty().set(1000);
        Timeline slideInLeft=new Timeline(

                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(screen1.translateXProperty(), -1000),
                        new KeyValue(screen2.translateXProperty(),0)),

                new KeyFrame(Duration.ZERO,
                        new KeyValue(screen1.translateXProperty(),0),
                        new KeyValue(screen2.translateXProperty(),1000))
        );

        return  slideInLeft;
    }




    public Timeline slideInRight(Node screen1,Node screen2,int durMillis){
        screen2.translateXProperty().set(-1000);
        Timeline slideInRight=new Timeline(

                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(screen1.translateXProperty(),1000),
                        new KeyValue(screen2.translateXProperty(),0)),
                new KeyFrame(Duration.ZERO,
                        new KeyValue(screen1.translateXProperty(),0),
                        new KeyValue(screen2.translateXProperty(),-1000))
        );
        return  slideInRight;
    }


    public Timeline slideFromRight(Node screen1,Node screen2,int durMillis){
        screen2.translateXProperty().set(1000);
        Lighting lighting=new Lighting();
        screen1.setEffect(lighting);
        lighting.diffuseConstantProperty().set(2);
        Timeline slideFromRight=new Timeline(
                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(screen2.translateXProperty(),200),
                        new KeyValue(lighting.diffuseConstantProperty(),0.5)),
                new KeyFrame(Duration.ZERO,
                        new KeyValue(lighting.diffuseConstantProperty(),2),
                        new KeyValue(screen2.translateXProperty(),1000,Interpolator.TANGENT(Duration.millis(95),10)))
        );
        return slideFromRight;
    }


    public Timeline slideToRight(Node screen1,Node screen2,int durMillis){
//        screen2.translateXProperty().set(0);
        Lighting lighting=new Lighting();
        screen1.setEffect(lighting);
        lighting.diffuseConstantProperty().set(0.5);

        Timeline slideToRight=new Timeline(
                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(lighting.diffuseConstantProperty(),2),
                        new KeyValue(screen2.translateXProperty(),1000,Interpolator.TANGENT(Duration.millis(95),10))),
                new KeyFrame(Duration.ZERO,
                        new KeyValue(lighting.diffuseConstantProperty(),0.5),
                        new KeyValue(screen2.translateXProperty(),200))
        );
        return slideToRight;
    }



    public Timeline fadeIn(Node screen1,Node screen2,int durMillis){
        screen2.opacityProperty().set(0);
        Timeline fadeIn=new Timeline(
                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(screen1.opacityProperty(),0),
                        new KeyValue(screen2.opacityProperty(),1)),
                new KeyFrame(Duration.ZERO,
                        new KeyValue(screen1.opacityProperty(),1),
                        new KeyValue(screen2.opacityProperty(),0))
        );
        return fadeIn;
    }



    public Timeline slideInFromUp(Node screen1,Node screen2,int durMillis){
        screen2.translateYProperty().set(-600);


        Lighting lighting=new Lighting();
        screen1.setEffect(lighting);
        lighting.diffuseConstantProperty().set(2);

        Timeline slideInFromUp=new Timeline(
                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(screen2.translateYProperty(),0),
                        new KeyValue(lighting.diffuseConstantProperty(),0.4)),
                new KeyFrame(Duration.ZERO,
                        new KeyValue(screen2.translateYProperty(),-600,Interpolator.TANGENT(Duration.millis(95),10)),
                        new KeyValue(lighting.diffuseConstantProperty(),2)
                )
        );
        return slideInFromUp;
    }

    public Timeline slideInToDown(Node screen1,Node screen2,int durMillis){

        Lighting lighting=new Lighting();
        lighting.diffuseConstantProperty().set(0.4);
        screen1.setEffect(lighting);

        Timeline slideInToDown=new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(lighting.diffuseConstantProperty(),0.4),
                        new KeyValue(screen2.translateYProperty(),0)),
                new KeyFrame(Duration.millis(durMillis),
                        new KeyValue(screen2.translateYProperty(),1000,Interpolator.TANGENT(Duration.millis(95),10)),
                        new KeyValue(lighting.diffuseConstantProperty(),2))
        );
        return slideInToDown;
    }



}
