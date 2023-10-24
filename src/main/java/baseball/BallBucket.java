package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class BallBucket {

	private List<Ball> balls;

	public BallBucket() {
		balls = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			balls.add(new Ball(i));
		}
	}

	public Ball getBall() {
		return balls.get(Randoms.pickNumberInRange(0, balls.size()-1));
	}
}
