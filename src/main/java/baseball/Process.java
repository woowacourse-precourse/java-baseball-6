package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Process {

    private List<Hint> hintLog;
    private Ball ball;
    private int size;

    public Process(int size) {
        this.size = size;
        this.hintLog = new ArrayList<>();
        createRandomBalls(size);
    }

    public void createRandomBalls(int size) {
        List<Integer> randomBalls = new ArrayList<>();
        while (randomBalls.size() < size) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(number)) {
                randomBalls.add(number);
            }
        }

        ball = new Ball(randomBalls);
    }

    public boolean isCorrectBall(String userBalls) {
        Hint currentHint = ball.makeHint(userBalls);
        hintLog.add(currentHint);

        if (!currentHint.isStrike(size)) {
            return false;
        }
        return true;
    }

    public Hint getCurrentHint() {
        return hintLog.get(hintLog.size() - 1);
    }

}
