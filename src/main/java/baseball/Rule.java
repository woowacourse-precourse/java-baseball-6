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

    public int countStrikes(ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber) {
        int count = 0;
        for (int i = 0; i < answerNumber.size(); i++) {
            if (answerNumber.get(i).equals(userNumber.get(i))) {
                count++;
            }
        }
        return count;
    }
}
