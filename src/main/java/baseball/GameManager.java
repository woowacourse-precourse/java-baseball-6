package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager gameManager;

    public static GameManager getInstance() {
        if (gameManager == null) gameManager = new GameManager();
        return gameManager;
    }

    public void startGame() {
        List<Integer> correctNumber = generateRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();

            break;
        }
    }

    private List<Integer> answerStringToNumber(String answer) {
        validateAnswerLength(answer);

        return new ArrayList<>();
    }

    private void validateAnswerLength(String answer) {
        if (answer.length() > 3)
            throw new IllegalArgumentException();
    }

    private List<Integer> generateRandomNumber() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }
}
