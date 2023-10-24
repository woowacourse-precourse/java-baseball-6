package baseball;

import baseball.controller.BaseballController;
import baseball.view.OutView;

public class Application {
    public static void main(String[] args) {

        OutView.printStartMessage();
        BaseballController BaseballController = new BaseballController();
        while(true){
            BaseballController.PlayGame();
            if(BaseballController.IsRestart()){
                continue;
            }
            break;
        }
    }
}
