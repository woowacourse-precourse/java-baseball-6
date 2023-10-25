package baseball.validate;

import baseball.model.Computer;
import baseball.model.Player;

public class Compare {

    private Computer computer;
    private Player player;

    public Compare(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    // 컴퓨터와 사용자의 수를 비교
    public int[] compareNumbers() {
        String computerNumbers = computer.getComputerNumber();
        String playerNumbers = player.getPlayerNumber();

        int strikeCount = 0;
        int ballCount = 0;

        for (int i=0; i<3; i++) {
            if (computerNumbers.charAt(i) == playerNumbers.charAt(i)) {
                strikeCount++;
            } else if (computerNumbers.contains(String.valueOf(playerNumbers.charAt(i)))) {
                ballCount++;
            }
        }

        return new int[]{ballCount, strikeCount};
    }
}
