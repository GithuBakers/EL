package view;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.BoardManager;
import view.screens.loader.FramesLoader;

/**
 * 写这个完全是为了凸显界面的存在感……(╯°Д°）╯︵ /(.□ . \)←小白
 */

public class Begin extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BoardManager.generateAll();
        Group root=new Group();
        root.getChildren().addAll(FramesLoader.loadScreens());
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

}


















//    int i = 0;
//    int j = 0;
//    int index = 0;
//    static ArrayList<Double> change = new ArrayList<Double>();
//    //    ArrayList<String> changeColor=new ArrayList<>();
//    static ArrayList<Rectangle> changeRect = new ArrayList<>();






//
//        GridPane grid=new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(25,25,25,25));
//
//        Scene sceneGrid=new Scene(grid,1000,1000);
//
//        primaryStage.setTitle("EL version 1.0");
//        primaryStage.setScene(sceneGrid);
//        primaryStage.show();
//
//        Music bgm = new Music();
//        bgm.init();
//
//        for(i=0;i<8;i++){
//            for(j=0;j<8;j++){
//                ColorSelector colorSelector=new ColorSelector();
//                Rectangle rect=new Rectangle(80,80,Color.web(colorSelector.getColor(i,j)));
//                rect.setArcHeight(20);
//                rect.setArcWidth(20);
//                rect.setOnMousePressed(e -> {
//                            System.out.printf("%f%f", rect.getLayoutX(), rect.getLayoutY());
//                            if(index!=1){
//                                change.add(rect.getLayoutX());
//                                change.add(rect.getLayoutY());
//                                changeRect.add(rect);
//                                index++;
//                            }else {
//                                change.add(rect.getLayoutX());
//                                change.add(rect.getLayoutY());
//                                changeRect.add(rect);
//
//
//                                animation();
//
////                                 grid.getChildren().remove(changeRect.get(1));
////                                grid.getChildren().remove(changeRect.get(0));
//
//
////                                grid.add(changeRect.get(0),(int)((change.get(0)-145)/90),(int)((change.get(1)-145)/90));
////                                grid.add(changeRect.get(1),(int)((change.get(2)-145)/90),(int)((change.get(3)-145)/90));
////                                grid.add(changeRect.get(1),(int)((change.get(0)-145)/90),(int)((change.get(1)-145)/90));
////                                grid.add(changeRect.get(0),(int)((change.get(2)-145)/90),(int)((change.get(3)-145)/90));
//
//
//                                index=0;
//                                change.clear();
//                                changeRect.clear();
//                            }
//                        }
//                    );
//                grid.add(rect,i,j);
//            }
//        }
//
//
//
//    }
//
//    public void animation(){
//        TranslateTransition rect1
//                = new TranslateTransition(Duration.millis(50), changeRect.get(0));
//        rect1.setToX(change.get(2)-change.get(0));
//        rect1.setToY(change.get(3)-change.get(1));
//        rect1.setCycleCount(0);
//
//        TranslateTransition rect2
//                = new TranslateTransition(Duration.millis(50), changeRect.get(1));
//        rect2.setToX(change.get(0)-change.get(2));
//        rect2.setToY(change.get(1)-change.get(3));
//        rect1.setCycleCount(0);
//
//
//        ParallelTransition parallelTransition=new ParallelTransition();
//        parallelTransition.getChildren().addAll(
//                rect1,
//                rect2
//        );
//        parallelTransition.setCycleCount(0);
//        parallelTransition.setAutoReverse(false);
//        parallelTransition.play();
//
//    }
//
//
//
//}
