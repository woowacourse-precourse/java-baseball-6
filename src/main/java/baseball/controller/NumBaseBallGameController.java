package baseball.controller;

import baseball.my_func.NumConvertor;
import baseball.my_func.ComputerNum;
import baseball.my_io.MyInput;
import baseball.my_io.MyOutput;
import baseball.my_sol.Nums;
import baseball.my_sol.Score;
import baseball.my_sol.MyCheckScore;

import java.util.List;

public class NumBaseBallGameController {
    public void startGame() {
        MyInput.startGame();
        do {
            playGame();
        } while (MyInput.decideContinueGame());
    }

    private void playGame() {
        Nums computer_num = new Nums(ComputerNum.setComputerNum());

        Score playerScore;
        do {
            List<Integer> userInput = NumConvertor.mapToInt(MyInput.receiveUserInput());
            Nums userBalls = new Nums(userInput);
            MyCheckScore myCheckScore = new MyCheckScore(userBalls, computer_num);

            playerScore = myCheckScore.notifyResult();
            MyOutput.printGameResult(playerScore.getStrike(), playerScore.getBall());
        } while (!gameEnd(playerScore.getStrike()));
    }

    private boolean gameEnd(int strike) {
        return strike == 3;
    }
}
