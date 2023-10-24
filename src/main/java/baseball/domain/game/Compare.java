package baseball.domain.game;

import baseball.domain.Player.Player;
import baseball.domain.computer.Computer;

public class Compare {

    int strikeCount;
    int ballCount;

    Compare(Computer computer, Player player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getIndexNumbers(i) == player.getIndexNumbers(j) && i == j) {
                    strikeCount++;
                } else if (computer.getIndexNumbers(i) == player.getIndexNumbers(j)) {
                    ballCount++;
                }
            }
        }
    }
}
