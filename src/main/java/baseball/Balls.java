package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	List<Integer> balls = new ArrayList<>();

	public boolean add(Integer ball) {
		// 중복 검사
		if (balls.contains(ball)) {
			throw new IllegalArgumentException();
		}

		// 볼 추가
		balls.add(ball);
		return true;
	}

	public void reverse() {
		List<Integer> reverse = new ArrayList<>();
		for (int i = balls.size() - 1; i >= 0; i--) {
			reverse.add(balls.get(i));
		}
		balls = reverse;
	}
}
