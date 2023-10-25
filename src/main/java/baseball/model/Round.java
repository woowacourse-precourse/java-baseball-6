package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Round {
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    private static final int RANDOM_NUMBER_LENGTH = 3;
    private final String randomNumber;

    public Round() {
        this.randomNumber = generateRandomNumber();
    }

    public String generateRandomNumber() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < RANDOM_NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
            if (sb.indexOf(String.valueOf(randomDigit)) == -1) {
                sb.append(randomDigit);
            }
        }
        return sb.toString();
    }

    public String getRandomNumber() {
        return this.randomNumber;
    }
}
