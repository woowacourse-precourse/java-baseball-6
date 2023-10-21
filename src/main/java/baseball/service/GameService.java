package baseball.service;

import baseball.domain.GameStatus;
import baseball.domain.InputNumber;
import baseball.domain.RandomNumber;

import java.util.stream.IntStream;

public class GameService {

    public GameStatus compareNumber(RandomNumber randomNumber, InputNumber inputNumber, GameStatus gameStatus) {
        int strikeCount = getStrikeCount(randomNumber, inputNumber);
        gameStatus.updateStrikeCnt(strikeCount);

        int ballCount = getBallCnt(randomNumber, inputNumber);
        gameStatus.updateBallCnt(ballCount);

        return gameStatus;
    }

    private static int getStrikeCount(RandomNumber randomNumber, InputNumber inputNumber) {
        return (int) IntStream.range(0, 3)
                .filter(index -> isStrike(randomNumber, inputNumber, index))
                .count();
    }

    private static int getBallCnt(RandomNumber randomNumber, InputNumber inputNumber) {
        return (int) IntStream.range(0, 3)
                .filter(index -> isBall(randomNumber, inputNumber, index))
                .count();
    }

    private static boolean isBall(RandomNumber randomNumber, InputNumber inputNumber, int index) {
        return randomNumber.numberExistsInList(inputNumber.getNumberAtIndex(index)) &&
                randomNumber.isNotSameNumberAtIndex(inputNumber.getNumberAtIndex(index), index);
    }

    private static boolean isStrike(RandomNumber randomNumber, InputNumber inputNumber, int index) {
        return randomNumber.isSameNumberAtIndex(inputNumber.getNumberAtIndex(index), index);
    }
}
