package baseball;

import baseball.controller.BaseballGame;
import baseball.model.ComputerNumber;
import baseball.model.ReplayNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static  void main(String[] args) {
        // TODO: 프로그램 구현

        OutputView.printGameStart(); //1

        do {

            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        }while (Reask());

    }
    public static boolean Reask(){//2
        ReplayNumber replayNumber = new ReplayNumber(InputView.setReplayNumber());
        if (ReplayNumber.getReplayNumber().equals("1")){
            return true;
        }
        return false;
    }
}
