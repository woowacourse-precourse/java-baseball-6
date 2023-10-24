package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private final InputValidator inputValidator;
    private static final String GUESS_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_CHOICE_INPUT_MESSAGE =
            "게임을 새로 시작하려면 " + GameConstants.RETRY_CHOICE + ", 종료하려면 " + GameConstants.EXIT_CHOICE + "를 입력하세요.";
    private static final String WHITESPACE_PATTERN = "\\s";
    private static final String EMPTY_STRING = "";

    public Input() {
        this.inputValidator = new InputValidator();
    }

    public List<Integer> getGuessNumbers() {
        System.out.print(GUESS_NUMBER_INPUT_MESSAGE);
        String input = removeWhiteSpace(Console.readLine());
        inputValidator.validateGuessNumbers(input);
        return covertStringToIntList(input);
    }

    public int getRetryChoice() {
        System.out.println(RETRY_CHOICE_INPUT_MESSAGE);
        String input = removeWhiteSpace(Console.readLine());
        inputValidator.validateRetryNumber(input);
        return covertStringToInt(Console.readLine());
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll(WHITESPACE_PATTERN, EMPTY_STRING);
    }

    private List<Integer> covertStringToIntList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private int covertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
