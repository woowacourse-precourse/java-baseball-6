package baseball;

import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private Ball[] balls;

	public Computer() {
	}

	public void generateBalls() {
		Ball[] balls = new Ball[3];
		BallBucket ballBucket = new BallBucket();
		for (int i = 0; i < 3; i++) {
			balls[i] = ballBucket.getBall();
		}
		this.balls = balls;
	}

	public Ball[] getBalls() {
		return balls;
	}

}
