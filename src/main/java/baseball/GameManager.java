package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

            if (isMatched(answerNumber, correctNumber)) {
                break;
            }
        }
    }

    private boolean isMatched(List<Integer> answerNumber, List<Integer> correctNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(answerNumber.get(i), correctNumber.get(j))) {
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball > 0)
            System.out.print(ball + "볼");
        if (ball > 0 && strike > 0)
            System.out.print(" ");
        if (strike > 0)
            System.out.print(strike + "스트라이크");
        System.out.println();

        return strike == 3;
    }

    private List<Integer> answerStringToNumber(String answer) {
        validateAnswerLength(answer);

        List<Integer> answerNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char answerChar = answer.charAt(i);
            validateAnswerChar(answerChar);

            answerNumber.add((int) answer.charAt(i) - 48);
        }
        return answerNumber;
    }

    private void validateAnswerChar(char c) {
        if (c < 49 || c > 57)
            throw new IllegalArgumentException();
    }

    private void validateAnswerLength(String answer) {
        if (answer.length() != 3)
            throw new IllegalArgumentException();
    }

    private List<Integer> generateRandomNumber() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }
}
