package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readGuessNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validateDigit(inputString);

        return inputString;
    }

    public String readRestartOrShutDown() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        validateDigit(inputString);

        return inputString;
    }

    private void validateDigit(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
