package baseball;

import java.util.ArrayList;

public class Rule {
    public int countBalls(ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber) {
        int count = 0;
        for (Integer num : userNumber) {
            if (answerNumber.contains(num)) {
                count++;
            }
        }
        return count;
    }
}
