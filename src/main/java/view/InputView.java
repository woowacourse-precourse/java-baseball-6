package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String GAME_START_MESSAGE ="숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER= "숫자를 입력해주세요:";
    public static final String CHOOES_RESTART_OR_EXIT= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String NUMBER_REGULAR_EXPRESSION = "^[1-9]{3}$";
    static final String EXIT_REGULAR_EXPRESSION = "^[1-2]{1}$";
    public static final String exit = "2";
    public static final String reStart = "1";
    public static final int NUMBER_LENGTH = 3;

    public List<Integer> inputUserNumber() {
        System.out.print(INPUT_NUMBER);
        String inputString = Console.readLine();
        System.out.println(inputString);
        validateInputNumber(inputString);

        return addNumber(inputString);
    }

    public List<Integer> addNumber(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int number = input.charAt(i) - '0';
            validateDuplicate(userNumbers, number);
            userNumbers.add(number);
        }
        return userNumbers;
    }

    public void validateDuplicate(List<Integer> userNumbers, int number) {
        if (userNumbers.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자를 입력헸습니다.");
        }
    }

    public void validateInputNumber(String inputs) {
        if (!inputs.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
        }
    }

    public String programReStartOrExit() {
        String number = Console.readLine();
        validateReStartOrExit(number);
        return number;
    }

    public void validateReStartOrExit(String input) {
        if (!input.matches(EXIT_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("1 과 2 만 입력할 수 있습니다.");
        }
    }
}
