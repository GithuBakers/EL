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
    public static String settingScreenID="settingScreen";
    public static String settingScreenFile="fxmlFiles/Setting.fxml";
    public static String blackScreenID="blackScreen";
    public static String blackScreenFile="fxmlFiles/Black.fxml";
    public static String beginningChoiceScreenID="beginningChoice";
    public static String beginningChoiceScreenFile="fxmlFiles/BeginningChoice.fxml";
    public static String settingInGameScreenID="settingInGame";
    public static String settingInGameScreenFile="fxmlFiles/SettingInGame.fxml";
    public static String rejudgeScreenID="rejudge";
    public static String rejudgeScreenFile="fxmlFiles/Rejudge.fxml";

    public static FramesController loadScreens(){
        FramesController framesController=new FramesController();
        framesController.loadScreen(classicScreenID,classicScreenFile);
        framesController.loadScreen(startScreenID,startScreenFile);
        framesController.loadScreen(settingScreenID,settingScreenFile);
        framesController.loadScreen(blackScreenID,blackScreenFile);
        framesController.loadScreen(beginningChoiceScreenID,beginningChoiceScreenFile);
        framesController.loadScreen(settingInGameScreenID,settingInGameScreenFile);
        framesController.loadScreen(rejudgeScreenID,rejudgeScreenFile);

        framesController.setScreen(startScreenID);
        return framesController;
    }
}
