package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private int ball;
    private int strike;
    private Computer computer;
    private User user;
    private Validation validation;

    public BaseballGameController() {
        this.computer = new Computer();
        this.validation = new Validation();
        this.computer.makeNumber();
    }

    public void initGame() {
        this.ball = 0;
        this.strike = 0;
        this.user = new User();
    }

    public void inputNumber() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        validation.validNumber(inputNumber);

        for (int i = 0; i < Validation.MAX_INPUT_LENGTH; i++) {
            user.addNumber(Character.getNumericValue(inputNumber.charAt(i)));
        }
    }
}
