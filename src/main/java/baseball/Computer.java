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
            int playerNumber = player.playerNumbers.get(i);
            if (computerNumbers.get(i).equals(playerNumber)) {
                strikeCount++;
            } else if (computerNumbers.contains(playerNumber)) {
                ballCount++;
            }
        }

        String ball = ballCount + BALL;
        String strike = strikeCount + STRIKE;

        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        } else if (strikeCount == 0) {
            return ball;
        } else if (ballCount == 0) {
            return strike;
        } else {
            return ball + " " + strike;
        }
    }
}
