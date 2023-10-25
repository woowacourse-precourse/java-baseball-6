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

    public List<Integer> InputUserNumber() {
        System.out.print(INPUT_NUMBER);
        String inputString = Console.readLine();
        System.out.println(inputString);
        ValidateInputNumber(inputString);

        return AddNumber(inputString);
    }

    public List<Integer> AddNumber(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int number = input.charAt(i) - '0';
            ValidateDuplicate(userNumbers, number);
            userNumbers.add(number);
        }
        return userNumbers;
    }

    public void ValidateDuplicate(List<Integer> userNumbers, int number) {
        if (userNumbers.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자를 입력헸습니다.");
        }
    }

    public void ValidateInputNumber(String inputs) {
        if (!inputs.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
        }
    }

    public String ProgramReStartOrExit() {
        String number = Console.readLine();
        ValidateReStartOrExit(number);
        return number;
    }

    public void ValidateReStartOrExit(String input) {
        if (!input.matches(EXIT_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("1 과 2 만 입력할 수 있습니다.");
        }
    }
}
