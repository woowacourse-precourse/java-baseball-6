package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameRule;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    public static List<Integer> userNumbers;
    public static List<Integer> computerNumbers;

    public static void initGame() {
        Computer.setBall(GameRule.defaultValue);
        Computer.setStrike(GameRule.defaultValue);
        User.setRestart(GameRule.restartNumber);
        makeAnswer();
    }

    public static void makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GameRule.answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Computer.setAnswer(computer);
    }

    public static void makeHint() {
        int ball = countBall();
        int strike = countStrike();
        Computer.setBall(ball);
        Computer.setStrike(strike);
    }

    public static boolean correctAnswer() {
        int strike = Computer.getStrike();
        boolean flag = GameRule.defaultBool;
        if (strike == 3) {
            flag = GameRule.correctBool;
        }
        return flag;
    }

    public static int countBall() {
        int ball = 0;
        userNumbers = User.getUser();
        computerNumbers = Computer.getAnswer();
        for (Integer num : userNumbers) {
            int userIndex = checkIndex(num, userNumbers);
            int computerIndex = checkIndex(num, computerNumbers);
            if (computerIndex >= 0 && userIndex != computerIndex) {
                ball += 1;
            }
        }
        return ball;
    }

    public static int countStrike() {
        int strike = 0;
        userNumbers = User.getUser();
        computerNumbers = Computer.getAnswer();
        for (Integer num : userNumbers) {
            int userIndex = checkIndex(num, userNumbers);
            int computerIndex = checkIndex(num, computerNumbers);
            if (userIndex == computerIndex) {
                strike += 1;
            }
        }
        return strike;
    }

    public static int checkIndex(int num, List<Integer> numbers) {
        return numbers.indexOf(num);
    }
}
