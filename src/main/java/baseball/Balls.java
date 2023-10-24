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
}
