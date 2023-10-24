package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private final Computer computer;
    private final HintScore hintScore;

    private static final String SEPARATOR = "";

    private static final Integer ANSWER_DIGIT = 3;
    private static final Integer NOTHING_MATCH_INDEX = -1;

    private static final String PRINT_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String PRINT_USER_INPUT = "숫자를 입력해주세요 :";

    private static final String ERROR_INPUT_NOT_DISTINCT = "입력 숫자는 모두 서로 다른 수여야 합니다.";
    private static final String ERROR_INPUT_INVALID_DIGIT = "입력 숫자는 세자리여야 합니다.";
    private static final String ERROR_INPUT_NOT_NUMBER = "입력 형식은 숫자여야합니다.";

    public BaseballGame(Computer computer, HintScore hintScore) {
        this.computer = computer;
        this.hintScore = hintScore;
    }

    public void run() {
        do {
            System.out.println(PRINT_GAME_START);
            List<Integer> correctAnswer = computer.createCorrectAnswer();
            play(correctAnswer);
        } while (restart());
    }

    private boolean restart() {

    }


    private void play(List<Integer> correctAnswer) {
        System.out.print(PRINT_USER_INPUT);
        List<Integer> userAnswer = Arrays.stream(Console.readLine().split(SEPARATOR))
                .map(input -> convertStringToInteger(input))
                .toList();
        validAnswerDigit(userAnswer);
        validAnswerDistinct(userAnswer);

        for (int i = 0; i < userAnswer.size(); i++) {
            int matchIndex = correctAnswer.indexOf(userAnswer.get(i));
            if (matchIndex == i) {
                hintScore.raiseStrike();
            }
            if (matchIndex != NOTHING_MATCH_INDEX) {
                hintScore.raiseBall();
            }
        }
        System.out.println(hintScore.toString());
    }

    private void validAnswerDistinct(List<Integer> userAnswer) {
        if (userAnswer.stream().distinct().toList().size() != ANSWER_DIGIT) {
            throw new IllegalArgumentException(ERROR_INPUT_NOT_DISTINCT);
        }
    }

    private void validAnswerDigit(List<Integer> userAnswer) {
        if (userAnswer.size() != ANSWER_DIGIT) {
            throw new IllegalArgumentException(ERROR_INPUT_INVALID_DIGIT);
        }
    }

    private Integer convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_NOT_NUMBER);
        }
    }
}
