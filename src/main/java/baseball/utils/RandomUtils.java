package baseball.utils;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public int[] getRandomNumbers(int size, int startInclusive, int endInclusive) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = getUniqueRandomNumber(randomNumbers, startInclusive, endInclusive, i);
        }
        return randomNumbers;
    }

    private int getUniqueRandomNumber(int[] randomNumbers, int startInclusive, int endInclusive, int index) {
        int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
        while (!isUniqueNumber(index, randomNumbers, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
        }
        return randomNumber;
    }

    private boolean isUniqueNumber(int index, int[] randomNumbers, int randomNumber) {
        if (randomNumbers[index] == randomNumber) {
            return false;
        }
        return true;
    }
}
