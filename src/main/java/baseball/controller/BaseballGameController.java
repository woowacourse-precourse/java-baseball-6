package baseball.controller;

import static baseball.constant.GamePlayMessage.RESULT_BALL_MESSAGE;
import static baseball.constant.GamePlayMessage.RESULT_NOTHING_MESSAGE;
import static baseball.constant.GamePlayMessage.RESULT_STRIKE_MESSAGE;

import baseball.model.Number;
import baseball.model.Result;
import baseball.service.BaseballGameService;
import baseball.util.ConsoleIO;

public class BaseballGameController {
    private final BaseballGameService baseballGameService;

    public BaseballGameController() {
        baseballGameService = new BaseballGameService();
    }

    public void run() {
        ConsoleIO.printStartMessage();

        playRound();
    }

    private void playRound() {
        while (true) {
            Number computerNumber = baseballGameService.getComputerNumber();

            playSet(computerNumber);

            if (!baseballGameService.playNextRound(ConsoleIO.readEndOption())) {
                break;
            }
        }
    }

    private void playSet(Number computerNumber) {
        while (true) {
            Number playerNumber = baseballGameService.getPlayerNumber(ConsoleIO.readPlayerNumber());

            Result result = baseballGameService.umpire(computerNumber, playerNumber);
            int ball = result.getBall();
            int strike = result.getStrike();

            if (ball == 0 && strike == 3) {
                ConsoleIO.printResultMessage(strike + RESULT_STRIKE_MESSAGE);
                ConsoleIO.printEndMessage();

                break;
            }

            String resultMessage = "";

            if (ball == 0 && strike == 0) {
                resultMessage = RESULT_NOTHING_MESSAGE;
            } else if (ball == 0 && strike > 0) {
                resultMessage = strike + RESULT_STRIKE_MESSAGE;
            } else if (ball > 0 && strike == 0) {
                resultMessage = ball + RESULT_BALL_MESSAGE;
            } else if (ball > 0 && strike > 0) {
                resultMessage = ball + RESULT_BALL_MESSAGE + " " + strike + RESULT_STRIKE_MESSAGE;
            }

            ConsoleIO.printResultMessage(resultMessage);
        }
    }
}
