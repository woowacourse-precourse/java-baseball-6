package baseball.computer;

import baseball.dto.Score;
import baseball.player.UserNumberManager;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.enums.NumberInfo.*;
import static baseball.enums.Message.*;

public class RandomRuleManager implements GameManager {
    private final UserNumberManager userNumberManager;

    public RandomRuleManager(UserNumberManager userNumberManager){
        this.userNumberManager = userNumberManager;
    }

    @Override
    public List<Integer> createNumber() {
        List<Integer> randomNumber = new ArrayList<>();

        while (randomNumber.size() < COUNT.getNumberInfo()) {
            int randomNumberDigit = Randoms.pickNumberInRange(START.getNumberInfo(), END.getNumberInfo());

            if (!randomNumber.contains(randomNumberDigit)) {
                randomNumber.add(randomNumberDigit);
            }
        }

        return randomNumber;
    }

    @Override
    public Score calculateCount(List<Integer> randomNumber){
        String userNumber = userNumberManager.getUserNumber();

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            int tmp = userNumber.charAt(i) - '0';

            if (randomNumber.indexOf(tmp) == i) {
                strikeCount++;
            }
            if (randomNumber.contains(tmp)) {
                ballCount++;
            }
        }

        return new Score(strikeCount, ballCount);
    }

    @Override
    public void printCount(List<Integer> randomNumber) {
        while (true) {
            Score score = calculateCount(randomNumber);
            int strikeCount = score.getStrikeCount();
            int ballCount = score.getBallCount();

            if (strikeCount == COUNT.getNumberInfo()) {
                System.out.println(strikeCount + STRIKE_MESSAGE.getMessage());
                System.out.println(CORRECT_MESSAGE.getMessage());
                break;
            }
            if (strikeCount == 0 && ballCount == 0) {
                System.out.println(NOTHING_MESSAGE.getMessage());
                continue;
            }

            System.out.println((ballCount - strikeCount) + BALL_MESSAGE.getMessage() +
                    strikeCount + STRIKE_MESSAGE.getMessage());
        }
    }
}