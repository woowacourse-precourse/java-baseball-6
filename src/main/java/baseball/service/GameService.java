package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import baseball.model.NumberModel;

public class GameService {
    private final NumberModel numberModel;
    private final List<Integer> computerNumber;
    private final HashSet<Integer> answerDigit = new HashSet<>();

    public GameService(NumberModel numberModel) {
        this.numberModel = numberModel;
        this.computerNumber = this.numberModel.getComputerNumbers();
        this.answerDigit.addAll(computerNumber);
    }

    public List<Integer> compareNumbers() {
        List<Integer> userNumber = this.numberModel.getUserNumbers();
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
