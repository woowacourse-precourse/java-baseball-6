package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final String NOTHING = "낫싱";
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final List<Integer> computer = new ArrayList<>();

    public Computer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public String compare(Player player) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.playerNumber.get(i))) {
                strikeCount++;
            } else if (computer.contains(player.playerNumber.get(i))) {
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
