package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final Rule rule;

    public InputHandler(Rule rule) {
        this.rule = rule;
    }

    public static int getUserGameNumberInput(Rule rule) {
        int userNumber;
        System.out.print("숫자를 입력해주세요: ");
        userNumber = Integer.parseInt(Console.readLine());
        if (!rule.isValidNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public static int getUserGameChoiceInput(Rule rule) {
        int userChoice;
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        userChoice = Integer.parseInt(Console.readLine());
        if (!rule.isValidChoice(userChoice)) {
            throw new IllegalArgumentException();
        }
        return userChoice;
    }

}
