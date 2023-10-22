package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Answer {

    private static List<Integer> answers;
    private static int[] temp_answers;

    public Answer() {
        answers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public Answer(int answer) {
        if (!check(answer)) {
            throw new IllegalArgumentException();
        }
        answers.clear();
        for (int i = 0; i < 3; i++) {
            answers.add(temp_answers[i]);
        }

    }

    public Answer(String answer) {
        new Answer(Integer.parseInt(answer));
    }

    // 숫자 야구에 적합한 숫자인지 확인, 숫자가 세자리 수이고 각 자리수가 다른지 확인
    public boolean check(int num) {

        if (num < 123 || 987 < num) {
            return false;
        }

        temp_answers = new int[3];
        for (int i = 0; i < 3; i++) {
            temp_answers[2 - i] = num % 10;
            num /= 10;
        }
        return (temp_answers[0] != temp_answers[1] && temp_answers[0] != temp_answers[2]
                && temp_answers[1] != temp_answers[2]);
    }

}
