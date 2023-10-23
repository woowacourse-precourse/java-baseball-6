package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private final char[] randNumber;

    private Game() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(pickNumberInRange(1, 9));
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
