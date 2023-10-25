package baseball.controller;

import static baseball.view.Message.EndMessage;
import static baseball.view.Message.InputMessage;
import static baseball.view.Message.PlayMessage;
import static baseball.view.Message.RestartMessage;

import baseball.service.BaseballService;
import baseball.utils.RandomNumGenerate;
import java.util.List;

public class BaseballController {
    BaseballService baseballgame = new BaseballService();
    public void run() {
        List<Integer> computerNumber = RandomNumGenerate.create();
        String result = "";

        while (!result.equals("3스트라이크")) {
            InputMessage();
            List<Integer> playerNumber = baseballgame.InputPlayerNumber();
            result = baseballgame.compareNumber(computerNumber, playerNumber);
            PlayMessage(result);
        }
        EndMessage();
        restart();
    }

    public void restart() {
        RestartMessage();
        String restartGame = baseballgame.InputPlayerRestartNumber();
        if (restartGame.equals("1")) {
            run();
        }
    }
}
