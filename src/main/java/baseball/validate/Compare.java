package baseball.validate;

import baseball.model.Computer;
import baseball.model.Player;

public class Compare {
    // 컴퓨터가 생성한 세 자리의 숫자를 저장하는 Computer 객체
    private Computer computer;
    // 사용자가 입력한 세 자리의 숫자를 저장하는 Player 객체
    private Player player;

    // Compare 객체가 생성될 때, Computer와 Player 객체를 받아옵니다.
    public Compare(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    // 컴퓨터와 사용자의 수를 비교하여 볼과 스트라이크의 개수를 계산합니다.
    public int[] compareNumbers() {
        String computerNumbers = computer.getComputerNumber();
        String playerNumbers = player.getPlayerNumber();

        int strikeCount = 0;  // 스트라이크 개수
        int ballCount = 0;  // 볼 개수

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
