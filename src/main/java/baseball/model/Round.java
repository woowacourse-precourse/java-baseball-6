package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Round {
    private final String randomNumber;

    public Round() {
        this.randomNumber = generateRandomNumber();
    }

    public String generateRandomNumber() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
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
