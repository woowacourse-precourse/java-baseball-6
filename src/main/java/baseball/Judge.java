package baseball;

import baseball.constant.GameConstant;
import baseball.constant.GameMessage;
import baseball.constant.Status;

import java.util.List;
import java.util.stream.IntStream;

public class Judge {

    private final List<Integer> computerNumber;
    private final List<Integer> playerNumber;

    public Judge(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public void calculate() {
        int ballCount = countBall();
        int strikeCount = countStrike();
        GameResult gameResult = new GameResult(ballCount, strikeCount);
        if (strikeCount == GameConstant.MAXIMUM_STRIKE_COUNT.getConstant()) {
            GameController.gameStatus = Status.SET_FINISH;
        }
        generateResultMessage(gameResult);
    }

    public void generateResultMessage(GameResult gameResult) {
        if (gameResult.isBallStrike()) {
            System.out.printf(GameMessage.BALL_STRIKE.getMessage(), gameResult.ballCnt(), gameResult.strikeCnt());
        } else if (gameResult.isOnlyStrike()) {
            System.out.printf(GameMessage.STRIKE.getMessage(), gameResult.strikeCnt());
        } else if (gameResult.isOnlyBall()) {
            System.out.printf(GameMessage.BALL.getMessage(), gameResult.ballCnt());
        } else if (gameResult.isNothing()) {
            System.out.println(GameMessage.NOTHING.getMessage());
        } else if (gameResult.isThreeStrike()) {
            System.out.printf(GameMessage.STRIKE.getMessage(), gameResult.ballCnt());
            System.out.printf(GameMessage.THREE_STRIKE.getMessage(), GameConstant.MAXIMUM_STRIKE_COUNT.getConstant());
        }
    }

    private int countBall() {
        return (int) IntStream.range(0, GameConstant.NUMBER_COUNT.getConstant())
                .filter(index -> {
                    int currentNumber = playerNumber.get(index);
                    return computerNumber.contains(currentNumber) && computerNumber.indexOf(currentNumber) != index;
                })
                .count();
    }

    private int countStrike() {
        return  (int) IntStream.range(0, GameConstant.NUMBER_COUNT.getConstant())
                .filter(index -> {
                    int currentNumber = playerNumber.get(index);
                    return computerNumber.contains(currentNumber) && computerNumber.indexOf(currentNumber) == index;
                })
                .count();
    }

}
