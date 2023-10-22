package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        boolean gameState = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameState) {
            Game game = new Game();

            while (true) {
                List<Integer> userInputList = gameManager.getUserTrialInput();
                GameResult gameResult = game.getGameResult(userInputList);
                System.out.println(gameResult);

                if (gameResult.isAllStrike()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    if (gameManager.getUserRestartInput() == 2) {
                        gameState = false;
                    }
                    break;
                }
            }
        }
        camp.nextstep.edu.missionutils.Console.close();
    }
}
