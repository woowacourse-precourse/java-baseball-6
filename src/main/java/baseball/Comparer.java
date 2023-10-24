package baseball;

import java.util.List;

public class Comparer {
    private final int NUMBER_LENGTH = 3;
    private final CompareResult compareResult;
    private final List<Integer> computerNumber;
    private final List<Integer> userNumber;


    public Comparer(Computer computer, User user) {
        computerNumber = computer.getComputerNumber();
        userNumber = user.getUserNumber();
        compareResult = generateCompareResult();
        compareResult.printCompareResult();
    }

    private CompareResult generateCompareResult() {
        int strikeCount = calculateStrikeCount();
        int ballCount = calculateBallCount();
        return new CompareResult(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return compareResult.getStrikeCount();
    }

    // Strike 개수 화인
    private int calculateStrikeCount() {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            strikeCount += isStrike(i);
        }
        return strikeCount;
    }

    // Ball 개수 확인
    private int calculateBallCount() {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            ballCount += isBall(i);
        }
        return ballCount;
    }

    private int isStrike(int index) {
        if (computerNumber.get(index) == userNumber.get(index)) {
            return 1;
        }
        return 0;
    }

    private int isBall(int index) {
        int findIdx = userNumber.indexOf(computerNumber.get(index));
        if (findIdx != -1 && index != findIdx) {
            return 1;
        }
        return 0;
    }
}