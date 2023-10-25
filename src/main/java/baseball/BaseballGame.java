package baseball;

import static baseball.constant.ErrorMessage.INPUT_INVALID_DIGIT;
import static baseball.constant.ErrorMessage.INPUT_INVALID_RANGE;
import static baseball.constant.ErrorMessage.INPUT_NOT_DISTINCT;
import static baseball.constant.ErrorMessage.INPUT_NOT_NUMBER;
import static baseball.constant.PrintMessage.GAME_OVER;
import static baseball.constant.PrintMessage.GAME_START;
import static baseball.constant.PrintMessage.IS_RESTART;
import static baseball.constant.PrintMessage.USER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private static final String SEPARATOR = "";
    public static final Integer ANSWER_DIGIT = 3;
    public static final Integer NUMBER_MIN_RANGE = 1;
    public static final Integer NUMBER_MAX_RANGE = 9;

    private final Computer computer;
    private final HintScore hintScore;

    public BaseballGame(Computer computer, HintScore hintScore) {
        this.computer = computer;
        this.hintScore = hintScore;
    }

    public void run() {
        do {
            System.out.println(GAME_START);
            List<Integer> correctAnswer = computer.createCorrectAnswer();
            play(correctAnswer);
        } while (isRestart());
    }

    private boolean isRestart() {
        System.out.println(IS_RESTART);
        Integer userInput = convertStringToInteger(Console.readLine());
        return RestartOrExit.isRestart(userInput);
    }

    private void play(List<Integer> correctAnswer) {
        while (true) {
            hintScore.clear();
            List<Integer> userAnswer = getUserAnswer();
            validAnswer(userAnswer);
            hintScore.calculateHint(correctAnswer, userAnswer);
            System.out.println(hintScore);
            if (hintScore.isGameOver()) {
                System.out.println(GAME_OVER);
                break;
            }
        }
    }

    private List<Integer> getUserAnswer() {
        System.out.print(USER_INPUT);
        String[] userInput = Console.readLine().split(SEPARATOR);
        return Arrays.stream(userInput)
                .map(input -> convertStringToInteger(input))
                .toList();
    }

    private void validAnswer(List<Integer> userAnswer) {
        validDigit(userAnswer);
        validDistinct(userAnswer);
        userAnswer.stream().forEach(number -> validNumberRange(number));
    }

    private void validDistinct(List<Integer> userAnswer) {
        if (userAnswer.stream().distinct().toList().size() != ANSWER_DIGIT) {
            throw new IllegalArgumentException(INPUT_NOT_DISTINCT);
        }
    }

    private void validDigit(List<Integer> userAnswer) {
        if (userAnswer.size() != ANSWER_DIGIT) {
            throw new IllegalArgumentException(INPUT_INVALID_DIGIT);
        }
    }

    private void validNumberRange(Integer number) {
        if (number < NUMBER_MIN_RANGE || number > NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(INPUT_INVALID_RANGE);
        }
    }
    private Integer convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER);
        }
    }
}
