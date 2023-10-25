package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private final List<Integer> computerNumbers = new ArrayList<>();

    public Computer() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public String compare(Player player) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(player.playerNumbers.get(i))) {
                strikeCount++;
            } else if (computerNumbers.contains(player.playerNumbers.get(i))) {
                ballCount++;
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        } else if (strikeCount == 0) {
            return ballCount + BALL;
        } else if (ballCount == 0) {
            return strikeCount + STRIKE;
        } else {
            return ballCount + BALL + " " + strikeCount + STRIKE;
        }
    }
}
