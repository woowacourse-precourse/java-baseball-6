package baseball.controller;

import baseball.repository.BaseballRepository;
import baseball.service.utils.InputValidatorUtils;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private static final int BASEBALL_GAME = 3;
    private static final int NEW_GAME_START = 1;
    public BaseballRepository baseballRepository = new BaseballRepository();
    public InputValidatorUtils inputValidatorUtils = new InputValidatorUtils();

    public void readUserNumber() {
        System.out.printf("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (inputValidatorUtils.isValidInput(input, BASEBALL_GAME)) {
            baseballRepository.saveUser(input);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int askForNewGameOrExit() {
        String input = Console.readLine();

        if (inputValidatorUtils.isValidInput(input, NEW_GAME_START)) {
            return Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
