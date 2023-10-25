package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Round {
    private String randomNumber;

    public Round() {
        generateRandomNumber();
    }

    public void generateRandomNumber() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (sb.indexOf(String.valueOf(randomNumber)) == -1) {
                sb.append(randomNumber);
            }
        }
        randomNumber = sb.toString();
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}
