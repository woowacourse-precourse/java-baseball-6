package baseball.game;

import baseball.utils.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    public static List<Integer> createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> checkAnswer(List<Integer> inputNumbers, List<Integer> answer) {
        Integer strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if(Objects.equals(inputNumbers.get(i), answer.get(i))) {
                strike += 1;
            } else if (answer.contains(inputNumbers.get(i))) {
                ball += 1;
            }
        }
        List<Integer> ballCount = new ArrayList<>();
        ballCount.add(strike);
        ballCount.add(ball);
        return ballCount;
    }
    public static void printAnswer(List<Integer> ballCount) {
        Integer strike = ballCount.get(0), ball = ballCount.get(1);
        if(strike == 0 && ball == 0) {
            System.out.println(Constant.BallCount.getBallCount(Constant.BallCount.NOTHING));
        } else if (strike == 0){
            System.out.println(ball + Constant.BallCount.getBallCount(Constant.BallCount.BALL));
        } else if (ball == 0) {
            System.out.println(strike + Constant.BallCount.getBallCount(Constant.BallCount.STRIKE));
        } else {
            System.out.println(ball + Constant.BallCount.getBallCount(Constant.BallCount.BALL) + " " + strike + Constant.BallCount.getBallCount(Constant.BallCount.STRIKE));
        }
    }
}