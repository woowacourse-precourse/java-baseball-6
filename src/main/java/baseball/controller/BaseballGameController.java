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

    public BaseballGameController() {
        this.computer = new Computer();
        this.computer.makeNumber();
    }

    public void initGame() {
        this.ball = 0;
        this.strike = 0;
        this.user = new User();
    }

    public boolean startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            initGame();
            inputNumber();
            checkNumber();
            printResult();

            boolean isExit = exitGame();
            if (isExit) {
                return isExit;
            }
        }
    }

    public void inputNumber() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        Validation.validNumber(inputNumber);

        for (int i = 0; i < Validation.MAX_INPUT_LENGTH; i++) {
            user.addNumber(Character.getNumericValue(inputNumber.charAt(i)));
        }
    }

    public boolean inputExitNumber() {

        String inputNum = Console.readLine();

        Validation.validExitNumber(inputNum);

        int exitNum = Integer.parseInt(inputNum);

        if (exitNum == 2) {
            return true;
        }

        computer.makeNumber();

        return false;
    }

    public void checkNumber() {

        for (int i = 0; i < Validation.MAX_INPUT_LENGTH; i++) {
            if (user.getBall(i) == computer.getBall(i)) {
                strike++;
            } else if (computer.containsBall(user.getBall(i))) {
                ball++;
            }
        }
    }

    public void printResult() {

        StringBuilder result = new StringBuilder();

        if (ball > 0) {
            result.append(ball).append("볼 ");
        }
        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }

        if (result.isEmpty()) {
            System.out.println("낫싱");
            return;
        }

        String resultString = result.toString();
        System.out.println(resultString);
    }

    public boolean exitGame() {
        if (strike == Validation.MAX_INPUT_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            return inputExitNumber();
        }

        return false;
    }
}
