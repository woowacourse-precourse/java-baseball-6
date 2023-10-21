package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public static List<Integer> generateUniqueRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}