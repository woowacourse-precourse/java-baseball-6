package baseball.controller;

import static baseball.common.Constants.DIGIT_COUNT;
import static baseball.common.Constants.GAME_CLEAR_MESSAGE;
import static baseball.common.Constants.GAME_INPUT_REQUEST_MESSAGE;
import static baseball.common.Constants.GAME_RESTART_MESSAGE;
import static baseball.common.Constants.PROGRAM_START_MESSAGE;
import static baseball.common.Constants.PROGRAM_STOP_MESSAGE;
import static baseball.common.Constants.WANT_TO_RESTART;
import static baseball.domain.Baseball.createAnswer;
import static baseball.validator.InputValidator.validateRestart;
import static baseball.view.OutputView.printInfo;
import static baseball.view.OutputView.printResult;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Baseball;
import baseball.domain.Result;
import baseball.service.BaseballService;

public class BaseballController {
    BaseballService baseballService;

    public BaseballController() {
        baseballService = new BaseballService();
    }

    public void start() throws IllegalArgumentException {
        printInfo(PROGRAM_START_MESSAGE);

        while (true) {
            playGame();
            if (!wantsToRestart()) {
                printInfo(PROGRAM_STOP_MESSAGE);
                break;
            }
        }
    }

    private void playGame() {
        Baseball gameAnswer = createAnswer();

        while (true) {
            printInfo(GAME_INPUT_REQUEST_MESSAGE);
            Baseball guess = baseballService.inputAnswer();
            Result result = baseballService.compare(guess, gameAnswer);

            printResult(result);
            if (result.getStrikeCount() == DIGIT_COUNT) {
                printInfo(GAME_CLEAR_MESSAGE);
                break;
            }
        }
    }

    private boolean wantsToRestart() {
        printInfo(GAME_RESTART_MESSAGE);
        int userInput = validateRestart(readLine());
        if (userInput == WANT_TO_RESTART) {
            return true;
        }
        return false;
    }
}
