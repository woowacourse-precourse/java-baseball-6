package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        User user = new User();
        Computer computer = new Computer();
        BaseballGame baseballGame = new BaseballGame();
        computer.randomComputerPick();
        while (true) {
            user.userSelect();
            List<Integer> strikeZoneResult = baseballGame.strikeZone(user, computer);
            boolean baseballGameResult = baseballGame.printGameResult(strikeZoneResult);

            if (!baseballGameResult) {
                continue;
            }
            boolean userSelectGameOver = baseballGame.gameOver();
            if (userSelectGameOver) {
                computer.randomComputerPick();
                continue;
            }
            if (userSelectGameOver == false) {
                break;
            }
        }
    }
}