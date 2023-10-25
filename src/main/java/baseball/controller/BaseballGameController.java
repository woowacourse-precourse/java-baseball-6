package baseball.controller;

import baseball.domain.BallCount;
import baseball.domain.GameStatus;
import baseball.service.BaseballGameService;
import baseball.service.BaseballGameServiceImpl;
import baseball.validation.InputFormatValidator;
import baseball.view.InputHandler;
import baseball.view.PrintHandler;
import baseball.view.Printer;

import static baseball.domain.GameStatus.GAME_OVER;
import static baseball.domain.GameStatus.PLAYING;

public class BaseballGameController {

    public static void startBaseballGame() {
        Printer.printStartMessage();

        playBaseballGame();
    }

    private static void playBaseballGame() {
        GameStatus gameStatus = PLAYING;
        BaseballGameService baseballGameService = new BaseballGameServiceImpl();
        baseballGameService.setComputerNumbers();

        while (gameStatus == PLAYING) {
            Printer.printPlayMessage();
            String inputNumbers = InputHandler.getInputMessage();

            InputFormatValidator.validateBaseballNumbers(inputNumbers);

            BallCount result = baseballGameService.playGame(inputNumbers);

            PrintHandler.printResultOfGame(result);

            if (result.getStrike() == 3) {
                gameStatus = GAME_OVER;
            }
        }

        Printer.printGameClearMessage();
        Printer.printContinueMessage();

        String choiceOfRestart = InputHandler.getInputMessage();

        InputFormatValidator.validateChoiceNumber(choiceOfRestart);

        if (choiceOfRestart.equals("1")) {
            playBaseballGame();
        }
    }

}
