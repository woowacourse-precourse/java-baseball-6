package baseball;

import java.util.List;

public class BaseballReferee {
    public UserInputResult scoreInput(List<Integer> expect, List<Integer> actual) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < expect.size(); i++) {
            if (expect.get(i) == actual.get(i)) {
                strike++;
            } else if (expect.contains(actual.get(i))) {
                ball++;
            }
        }

        return new UserInputResult(ball, strike);
    }
}
