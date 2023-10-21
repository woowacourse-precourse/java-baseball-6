package baseball.UserNumber;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {

    public void validateInputNumber(String input) {
        if (input.length() != 3 || !input.matches("\\d+")) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }

    }

    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return input;
    }
}
