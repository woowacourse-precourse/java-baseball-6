package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameStatus;

import java.util.stream.IntStream;

public class GameService {

    public GameStatus compareNumber(GameNumber gameNumber, GameStatus gameStatus) {
        int strikeCount = getStrikeCount(gameNumber);
        gameStatus.updateStrikeCnt(strikeCount);

        int ballCount = getBallCnt(gameNumber);
        gameStatus.updateBallCnt(ballCount);

        return gameStatus;
    }

    private static int getStrikeCount(GameNumber gameNumber) {
        return (int) IntStream.range(0, 3)
                .filter(gameNumber::isStrike)
                .count();
    }

    private static int getBallCnt(GameNumber gameNumber) {
        return (int) IntStream.range(0, 3)
                .filter(gameNumber::isBall)
                .count();
    }
}
