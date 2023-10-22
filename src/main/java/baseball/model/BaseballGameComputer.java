package baseball.model;

import baseball.model.rule.BaseBallGameRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class BaseballGameComputer extends BaseBallGameRule {
    private Set<Ball> balls;
    public void readyForGame() {
        this.balls = new LinkedHashSet<>();
        while (balls.size() < BASEBALL_MAX_AMOUNT) {
            int randomNumber = pickNumberFromThreadLocalRandomForBalls(BASEBALL_MIN_VALUE, BASEBALL_MAX_VALUE);
            balls.add(new Ball(randomNumber));
        }
    }

    public Integer pickNumberFromThreadLocalRandomForBalls(int minValue, int maxValue) {
        return Randoms.pickNumberInRange(minValue, maxValue);
    }

    public Hint getHintByPlayerBalls(Set<Ball> playerBalls) {
        List<Ball> computeBallsList = new ArrayList<>(balls);
        List<Ball> playerBallsList = new ArrayList<>(playerBalls);

        int strikeCount = (int) IntStream.range(0, computeBallsList.size())
                .filter(i -> playerBallsList.size() > i && computeBallsList.get(i).equals(playerBallsList.get(i)))
                .count();

        int ballCount = (int) IntStream.range(0, computeBallsList.size())
                .filter(i -> playerBallsList.contains(computeBallsList.get(i)) && !computeBallsList.get(i)
                        .equals(playerBallsList.get(i)))
                .count();

        return new Hint(strikeCount, ballCount);
    }

}
