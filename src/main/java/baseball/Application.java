package baseball;

import baseball.Controller.BaseballGameController;
import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameModel baseballGameModel = new BaseballGameModel();
        BaseballGameView baseballGameView = new BaseballGameView();
        BaseballGameController baseballGameController = new BaseballGameController(baseballGameModel, baseballGameView);
        
        baseballGameController.play();
    }
}
