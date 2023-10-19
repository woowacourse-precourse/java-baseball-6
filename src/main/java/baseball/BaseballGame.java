package baseball;

import model.BaseballNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static model.NumberData.*;


public class BaseballGame {
    BaseballNumber baseballNumber = new BaseballNumber();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    static List<Integer> computerNumber;
    static List<Integer> myNumber;
    static boolean finish = true;

    public void playBaseballGame() {
        computerNumber = baseballNumber.makeBaseballNumber();
        myNumber = new ArrayList<>();
        outputView.gameStart();

        while (finish) { // 게임이 끝날때까지 반복
            outputView.gameNumer();
            myNumber = inputView.inputBaseBall();
            System.out.println(gameResult());
        }

        outputView.gameFinish();
        outputView.restartGame();

        int restart = inputView.inputRetryNumber();
        gameRestart(restart);
    }


    public String gameResult() {
        StringBuilder result = new StringBuilder();

        return result.toString();
    }

    public void gameRestart(int restart) {
        if (restart == RESTART_NUMBER) {
            playBaseballGame();
        }
    }
}
