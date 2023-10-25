package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class BallBucket {

	private List<Ball> balls;

	public BallBucket() {
		balls = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			balls.add(new Ball(i));
		}
	}

	public Ball getBall() {
		return balls.remove(Randoms.pickNumberInRange(1, balls.size()-1));
	}
}
