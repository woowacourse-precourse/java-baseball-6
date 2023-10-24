package baseball;

import java.util.ArrayList;

public class Rule {
    public static int countBalls(ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber) {
        int count = 0;
        for (int i = 0; i < answerNumber.size(); i++) {
            if (answerNumber.get(i).equals(userNumber.get(i))) {
                continue;
            }
            if (answerNumber.contains(userNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static int countStrikes(ArrayList<Integer> answerNumber, ArrayList<Integer> userNumber) {
        int count = 0;
        for (int i = 0; i < answerNumber.size(); i++) {
            if (answerNumber.get(i).equals(userNumber.get(i))) {
                count++;
            }
        }
        return count;
    }
}
