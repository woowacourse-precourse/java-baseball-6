package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>(3);
        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer;
    }
}
