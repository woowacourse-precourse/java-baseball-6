package baseball.domain;

abstract public class BaseBallGameRule {

    protected static final String GAME_NAME = "숫자 야구";
    protected static final int maxNumberOfBallsAmount = 3;
    protected static final int minValueOfBall = 1;
    protected static final int maxValueOfBall = 9;
    protected static final int restartGameValue = 1;
    protected static final int endGameValue = 2;
    protected static final int strikeHit = 1;
    protected static final int ballHit = 2;
    protected final int nothingHit = 0;
    protected BaseBallGameRule() {

    }
}
