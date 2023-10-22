package baseball.domain;

import baseball.util.RandomBallGenerator;

import static baseball.domain.Ball.*;

public class Game {
    private final Balls computerBalls;
    private boolean gameFinished;
    private static final RandomBallGenerator randomBallGenerator = new RandomBallGenerator();

    public Game() {
        this.computerBalls = randomBallGenerator.generateComputerBalls();
        this.gameFinished = false;
    }

    public GameResult compareAndResult(Balls playerBalls) {
        int balls = countBalls(playerBalls);
        int strikes = countStrikes(playerBalls);
        return new GameResult(balls, strikes);
    }

    public void updateGameState(GameResult gameResult) {
        if (gameResult.isThreeStrike()) {
            gameFinished = !gameFinished;
        }
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    private int countBalls(Balls playerBalls) {
        int balls = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isBall(index, playerBalls)) {
                balls++;
            }
        }
        return balls;
    }

    private boolean isBall(int index, Balls playerBalls) {
        // index 위치의 컴퓨터 공과 플레이어 공의 번호를 비교하여 볼인지 확인
        boolean isNotStrike = !isStrike(index, playerBalls);
        boolean containsOtherBall = computerBalls.containsOtherBall(playerBalls.getBall(index));
        return isNotStrike && containsOtherBall;
    }

    private int countStrikes(Balls playerBalls) {
        int strikes = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isStrike(index, playerBalls)) {
                strikes++;
            }
        }
        return strikes;
    }

    private boolean isStrike(int index, Balls playerBalls) {
        // index 위치의 컴퓨터 공과 플레이어 공의 번호를 비교하여 스트라이크인지 확인
        Ball computerBall = computerBalls.getBall(index);
        Ball playerBall = playerBalls.getBall(index);
        return computerBall.number().equals(playerBall.number());
    }
}