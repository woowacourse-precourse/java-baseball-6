package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String numbers;

    public Computer() {
        numbers = getRandomNumber();
    }

    private String getRandomNumber() {
        StringBuilder str = new StringBuilder();

        while (str.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String n = "";
            n += (char) (randomNumber + '0');
            if (!str.toString().contains(n)) {
                str.append(n);
            }
        }
        return str.toString();
    }

    public void resetNumber() {
        numbers = getRandomNumber();
    }

    public int[] getResult(String userInput) {
        int[] score = new int[2];

        for (int i = 0; i < 3; ++i) {
            char n = userInput.charAt(i);
            if (numbers.charAt(i) == n) {
                ++score[0];
            } else if (numbers.contains(String.valueOf(n))) {
                ++score[1];
            }
        }
        return score;
    }
}
