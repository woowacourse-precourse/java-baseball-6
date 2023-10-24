package baseball.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final Integer BASEBALL_GAME_BALL_COUNT = 3;
    private final Integer BASEBALL_GAME_NUMBER_RANGE_START = 1;
    private final Integer BASEBALL_GAME_NUMBER_RANGE_END = 9;
    private final Integer EMPTY_NUMBER = -1;
    private final Integer NOT_FOUND = -1;

    private int[] randomNumbers;
    private Hint hint;

    public void createRandomNumbers() {
        initiateEmptyRandomNumbers();
        do {
            int number = Randoms.pickNumberInRange(BASEBALL_GAME_NUMBER_RANGE_START,
                    BASEBALL_GAME_NUMBER_RANGE_END);
            insertNumberToRandomNumbers(number, nextEmptyIndexInRandomNumbers());
        } while (isEmptySpaceInRandomNumbers());
    }

    private void initiateEmptyRandomNumbers() {
        randomNumbers = new int[BASEBALL_GAME_BALL_COUNT];
        for (int i = 0; i < BASEBALL_GAME_BALL_COUNT; i++) {
            randomNumbers[i] = EMPTY_NUMBER;
        }
    }

    private Integer nextEmptyIndexInRandomNumbers() {
        return IntStream.range(0, BASEBALL_GAME_BALL_COUNT).
                filter(i -> randomNumbers[i] == EMPTY_NUMBER).
                findFirst().orElse(NOT_FOUND);
    }

    private Boolean isEmptySpaceInRandomNumbers() {
        return Arrays.stream(randomNumbers).anyMatch(randomNumber -> randomNumber == EMPTY_NUMBER);
    }

    private void insertNumberToRandomNumbers(int number, int index) {
        if (isNewNumber(number)) {
            randomNumbers[index] = number;
        }
    }

    private Boolean isNewNumber(int number) {
        return !Arrays.stream(randomNumbers).anyMatch(randomNumber -> randomNumber == number);
    }

    public String hintAboutStrikeAndBall(int[] answer) {
        hint = new Hint(answer, this.randomNumbers);
        return hint.hintMessage();
    }

    public boolean isSuccess() {
        return hint.isCorrect();
    }
}