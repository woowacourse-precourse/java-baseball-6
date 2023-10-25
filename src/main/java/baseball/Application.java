package baseball;

import baseball.Computer.Computer;
import baseball.Game.Game;
import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Computer.Computer.checkNum;
import static baseball.Computer.Computer.endRound;
import static baseball.Game.Game.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> gameNumber = Computer.InitGame();
        OutputView.printStart();
        while(Game.retryEnd){
            OutputView.printInput();
            String userInputs = InputView.readGameNumber();
            CreateBall(userInputs);
            checkNum(gameNumber,userNumbers);
            endRound();
            checkGameEnd();
            if(!Game.gameContinue){
                int userRetry = InputView.readRetryNumber();
                checkRetry(userRetry);
                if(Game.retryEnd==false){
                    break;
                }
                gameNumber = Computer.InitGame();
                OutputView.printStart();
            }
        }
        //OutputView.printEnd();
        //Console.close();
    }
}
