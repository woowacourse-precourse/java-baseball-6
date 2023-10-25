package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int ANSWER_SIZE = 3;
    public static final int RANDOM_RANGE_START = 1;
    public static final int RANDOM_END_START = 9;
    private List<Integer> answer;

    /**
     * 서로 다른 3개의 정수를 List<Integer>형의 answer로 저장
     */
    public void makeAnswer() {
        answer = new ArrayList<>();

        while (answer.size() != ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_END_START);
            if (!(answer.contains(randomNumber))) {
                answer.add(randomNumber);
            }
        }
    }

    public Result getResult(List<Integer> input) {
        Result result = new Result();

        for (int i = 0; i < ANSWER_SIZE; i++) {

            if (answer.contains(input.get(i))) {
                if (answer.get(i) == input.get(i)) {
                    result.addStrike();
                } else {
                    result.addBall();
                }
            }
        }

        return result;
    }

    // 테스트용 메서드
    public List<Integer> getAnswer() {
        return answer;
    }

}