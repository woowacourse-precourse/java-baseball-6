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
        computer.pickRandomNumber(3);
        while (true) {
            List<Integer> playerNumbers = player.readNumber();
            GameResult currentResult = computer.getResult(playerNumbers);
            printResult(currentResult);

            if (currentResult.getStrikeCount() == 3 && replay()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (player.askRestart() == 2) {
                    break;
                }
            }
        }
    }

    private void printResult(GameResult result) {
        String toString = "";
        if (result.getBallCount() > 0) {
            toString += result.getBallCount() + "볼";
        }
        if (result.getStrikeCount() > 0) {
            toString += result.getStrikeCount() + "스트라이크";
        }
        if (result.getBallCount() == 0 && result.getStrikeCount() == 0) {
            toString += "낫싱";
        }
        System.out.println(toString);
    }

    private boolean replay() {
        return true;
    }
}
