package baseball.presentation;

import camp.nextstep.edu.missionutils.Console;


public class UserInput {

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        exceptionHandler(input);
        return input;
    }

    private void exceptionHandler(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit((char) c))) {
            throw new IllegalArgumentException("입력값이 숫자여야 합니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자여야 합니다.");
        }
    }
}
