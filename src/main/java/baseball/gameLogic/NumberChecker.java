package baseball;

import baseball.models.Score;
import java.util.List;
import static baseball.models.Constants.*;

public class NumberChecker {
    public Score checkNumber(List<Integer> user, List<Integer> computer){
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (isStrike(user.get(i), computer.get(i)))
                strikeCount++;
            else if (isBall(computer, user.get(i)))
                ballCount++;
        }
        return new Score(ballCount, strikeCount);
    }

    public boolean isStrike(int userDigit, int computerDigit){
        return userDigit == computerDigit;
    }

    public boolean isBall(List<Integer> computer, int userDigit){
        return computer.contains(userDigit);
    }

}
