package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	private Ball[] balls;

	public Computer() {
	}

	public void generateBalls() {
		Ball[] balls = new Ball[3];
		Set<Ball> ballBucket = new LinkedHashSet<>();

		while (ballBucket.size()<3) {
			ballBucket.add(new Ball(Randoms.pickNumberInRange(1, 9)));
		}

		Iterator<Ball> iterator = ballBucket.iterator();

		for (int i = 0; i < 3; i++) {
			if (iterator.hasNext()) {
				balls[i] = iterator.next();
			}
		}

		this.balls = balls;
	}

	public Ball[] getBalls() {
		return balls;
	}

}
