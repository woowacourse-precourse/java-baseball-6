package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String input;

    public String getValidIntegerString() {
        setInput("숫자를 입력해주세요 : ");
        checkInputHasChar();
        checkInputLength();
        checkInputHasZero();
        return input;
    }

    public int getValidMenuNumber() {
        setInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        checkInputHasChar();
        int menuNum = Integer.parseInt(input);
        if (menuNum < 1 || menuNum > 2) {
            throw new IllegalArgumentException("Invalid Menu Number: " + menuNum);
        }
        return menuNum;
    }

    private void setInput(String msg) {
        System.out.print(msg);
        input = Console.readLine();
    }

    private void checkInputHasChar() {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("This input is not Integer: " + input);
        }
    }

    private void checkInputLength() {
        if (input.length() != 3) {
            throw new IllegalArgumentException("Invalid input length.");
        }
    }

    private void checkInputHasZero() {
        if (input.contains("0")) {
            throw new IllegalArgumentException("This input includes zero.");
        }
    }
}
