package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        BaseballNumber correctNumber = BaseballNumber.generateRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();
            BaseballNumber answerNumber = new BaseballNumber(answer);

            if (isMatched(answerNumber, correctNumber)) {
                break;
            }
        }
    }

    private boolean isMatched(BaseballNumber answerNumber, BaseballNumber correctNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(answerNumber.getNumbers().get(i), correctNumber.getNumbers().get(j))) {
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
}
