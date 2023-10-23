package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Computer {

    private static final int BASEBALL_NUMBERS_SIZE = 3;
    private static final int BASEBALL_MIN_NUMBER = 1;
    private static final int BASEBALL_MAX_NUMBER = 9;

    private final String number;

    public Computer() {
        this.number = createBaseballNumber();
    }

    public int countStrikes(String player) {
        int count = 0;

        for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
            char targetNumber = player.charAt(i);

            if (targetNumber == number.charAt(i)) {
                count += 1;
            }
        }

        return count;
    }

    public int countBalls(String player) {
        int count = 0;

        for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
            int findIndex = targetNumberIndex(player, i);

            if (findIndex != -1 && findIndex != i) {
                count += 1;
            }
        }

        return count;
    }

    private int targetNumberIndex(String number, int i) {
        char targetNumber = number.charAt(i);
        return number.indexOf(targetNumber);
    }

    private String createBaseballNumber() {
        LinkedHashSet<String> result = new LinkedHashSet<>();

        while (result.size() < BASEBALL_NUMBERS_SIZE) {
            result.add(selectRandomNumber());
        }

        return String.join("", result);
    }

    private String selectRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(BASEBALL_MIN_NUMBER, BASEBALL_MAX_NUMBER);
        return Integer.toString(randomNumber);
    }
}
