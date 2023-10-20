package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public void greetingMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputGuideMsg() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public List<Integer> inputByConsole() {
        String input = Console.readLine();

        userInputValidation(input);

        return inputConverter(Integer.parseInt(input));
    }

    private void userInputValidation(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }

    private List<Integer> inputConverter(Integer input) {
        List<Integer> convertedInput = new ArrayList<>();

        for (int i = 100; i >= 1; i /= 10) {
            convertedInput.add(input / i);
            input %= i;
        }

        return convertedInput;
    }
}
