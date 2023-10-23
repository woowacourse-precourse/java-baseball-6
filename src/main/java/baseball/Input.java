package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private final InputValidator inputValidator;

    public Input() {
        this.inputValidator = new InputValidator();
    }

    public List<Integer> readGuessNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return covertStringToIntList(Console.readLine());
    }

    public int readRetryChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return covertStringToInt(Console.readLine());
    }

    private List<Integer> covertStringToIntList(String input) {
        input = removeWhiteSpace(input);

        inputValidator.validateGuessNumbers(input);

        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private int covertStringToInt(String input) {
        input = removeWhiteSpace(input);
        inputValidator.validateRetryNumber(input);

        return Integer.parseInt(input);
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll("\\s", "");
    }

}
