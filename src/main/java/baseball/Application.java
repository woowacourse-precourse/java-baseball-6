package baseball;

import baseball.Computer.Computer;
import baseball.Game.Game;
import baseball.View.InputView;
import baseball.View.OutputView;

import static baseball.Computer.Computer.checkNum;
import static baseball.Computer.Computer.endRound;
import static baseball.Game.Game.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer.InitGame();
        OutputView.printStart();
        while(retryEnd){
            OutputView.printInput();
            String userInputs = InputView.readGameNumber();
            CreateBall(userInputs);
            checkNum(userNumbers);
            endRound();
            checkGameEnd();
            if(!gameContinue){
                int userRetry = InputView.readRetryNumber();
                checkRetry(userRetry);
            }
        }
        OutputView.printEnd();
    }
}
