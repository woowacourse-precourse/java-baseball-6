package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ballsTest {

	public static balls makeBalls(int... intArr) {
		List<ball> ballList = new ArrayList<>();

		for (int j : intArr) {
			ballList.add(new ball(j));
		}
		return new balls(ballList);
	}

	@Test
	public void checkBallsSize() {
		// given
		balls Balls = balls.makeRandomBall();

		// when && then
		assertEquals(Balls.getSize(), Balls.Ball_Count);

	}

}
