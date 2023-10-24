package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String secretNumber;

    public Computer() {
        generateSecretNumber();
    }

    public void generateSecretNumber() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (sb.indexOf(String.valueOf(randomNumber)) == -1) {
                sb.append(randomNumber);
            }
        }
        secretNumber = sb.toString();
    }

    public String getSecretNumber() {
        return secretNumber;
    }
}
