package baseball.controller;

import baseball.service.GameService;
import baseball.service.InputException;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    public static String userInput;

    public static void startGame() {
        boolean playGame = true;
        while (playGame) {
            GameService.initGame();
            OutputView.printStartGame();
            while (!GameService.correctAnswer()) {
                OutputView.printGameMessage();
                userInput = Console.readLine();
                InputException.checkUserNumber(userInput);
                InputView.makeGameNumber(userInput);
                GameService.makeHint();
                OutputView.printHint();
            }
            OutputView.printCollect();
            userInput = Console.readLine();
            InputException.checkRestartNumber(userInput);
            InputView.makeGameRestart(userInput);
            playGame = GameService.restartGame();
        }
    }
}
