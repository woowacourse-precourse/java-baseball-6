package baseball;

import baseball.game.GameLogic;
import baseball.utils.Result;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final GameLogic gameLogic = new GameLogic();

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();
    }

    public void startGame() {
        boolean isGameContinue = true;

        while (isGameContinue) {
            gameLogic.startGame();
            boolean isMatch = false;
            List<Integer> playerNumbers;

            while (!isMatch) {
                try {
                    playerNumbers = gameLogic.getPlayerNumbers();
                    isMatch = gameLogic.checkMatch(playerNumbers);
                    List<Integer> resultCounts = gameLogic.computeResult(playerNumbers);
                    Result.printResult(resultCounts.get(1), resultCounts.get(0));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isGameContinue = isRestartGame();
        }
    }

    private boolean isRestartGame() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = gameLogic.getUserInput();
            if (!"1".equals(input) && !"2".equals(input)) {
                throw new IllegalArgumentException();
            }
            return "1".equals(input);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
