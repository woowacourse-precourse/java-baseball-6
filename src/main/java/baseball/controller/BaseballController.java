package baseball.controller;

import baseball.Exception;
import baseball.model.GameNumber;
import baseball.service.BaseballService;
import baseball.view.Info;
import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballController {
    public static void playGame(List<Integer> computerNumber) {
        while (true) {
            Message.gameInput();
            String N = Console.readLine();
            List<Integer> li = BaseballService.changeStrToList(N);
            Exception.verifyException(li);
            int strikes = BaseballService.countStrikes(computerNumber, li);
            int balls = BaseballService.countBalls(computerNumber, li);
            Info.printInfo(strikes, balls);
            if (strikes == GameNumber.STRIKE_OUT) break;
        }
        restartGame();
    }

    public static void restartGame() {
        Message.reStart();
        int game = Integer.parseInt(Console.readLine());
        if (game == GameNumber.GAME_START) {
            List<Integer> computerNumber = GameNumber.randomNumberGenerator();
            playGame(computerNumber);
        } else if (game == GameNumber.GAME_END) {
            return;
        } else {
            Exception.invalidGame();
        }
    }


}
