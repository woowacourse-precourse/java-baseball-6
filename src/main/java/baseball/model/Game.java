package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private final char[] randNumber;

    private Game() {
        int[] array = new int[10];
        StringBuilder sb = new StringBuilder();
        while (sb.length() != 3) {
            int pickNumber = pickNumberInRange(1, 9);
            if (array[pickNumber] == 0) {
                array[pickNumber] = 1;
                sb.append(pickNumber);
            }
        }
        this.randNumber = sb.toString().toCharArray();
    }

    public static Game createRandomNumber() {
        return new Game();
    }

    public char[] getRandNumber() {
        return randNumber;
    }
}
