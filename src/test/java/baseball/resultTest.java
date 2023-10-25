package baseball;

import static baseball.ballsTest.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class resultTest {

	@Test
	void checkAllBallResult() {
		// given
		balls userBalls = makeBalls(2, 3, 1);
		balls comBalls = makeBalls(1, 2, 3);
		assertEquals(new result(0, 3), result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkAllStrikeResult() {
		// given
		balls userBalls = makeBalls(1, 2, 3);
		balls comBalls = makeBalls(1, 2, 3);
		assertEquals(new result(3, 0), result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkOneStrikeTwoBallResult() {
		// given
		balls userBalls = makeBalls(1, 2, 3);
		balls comBalls = makeBalls(1, 3, 2);
		assertEquals(new result(1, 2), result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkOneStrikeOneBallResult() {
		// given
		balls userBalls = makeBalls(1, 2, 3);
		balls comBalls = makeBalls(1, 3, 4);
		assertEquals(new result(1, 1), result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkNothingResult() {
		// given
		balls userBalls = makeBalls(1, 2, 3);
		balls comBalls = makeBalls(4, 5, 6);
		assertEquals(new result(0, 0), result.checkBalls(comBalls, userBalls));
	}

	@Test
	void checkStrikeMessage() {
		int strike = 2;
		int ball = 0;
		assertEquals(new result(strike, ball).getresultMessage(), "2스트라이크");
	}

	@Test
	void checkBallMessage() {
		int strike = 0;
		int ball = 2;
		assertEquals(new result(strike, ball).getresultMessage(), "2볼");
	}

	@Test
	void checkBallStrikeMessage() {
		int strike = 1;
		int ball = 2;
		assertEquals(new result(strike, ball).getresultMessage(), "2볼 1스트라이크");
	}

	@Test
	void checkNothingMessage() {
		int strike = 0;
		int ball = 0;
		assertEquals(new result(strike, ball).getresultMessage(), "낫싱");
	}

}
