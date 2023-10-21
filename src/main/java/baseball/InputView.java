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
            throw new IllegalArgumentException("3자리의 수를 입력하시오.");
        }

        if (!(input.matches("^[0-9]*$"))) {
            throw new IllegalArgumentException("숫자 외에 다른 문자가 존재합니다.");
        }

        char[] splitInput = input.toCharArray();

        for (int i = 0; i < splitInput.length; i++) {
            checkDuplicatedNumber(i, splitInput);
        }
    }

    private void checkDuplicatedNumber(int i, char[] splitInput) {
        for (int j = i + 1; j < splitInput.length; j++) {
            compareTwoNum(i, j, splitInput);
        }
    }

    private void compareTwoNum(int i, int j, char[] splitInput) {
        if (splitInput[i] == splitInput[j]) {
            throw new IllegalArgumentException("입력에 중복되는 숫자가 존재합니다.");
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
