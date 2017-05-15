package view.screens.loader;

import view.screens.FramesController;

/**
 * Created by 15852 on 2017/5/8 0008.
 */
public class FramesLoader {

    public static String classicScreenID="classicScreen";
    public static String classicScreenFile="fxmlFiles/Classic.fxml";
    public static String startScreenID="startScreen";
    public static String startScreenFile="fxmlFiles/Start.fxml";

    public static FramesController loadScreens(){
        FramesController framesController=new FramesController();
        framesController.loadScreen(classicScreenID,classicScreenFile);
        framesController.loadScreen(startScreenID,startScreenFile);

        framesController.setScreen(startScreenID);
        return framesController;
    }
}
