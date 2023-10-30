package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Keyboard {

    public String getInput() {
        System.out.print("숫자를 입력 해 주세요 : ");
        String input = Console.readLine();
        checkInput(input);
        return input;
    }

    public void checkInput(String input) {
        if (isInvalidInput(input) || hasDuplicateNumber(input)) {
            throw new IllegalArgumentException("잘못된 값이 입력 되었습니다.");
        }
    }

    public boolean isInvalidInput(String input) {
        return input.matches("^[1-9]") || input.length() != 3;
    }

    public boolean hasDuplicateNumber(String input) {
        return input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2);
    }
}
