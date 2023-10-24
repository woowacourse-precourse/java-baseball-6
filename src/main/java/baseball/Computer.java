package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private static final int NUMBER_SIZE = 3;
    private Map<String, Integer> result;

    public Computer() {
        this.result = new LinkedHashMap<>();
    }

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public Map<String, Integer> compareNumbers(List<Integer> targetNumbers, List<Integer> userGuess) {
        result.put(KeyType.BALL.getKey(), 0);
        result.put(KeyType.STRIKE.getKey(), 0);
        if (targetNumbers.equals(userGuess)) {
            result.put(KeyType.STRIKE.getKey(), 3);
            return result;
        }
        checkStrikeAndBall(targetNumbers, userGuess);
        return result;
    }

    private void checkStrikeAndBall(List<Integer> targetNumbers, List<Integer> userGuess) {
        for (int targetDigit : targetNumbers) {
            int i = targetNumbers.indexOf(targetDigit);
            if (targetDigit == userGuess.get(i)) {
                result.put(KeyType.STRIKE.getKey(), result.get(KeyType.STRIKE.getKey()) + 1);
            } else if (isContains(targetNumbers, userGuess.get(i))) {
                result.put(KeyType.BALL.getKey(), result.get(KeyType.BALL.getKey()) + 1);
            }
        }
    }

    private boolean isContains(List<Integer> targetNumbers, int userGuess) {
        for (int targetDigit : targetNumbers) {
            if (targetDigit == userGuess) {
                return true;
            }
        }
        return false;
    }
}
