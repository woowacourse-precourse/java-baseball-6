package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Answer {

    private static int[] temp_answer = new int[3];

    public int[] generateAnswer() {

        Set<Integer> digitSet = new HashSet<>();

        while (digitSet != null && digitSet.size() < 3) {
            digitSet.add(getRandomNumber());
        }

        temp_answer = convertIntegerSetToIntArray(digitSet);

        return temp_answer;
    }


    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public int[] generateAnswer(int answer) {
        if (!check(answer)) {
            throw new IllegalArgumentException();
        }

        return temp_answer;
    }

    private int[] convertIntegerSetToIntArray(Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] generateAnswer(String str) {
        int answer;
        try {
            answer = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (!check(answer)) {
            throw new IllegalArgumentException();
        }

        return temp_answer;
    }


    // 숫자 야구에 적합한 숫자인지 확인, 숫자가 세자리 수이고 각 자리수가 0이 아니며 다른지 확인
    public boolean check(int num) {

        if (num < 123 || 987 < num) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            temp_answer[2 - i] = num % 10;
            num /= 10;
        }

        if (temp_answer[1] == 0 || temp_answer[2] == 0) {
            return false;
        }

        return (temp_answer[0] != temp_answer[1] && temp_answer[0] != temp_answer[2]
                && temp_answer[1] != temp_answer[2]);
    }

}
