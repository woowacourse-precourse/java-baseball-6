package baseball;

import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private final Player player;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public boolean play() {
        List<Integer> playerNumbers = player.inputNumbers();
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNumbers.get(i) == computer.getNumbers().get(i)) {
                strikes++;
            } else if (computer.getNumbers().contains(playerNumbers.get(i))) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            if (balls > 0) {
                System.out.print(balls + "볼 ");
            }
            if (strikes > 0) {
                System.out.print(strikes + "스트라이크");
            }
            System.out.println();
        }

        return false;
    }
}
