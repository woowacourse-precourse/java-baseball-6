package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OutputModel {
    private static List<Integer> strikeBallList;
    private static String baseballHint;

    public static void strikeBallCalculate(List<Integer> list1, List<Integer> list2) {

        int samePositionCount = 0;
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        // 리스트를 집합으로 만든다
        set1.retainAll(set2);
        // 교집합을 만들어서 겹치는 숫자 개수를 확인
        for (int i = 0; i < 3; i++) {
            int num1 = list1.get(i);
            int num2 = list2.get(i);

            if (num1 == num2) {
                samePositionCount++; // 공통된 숫자
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(samePositionCount); // 스트라이크
        result.add(set1.size() - samePositionCount); // 볼
        strikeBallList = result;
    }

    private static String makeBaseballHint() {
        int strike = strikeBallList.get(0);
        int ball = strikeBallList.get(1);
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public static void setBaseballHint() {
        baseballHint = makeBaseballHint();
    }

    public static String getBaseballHint() {
        return baseballHint;
    }

}
