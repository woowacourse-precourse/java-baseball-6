package baseball.service;

import baseball.domain.GameStatus;
import baseball.domain.RandomNumber;

import java.util.List;
import java.util.stream.IntStream;

public class GameService {

    public GameStatus compareNumber(RandomNumber randomNumber, List<Integer> inputNumber, GameStatus gameStatus) {
        int strikeCount = (int) IntStream.range(0, 3)
                .filter(index -> randomNumber.isStrike(inputNumber.get(index), index))
                .count();
        gameStatus.updateStrikeCnt(strikeCount);

        int ballCount = (int) IntStream.range(0, 3)
                .filter(index -> randomNumber.isBall(inputNumber.get(index), index))
                .count();
        gameStatus.updateBallCnt(ballCount);
        return gameStatus;
    }


}
