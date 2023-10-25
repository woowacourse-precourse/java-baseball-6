package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String numbers;

    public Computer() {
        this.numbers = getRandomNumber();
    }

    private String getRandomNumber() {
        StringBuilder str = new StringBuilder();

        while (str.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            StringBuilder n = new StringBuilder();
            n.append(randomNumber);
            if (!str.toString().contains(n)) {
                str.append(n);
            }
        }
        return str.toString();
    }

    public void resetNumber() {
        this.numbers = getRandomNumber();
    }

    public int[] getResult(String userInput) {
        int[] score = new int[2];

        for (int i = 0; i < 3; ++i) {
            char n = userInput.charAt(i);
            if (this.numbers.charAt(i) == n) {
                ++score[0];
            } else if (this.numbers.contains(String.valueOf(n))) {
                ++score[1];
            }
        }
        return score;
    }
}
