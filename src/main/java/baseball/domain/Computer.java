package baseball.domain;

import static baseball.constant.BaseballConstant.BASEBALL_MAX_NUMBER;
import static baseball.constant.BaseballConstant.BASEBALL_MIN_NUMBER;
import static baseball.constant.BaseballConstant.BASEBALL_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class Computer {

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
            int findIndex = findNumberIndex(player, i);

            if (findIndex != -1 && findIndex != i) {
                count += 1;
            }
        }

        return count;
    }

    private int findNumberIndex(String player, int i) {
        char targetNumber = player.charAt(i);
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
