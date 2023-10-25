package baseball;

import java.util.ArrayList;
import java.util.List;

public class Count {

    private int strike = 0;
    private int ball = 0;
    private List<Integer> BallandStrikeCount = new ArrayList<>();

    public void setStrike(int strike) {
        this.strike = strike;
    }


    public List<Integer> CountcountBallsAndStrikes(List<Integer> userNumber, List<Integer> computerNumber) {
        Reset();
        countStrike(userNumber, computerNumber);
        countBall(userNumber, computerNumber);
        setBallandStrikeCount(ball, strike);
        return BallandStrikeCount;


    }

    public void Reset() {
        ball = 0;
        strike = 0;
        BallandStrikeCount.clear();
    }

    public void setBallandStrikeCount(int Ball, int Strike) {
        BallandStrikeCount.add(Ball);
        BallandStrikeCount.add(Strike);
    }

    public void countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strikeCount = 0;

        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikeCount += 1;
            }
        }

        setStrike(strikeCount);
    }

    public void countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            for (int j = 0; j < computerNumber.size(); j++) {
                if (i != j) {
                    if (computerNumber.get(i).equals(userNumber.get(j))) {
                        ball += 1;
                    }
                }
            }

        }
    }


}
