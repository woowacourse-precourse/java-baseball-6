package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class balls {
	public static final int Ball_Count = 3;

	private final List<ball> balls;

	public balls(List<ball> balls) {
		validate(balls);
		this.balls = balls;
	}

	private void validate(List<ball> balls2) {
		Set<ball> ballHash = new HashSet<>(balls2);
		if (ballHash.size() != Ball_Count) {
			throw new IllegalArgumentException("공의 숫자가 중복 됩니다.");
		}
	}

	public static balls makeRandomBall() {
		List<ball> Ball = new ArrayList<>();
		while (Ball.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!Ball.contains(randomNumber)) {
				Ball.add(new ball(randomNumber));
			}
		}
		return new balls(Ball);
	}

	public ball get(int index) {
		return balls.get(index);
	}

	public boolean contains(ball ball) {
		return this.balls.contains(ball);
	}

	public static balls addinputball(String input) {
		List<ball> inputBall = new ArrayList<>();
		char[] chars = input.toCharArray();
		for (char ch : chars) {
			inputBall.add(new ball(ch));
		}
		return new balls(inputBall);
	}

	public int getSize() {
		return this.balls.size();
	}

}
