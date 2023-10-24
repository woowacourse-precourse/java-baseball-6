package baseball;

import static baseball.GameClient.BALL_LENGTH;
import static baseball.GameClient.RANGE_MAXIMUM_VALUE;
import static baseball.GameClient.RANGE_MINIMUM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 컴퓨터의 계산을 처리하는 클래스.
 * <p>같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 제공한다.
 */
public class Computer {
    private List<Integer> answerNumbers;

    public void refreshAnswer() {
        this.answerNumbers = createAnswer();
    }

    public BallCount calculateBallCount(List<Integer> playerNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int answerIndex = 0; answerIndex < BALL_LENGTH; answerIndex++) {
            int answerNumber = answerNumbers.get(answerIndex);
            if (answerNumber == playerNumbers.get(answerIndex)) {
                strikeCount++;
            } else if (playerNumbers.contains(answerNumber)) {
                ballCount++;
            }
        }
        return new BallCount(strikeCount, ballCount);
    }

    private List<Integer> createAnswer() {
        List<Integer> answerNumbers = new ArrayList<>();
        HashSet<Integer> chosenNumbers = new HashSet<>();
        while (chosenNumbers.size() < BALL_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(RANGE_MINIMUM_VALUE, RANGE_MAXIMUM_VALUE);
            if (!chosenNumbers.contains(pickedNumber)) {
                chosenNumbers.add(pickedNumber);
                answerNumbers.add(pickedNumber);
            }
        }
        return answerNumbers;
    }
}
