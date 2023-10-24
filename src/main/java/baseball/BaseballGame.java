package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private List<Integer> answer;

    static public BaseballResultState match(List<Integer> a, List<Integer> b) {
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!a.get(i).equals(b.get(j)))
                    continue;

                if (i == j)
                    strike++;
                else
                    ball++;
            }
        }

        return new BaseballResultState(ball, strike);
    }
}
