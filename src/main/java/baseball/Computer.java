package baseball;

public class Computer {

	private Ball[] balls;

	public Computer() {
		balls = generateBalls();
	}

	private Ball[] generateBalls() {
		Ball[] balls = new Ball[3];
		BallBucket ballBucket = new BallBucket();
		for (int i = 0; i < 3; i++) {
			balls[i] = ballBucket.getBall();
		}
		return balls;
	}
}
