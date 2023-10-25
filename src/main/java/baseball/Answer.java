package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Answer {

    private static List<Integer> answers = new ArrayList<>();
    private static int[] temp_answer = new int[3];

    public int[] generateAnswer() {

        answers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        for (int i = 0; i < 3; i++) {
            temp_answer[i] = answers.get(i);
        }

        return temp_answer;
    }

    public int[] generateAnswer(int answer) {
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
