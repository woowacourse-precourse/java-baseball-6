package model;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumbers {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int MAX_NUMBER_LENGTH = 3;
    private static String randomNumbers;

    public static String createNumbers() {
        randomNumbers = "";
        while (randomNumbers.length() < 3) {
            String randomNumber = getRandomNumbers();
            randomNumbers += checkDuplicate(randomNumbers, randomNumber);

        }
        return randomNumbers;
    }

    public static String getRandomNumbers() {
        String randomNumber = String.valueOf(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        return randomNumber;
    }

    private static String checkDuplicate(String randomNumbers, String randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            return randomNumber;
        }
        return "";
    }

}
