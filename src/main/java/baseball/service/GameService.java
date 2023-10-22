package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GameService {
    List<Integer> computerNumber;
    HashSet<Integer> answerDigit = new HashSet<>();

    public GameService(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
        this.answerDigit.addAll(computerNumber);
    }

    public List<Integer> compareNumbers(List<Integer> userNumber) {
        int strikeCnt = countStrike(userNumber);
        int ballCnt = countSameNumber(userNumber) - strikeCnt;

        return new ArrayList<>(Arrays.asList(strikeCnt, ballCnt));
    }

    private int countStrike(List<Integer> userNumber) {
        int cnt = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private int countSameNumber(List<Integer> userNumber) {
        int cnt = 0;
        for (Integer num : userNumber) {
            if (this.answerDigit.contains(num)) {
                cnt++;
            }
        }
        return cnt;
    }
}
