package baseball.service;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGameService {
    private static final int ZERO_VALUE = 0;
    private static final String NOTHING_RESULT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private final Computer computer = new Computer();
    private int ballCount;
    private int strikeCount;

    public void initGame() {
        setCountInit();
        setComputerInit();
    }

    private void setCountInit() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    private void setComputerInit() {
        setRandomNumbers();
        computer.setGameStatusStart();
    }

    private void setRandomNumbers() {
        computer.setRandomNumbers(RandomUtil.createRandomNumber());
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public GameStatus getGameStatus() {
        return computer.getGameStatus();
    }

    public String resolveBallOrStrikeCount(String inputNumber) {
        setCountInit();
        List<Integer> inputNumbers = parseStringToIntArray(inputNumber);
        judgeStrikeOrBall(computer.getNumbers(), inputNumbers);
        return getCountMessage();
    }

    private static List<Integer> parseStringToIntArray(String inputNumber) {
        return Stream.of(String.valueOf(inputNumber).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private String getCountMessage() {
        if (strikeCount == ZERO_VALUE && ballCount == ZERO_VALUE) {
            return NOTHING_RESULT_MESSAGE;
        } else if (strikeCount != ZERO_VALUE && ballCount == ZERO_VALUE) {
            return strikeCount + STRIKE_MESSAGE;
        } else if (strikeCount != ZERO_VALUE && ballCount != ZERO_VALUE) {
            return ballCount + BALL_MESSAGE + strikeCount + STRIKE_MESSAGE;
        } else {
            return ballCount + BALL_MESSAGE;
        }
    }

    private void judgeStrikeOrBall(List<Integer> computerNumbers, List<Integer> inputNumbers) {
        for (int index = 0; index < computerNumbers.size(); index++) {
            if (computerNumbers.get(index).equals(inputNumbers.get(index))) {
                this.strikeCount++;
                continue;
            }
            if (computerNumbers.contains(inputNumbers.get(index))) {
                this.ballCount++;
            }
        }
    }

    public void changeGameStatusByCommand(String inputRetryOrEndCommand) {
        if (inputRetryOrEndCommand.equals(GameStatus.STOP.getCommand())) computer.setGameStatusStop();
        else if (inputRetryOrEndCommand.equals(GameStatus.START.getCommand())) computer.setGameStatusStart();
    }
}