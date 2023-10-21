package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame = true;

        while (continueGame)
            continueGame = playGame();
    }

    public static boolean playGame() {
        List<Integer> computerNumbers = generateUniqueRandomNumbers();
        boolean gameFinished = false;

        while (!gameFinished) {
            List<Integer> userNumbers = inputAndValidateUserNumbers();
            gameFinished = evaluateAndDisplayGameResult(computerNumbers, userNumbers);
        }

        return askForNewGame();
    }
}