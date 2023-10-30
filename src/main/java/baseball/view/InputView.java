package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.validator.InputValidator;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String START_NEW_GAME_NUMBER = "1";
    public static final String END_GAME_NUMBER = "2";
    public static final String INPUT_START_NEW_GAME_OR_EXIT_MESSAGE =
            "게임을 새로 시작하려면 " + START_NEW_GAME_NUMBER + ", 종료하려면 " + END_GAME_NUMBER + "를 입력하세요.";

    public List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputLength(input);
        InputValidator.validateInputNumber(input);

        return Arrays.stream(input.split("")).map(Integer::parseInt).toList();
    }

    public String inputStartNewGame() {
        System.out.println(INPUT_START_NEW_GAME_OR_EXIT_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputNumber(input);

        return input;
    }
}
