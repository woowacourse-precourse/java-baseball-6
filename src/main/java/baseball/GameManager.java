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

            List<Integer> answerNumber = answerStringToNumber(answer);
            break;
        }
    }

    private List<Integer> answerStringToNumber(String answer) {
        validateAnswerLength(answer);
        List<Integer> answerNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char answerChar = answer.charAt(i);
            validateAnswerChar(answerChar);
            answerNumber.add((int) answer.charAt(i));
        }
        return answerNumber;
    }

    private void validateAnswerChar(char c) {
        if (c < 49 || c > 57)
            throw new IllegalArgumentException();
    }

    private void validateAnswerLength(String answer) {
        if (answer.length() > 3)
            throw new IllegalArgumentException();
    }

    private List<Integer> generateRandomNumber() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }
}
