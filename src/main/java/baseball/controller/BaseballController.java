package baseball.controller;

import static baseball.common.Constants.*;
import static baseball.domain.Baseball.createAnswer;
import static baseball.view.OutputView.printInfo;
import static baseball.view.OutputView.printResult;

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
        Baseball gameAnswer = createAnswer();

        while (true) {
            printInfo(GAME_INPUT_REQUEST_MESSAGE);
            Baseball guess = baseballService.input();
            Result result = baseballService.compare(guess, gameAnswer);
            printResult(result);
            if (result.getStrikeCount() == DIGIT_COUNT) {
                printInfo(GAME_CLEAR_MESSAGE);
                break;
            }
        }
    }
}
