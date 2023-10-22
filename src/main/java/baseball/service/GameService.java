package baseball.service;

import baseball.domain.GameNumberSet;
import baseball.domain.GameStatus;

import java.util.stream.IntStream;

public class GameService {

    public GameStatus compareNumber(GameNumberSet gameNumberSet, GameStatus gameStatus) {
        int strikeCount = getStrikeCount(gameNumberSet);
        gameStatus.updateStrikeCnt(strikeCount);

        int ballCount = getBallCnt(gameNumberSet);
        gameStatus.updateBallCnt(ballCount);

        return gameStatus;
    }

    private int getStrikeCount(GameNumberSet gameNumberSet) {
        return (int) IntStream.range(0, GameNumberSet.NUMBER_LENGTH)
                .filter(gameNumberSet::isStrike)
                .count();
    }

    private int getBallCnt(GameNumberSet gameNumberSet) {
        return (int) IntStream.range(0, GameNumberSet.NUMBER_LENGTH)
                .filter(gameNumberSet::isBall)
                .count();
    }
}
