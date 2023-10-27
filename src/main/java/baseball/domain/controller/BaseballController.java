package baseball.domain.controller;

import baseball.domain.Computer;
import baseball.domain.service.BaseballService;
import baseball.global.constant.Common;
import baseball.global.constant.OutputType;
import baseball.global.utils.ConsoleUtil;
import baseball.global.utils.validator.InputValidator;
import baseball.global.utils.validator.RestartInputValidator;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void run() {
        ConsoleUtil.commonOutput(OutputType.GAME_INITIALIZE.getComment());
        do {
            Computer computer = new Computer();
            baseballService.startGame(computer);
        } while (checkRestart());
    }

    private boolean checkRestart() {
        ConsoleUtil.commonOutput(OutputType.CHOOSE_RESTART.getComment());
        String restart = ConsoleUtil.input();
        InputValidator inputValidator = new RestartInputValidator();
        inputValidator.validate(restart);
        return isRestart(restart);
    }

    private boolean isRestart(String restart) {
        return restart.equals(Common.RESTART.getContent());
    }
}
