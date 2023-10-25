package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readClientInputNumber() {

        // 서로 다른 3자리 숫자를 입력받아야 함
        String input = Console.readLine();
        String checkDuplicateString = "";

        for (char i : input.toCharArray()) {

            // 사용자가 입력한 숫자 중에서 중복되는 숫자가 있을 경우 예외를 발생시키는 조건
            if(checkDuplicateString.contains(String.valueOf(i)))
                throw new IllegalStateException("Invalid value entered.");

            checkDuplicateString = checkDuplicateString + i;
        }

        return input;
    }

    public String readRestartNumber() {
        return Console.readLine();
    }
}
