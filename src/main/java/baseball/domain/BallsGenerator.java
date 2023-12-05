package baseball.domain;

public interface BallsGenerator {

    Ball generateBall(int position);

    Balls generateBalls();
}
