package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void greetingMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public Integer inputGuideMsg() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        userInputValidation(input);

        return Integer.parseInt(input);
    }

    private void userInputValidation(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }
}
