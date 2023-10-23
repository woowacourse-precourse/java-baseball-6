package model;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumbers {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final int MAX_NUMBER_LENGTH = 3;

    public static String createNumbers() {
        String randomNumbers = "";
        while (randomNumbers.length() < 3) {
            String randomNumber = getRandomNumbers();
            if (checkDuplicate(randomNumbers, randomNumber)) {
                continue;
            } else {
                randomNumbers += randomNumber;
            }
        }
        return randomNumbers;
    }

    public static String getRandomNumbers() {
        String randomNumber = String.valueOf(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        return randomNumber;
    }

    private static boolean checkDuplicate(String randomNumbers, String randomNumber) {
        return randomNumbers.contains(String.valueOf(randomNumber));
    }

}
