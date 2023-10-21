package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    private int ball;
    private int strike;

    public int getStrike() {
        return strike;
    }

    public List<Integer> numberCompare(List<Integer> userNumber, List<Integer>computerNumber)
    {
        resetCount();
        strikeCount(userNumber,computerNumber);
        ballCount(userNumber,computerNumber);
        List<Integer> result = new ArrayList<>();
        result.add(ball);
        result.add(strike);
        for (int i = 0; i < 2; i++) {
            System.out.println(result.get(i));
        }
        return result;
    }



    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    private void strikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if(computerNumber.get(i).equals(userNumber.get(i))){
                strike++;
            }
        }
    }

    private void ballCount(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if(computerNumber.contains(userNumber.get(i)) && !computerNumber.get(i).equals(userNumber.get(i))) {
                ball++;
            }
        }
    }
}

