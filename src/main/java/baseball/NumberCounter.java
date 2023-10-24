package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberCounter {

    public int countStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            int comNum = computerNumber.get(i);
            int userNum = userNumber.get(i);

            if (comNum == userNum) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int balls = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            int comNum = computerNumber.get(i);
            int userNum = userNumber.get(i);

            if (comNum != userNum && computerNumber.contains(userNum)) {
                balls++;
            }
        }

        return balls;
    }
}
