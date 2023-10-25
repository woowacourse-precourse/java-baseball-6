package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

    private BallBucket ballBucket;

    public Computer() {

    }

    public void makeProblem() {
        this.ballBucket = this.makeRandomBucket();
    }

    private BallBucket makeRandomBucket() {
        ArrayList<Ball> randomBalls = new ArrayList<>();
        while (randomBalls.size() < BallBucket.BUCKET_SIZE) {
            Ball newBall = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!randomBalls.contains(newBall)) {
                randomBalls.add(newBall);
            }
        }
        return new BallBucket(randomBalls);
    }

    public int compareStrike(Player player) {
        return this.ballBucket.compareStrike(player.getBallBucket());
    }

    public int compareBall(Player player) {
        return this.ballBucket.compareBalls(player.getBallBucket());
    }

}
