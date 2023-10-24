package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
    private final Integer BASEBALL_GAME_BALL_COUNT = 3;
    private final Integer BASEBALL_GAME_NUMBER_RANGE_START = 1;
    private final Integer BASEBALL_GAME_NUMBER_RANGE_END = 9;
    private final String WRONG_LENGTH_INPUT = "입력할 숫자는 3자리만 가능합니다.";
    private final String WRONG_RANGE_INPUT = "입력할 숫자는 1~9 사이만 가능합니다.";
    private final String DUPLICATE_INPUT = "입력할 숫자는 서로 달라야 합니다.";
    private final String PLAY_MORE_GAME = "1";
    private final String DO_NOT_PLAY_MORE_GAME = "2";
    private final String WRONG_INPUT_SELECT_PLAY_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력해야만 합니다.";

    private int[] answerNumbers;
    private Boolean playMoreGame;

    public int[] receiveAnswerNumbers(List<Integer> answerNumbers) {
        validateAnswerNumbers(answerNumbers);
        this.answerNumbers = Arrays.stream(answerNumbers.toArray(new Integer[answerNumbers.size()]))
                .mapToInt(number -> number)
                .toArray();
        return this.answerNumbers;
    }

    public void validateAnswerNumbers(List<Integer> answerNumbers) {
        validateLength(answerNumbers);
        validateRange(answerNumbers);
        validateDuplication(answerNumbers);
    }

    private void validateLength(List<Integer> answerNumbers) {
        if (answerNumbers.size() != BASEBALL_GAME_BALL_COUNT) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT);
        }
    }

    private void validateRange(List<Integer> answerNumbers) {
        Boolean validateRangeResult = answerNumbers.stream()
                .allMatch(number -> BASEBALL_GAME_NUMBER_RANGE_START <= number
                        && number <= BASEBALL_GAME_NUMBER_RANGE_END);
        if (!validateRangeResult) {
            throw new IllegalArgumentException(WRONG_RANGE_INPUT);
        }
    }

    private void validateDuplication(List<Integer> answerNumbers) {
        Boolean validateDuplicationResult = answerNumbers.stream()
                .distinct()
                .count() != answerNumbers.size();
        if (validateDuplicationResult) {
            throw new IllegalArgumentException(DUPLICATE_INPUT);
        }
    }

    public void receivePlayMoreGame(String responsePlayMoreGame) {
        Boolean playMoreGame = validatePlayMoreGame(responsePlayMoreGame);
        this.playMoreGame = playMoreGame;
    }

    private Boolean validatePlayMoreGame(String responsePlayMoreGame) {
        if (responsePlayMoreGame.equals(PLAY_MORE_GAME)) {
            return Boolean.TRUE;
        }
        if (responsePlayMoreGame.equals(DO_NOT_PLAY_MORE_GAME)) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException(WRONG_INPUT_SELECT_PLAY_MORE_GAME);
    }

    public Boolean isRestartGame() {
        return playMoreGame;
    }

}