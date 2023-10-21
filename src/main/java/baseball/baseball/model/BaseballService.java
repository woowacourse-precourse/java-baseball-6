package baseball.baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballService {

    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    public List<Integer> createGoalNumber() {
        List<Integer> temp = new ArrayList<>();

        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        return temp;
    }

    // 숫자 맞추기
    public String checkNumber(List<Integer> goalNumber, List<Integer> inputNumber){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(goalNumber.get(i), inputNumber.get(i))) {
                strike++;
                continue;
            }
            if (inputNumber.contains(goalNumber.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) return NOTHING;
        if (strike == 0) return ball + BALL;
        if (ball == 0) return strike + STRIKE;
        return ball + BALL + " " + strike + STRIKE;
    }
}
