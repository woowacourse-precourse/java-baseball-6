package baseball;

import static baseball.ErrorMessage.INPUT_INVALID_DIGIT;
import static baseball.ErrorMessage.INPUT_INVALID_RANGE;
import static baseball.ErrorMessage.INPUT_NOT_DISTINCT;
import static baseball.ErrorMessage.INPUT_NOT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private final Computer computer;
    private final HintScore hintScore;

    private static final String SEPARATOR = "";

    public static final Integer ANSWER_DIGIT = 3;

    private static final int NUMBER_MIN_RANGE = 1;
    private static final int NUMBER_MAX_RANGE = 9;

    private static final String PRINT_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String PRINT_USER_INPUT = "숫자를 입력해주세요 :";
    private static final String PRINT_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PRINT_IS_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public BaseballGame(Computer computer, HintScore hintScore) {
        this.computer = computer;
        this.hintScore = hintScore;
    }

    public void run() {
        do {
            System.out.println(PRINT_GAME_START);
            List<Integer> correctAnswer = computer.createCorrectAnswer();
            play(correctAnswer);
        } while (isRestart());
    }

    private boolean isRestart() {
        System.out.println(PRINT_IS_RESTART);
        Integer userInput = convertStringToInteger(Console.readLine());
        return RestartOrExit.isRestart(userInput);
    }

    private void play(List<Integer> correctAnswer) {
        while (true) {
            hintScore.clear();
            System.out.print(PRINT_USER_INPUT);
            List<Integer> userAnswer = Arrays.stream(Console.readLine().split(SEPARATOR))
                    .map(input -> convertStringToInteger(input))
                    .toList();
            validAnswer(userAnswer);
            hintScore.calculateHint(correctAnswer, userAnswer);
            System.out.println(hintScore);
            if (hintScore.isGameOver()) {
                System.out.println(PRINT_GAME_OVER);
                break;
            }
        }
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
