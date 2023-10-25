package baseball.controller;

import baseball.repository.BaseballRepository;
import baseball.service.utils.InputValidatorUtils;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    public BaseballRepository baseballRepository = new BaseballRepository();
    public InputValidatorUtils inputValidatorUtils = new InputValidatorUtils();
    public void readUserNumber() {
        System.out.printf("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (inputValidatorUtils.isValidInput(input)) {
            baseballRepository.saveUser(input);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
