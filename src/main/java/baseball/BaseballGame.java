package baseball;

import java.util.List;

public class BaseballGame {
    private Player player;
    private Computer computer;

    BaseballGame() {
        player = new Player();
        computer = new Computer();
    }

    public void play() {
        computer.pickRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> playerNumbers = player.readNumber();
            GameResult currentResult = computer.getResult(playerNumbers);
            System.out.println(currentResult.toString());

            if (currentResult.isGameOver()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (player.askRestart() == 2) {
                    break;
                }
                computer.pickRandomNumber();
            }
        }
    }
}
