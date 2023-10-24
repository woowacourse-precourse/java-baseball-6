package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.constants.BaseballGameConstants.*;

public class BaseballGame {

    private List<Integer> correctNumbers = new ArrayList<>();
    private GameResult gameResult = new GameResult();

    public BaseballGame() {
    }

    public BaseballGame(List<Integer> numbers) {
        this.correctNumbers = numbers;
    }

    public void init() {
        while (correctNumbers.size() < GAME_NUMBER_SIZE) {
            addUniqueRandomNumberToCorrectList();
        }
    }

    private void addUniqueRandomNumberToCorrectList() {
        int randomNumber = generateRandomNumber();
        if (!correctNumbers.contains(randomNumber)) {
            correctNumbers.add(randomNumber);
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE_NUMBER, END_RANGE_NUMBER);
    }

    public GameResult compare(String inputNumber) {
        calculateStrikeAndBall(convertDigitsToIntArray(inputNumber));
        return gameResult;
    }

    private int[] convertDigitsToIntArray(String inputNumber) {
        return Arrays.stream(inputNumber.split("")).mapToInt(Integer::valueOf).toArray();
    }

    private void calculateStrikeAndBall(int[] inputNumbers) {
        for (int i = ZERO; i < GAME_NUMBER_SIZE; i++) {
            if (isStrike(inputNumbers, i)) {
                gameResult.plusStrike();
                continue;
            }
            if (isBall(inputNumbers[i])) {
                gameResult.plusBall();
            }
        }
    }

    private boolean isBall(int number) {
        return correctNumbers.contains(number);
    }

    private boolean isStrike(int[] inputNumbers, int i) {
        return correctNumbers.get(i) == inputNumbers[i];
    }

    public void resetNumbers() {
        correctNumbers.clear();
        gameResult.reset();
    }
}
