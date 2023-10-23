package baseball.model;

import static baseball.utils.Convert.booleanToInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private NumberList answer;

    public boolean isAnswer(NumberList guess) {
        return answer.equals(guess);
    }

    public void createRandomAnswer() {
        List<Integer> answerList = new ArrayList<>() {{
            while (size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!contains(randomNumber)) {
                    add(randomNumber);
                }
            }
        }};
        answer = new NumberList(answerList);
    }

    public Hint calculateHint(NumberList guess) {
        return new Hint(calculateBallCount(answer, guess),
                calculateStrikeCount(answer, guess));
    }

    private int calculateBallCount(NumberList answer, NumberList guess) {
        int ballCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < guess.size(); j++) {
                ballCount += booleanToInt(answer.get(i).equals(guess.get(j)) && i != j);
            }
        }
        return ballCount;
    }

    private int calculateStrikeCount(NumberList answer, NumberList guess) {
        int strikeCount = 0;
        for (int i = 0; i < answer.size(); i++) {
            strikeCount += booleanToInt(answer.get(i).equals(guess.get(i)));
        }
        return strikeCount;
    }
}
