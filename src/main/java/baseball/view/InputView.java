package baseball.view;

import baseball.enums.ErrorMessage;
import baseball.enums.InputMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputView {
    public void greetingMsg() {
        System.out.println(InputMessage.START_MSG.getMsg());
    }

    public void inputGuideMsg() {
        System.out.print(InputMessage.INPUT_GUIDE_MSG.getMsg());
    }

    public void askRestartMsg() {
        System.out.println(InputMessage.RESTART_MSG.getMsg());
    }

    public List<Integer> inputByConsole() {
        String input = Console.readLine();
        userInputValidation(input);

        return inputConverter(Integer.parseInt(input));
    }

    public boolean receiveRestartDecisionFromUser() {
        return Objects.equals(Console.readLine(), "1");
    }

    private void userInputValidation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_LENGTH_ERROR.getMsg());
        }

        if (!(input.matches("^[0-9]*$"))) {
            throw new IllegalArgumentException(ErrorMessage.REGEX_ERROR.getMsg());
        }

        for (int i = 0; i < input.length(); i++) {
            checkDuplicatedNumber(i, input.toCharArray());
        }
    }

    private void checkDuplicatedNumber(int i, char[] splitInput) {
        for (int j = i + 1; j < splitInput.length; j++) {
            compareTwoNum(i, j, splitInput);
        }
    }

    private void compareTwoNum(int i, int j, char[] splitInput) {
        if (splitInput[i] == splitInput[j]) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_ERROR.getMsg());
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
