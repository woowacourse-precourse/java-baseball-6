package baseball.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateNumbers {


    public static List<Integer> checkBall(List<Integer> com, List<Integer> user) {
        int cnt_nothing = 0;
        int cnt_ball = 0;
        int cnt_strike = 0;
        // nothing
        for (int i = 0; i < 3; i++) {
            if (!com.contains(user.get(i))) {
                cnt_nothing += 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (com.get(i).equals(user.get(i))) {
                cnt_strike += 1;
            }
        }

        cnt_ball = 3 - cnt_strike - cnt_nothing;

        return new ArrayList<>(Arrays.asList(cnt_nothing, cnt_ball, cnt_strike));
    }
}
