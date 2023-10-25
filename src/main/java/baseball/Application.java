package baseball;

import baseball.controller.NumberBaseballGameController;
import baseball.model.RestartNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            NumberBaseballGameController gameController = new NumberBaseballGameController();
            gameController.startGame();
        }while(restartAsk());
    }
    public static boolean restartAsk(){
        RestartNumber restartNumber = new RestartNumber(InputView.askRestart());
        if(restartNumber.getRestartNumber().equals("1")){
            return true;
        }
        return false;
    }

}
