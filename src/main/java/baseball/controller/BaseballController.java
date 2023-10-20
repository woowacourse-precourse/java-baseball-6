package baseball.controller;

import static baseball.common.Constants.GAME_INPUT_REQUEST_MESSAGE;
import static baseball.common.Constants.PROGRAM_START_MESSAGE;
import static baseball.domain.Baseball.createAnswer;
import static baseball.view.OutputView.printInfo;

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

        printInfo(GAME_INPUT_REQUEST_MESSAGE);
        Baseball guess = baseballService.input();
        Result result = baseballService.compare(guess, gameAnswer);
    }
}
