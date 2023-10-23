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

    private static int[] checkAnswer(List<Integer> answer, List<Integer> userInput) {
        int[] count = new int[2];
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                count[1]++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (i != j && answer.get(i).equals(userInput.get(j))) {
                    count[0]++;
                    break;
                }
            }
        }
        return count;
    }
}
