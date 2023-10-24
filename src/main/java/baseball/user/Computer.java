package baseball.user;

import static baseball.game.BaseballConstants.MAX_STRIKES;
import static baseball.game.BaseballConstants.TOTAL_BASEBALL_NUMBERS;

import baseball.game.BallCountResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Computer {

    private List<Integer> baseballNumbers;
    private boolean isStrikeOut = false;

    public void generateBaseballNumbers() {
        initStrikeOut();

        baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < TOTAL_BASEBALL_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
            }
        }
    }

    private void initStrikeOut() {
        isStrikeOut = false;
    }

    public void printBaseballResult(List<Integer> playerBaseballNumbers) {
        BallCountResult result = compareComputerWith(playerBaseballNumbers);
        generateBaseballResultMessage(result.ballCount(), result.strikeCount());
        checkStrikeOut(result.strikeCount());
    }

    private BallCountResult compareComputerWith(List<Integer> playerBaseballNumbers) {
        int strikeCount = calculateStrikes(playerBaseballNumbers);
        int ballCount = calculateBalls(playerBaseballNumbers) - strikeCount;

        return new BallCountResult(ballCount, strikeCount);
    }

    private int calculateStrikes(List<Integer> playerBaseballNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (baseballNumbers.get(i).intValue() == playerBaseballNumbers.get(i).intValue()) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int calculateBalls(List<Integer> playerBaseballNumbers) {
        int ballCount = 0;
        for (Integer number : playerBaseballNumbers) {
            if (baseballNumbers.contains(number)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private void generateBaseballResultMessage(int ballCount, int strikeCount) {
        StringJoiner sj = new StringJoiner(" ");
        if (ballCount > 0) {
            sj.add(ballCount + "볼");
        }
        if (strikeCount > 0) {
            sj.add(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sj.add("낫싱");
        }
        System.out.println(sj);
    }

    private void checkStrikeOut(int strikeCount) {
        if (strikeCount >= MAX_STRIKES) {
            isStrikeOut = true;
            System.out.println(MAX_STRIKES + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean isStrikeOut() {
        return isStrikeOut;
    }
}
