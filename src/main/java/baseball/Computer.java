package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int ANSWER_SIZE = 3;
    public static final int RANGE_START = 1;
    public static final int RANGE_END = 9;

    private List<Integer> answer;

    /**
     * answer에 서로 다른 3개의 정수를 가진 List<Integer>을 저장
     */
    public void init() {
        answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    /**
     * 사용자의 입력에 대한 결과 반환
     *
     * @param input 사용자가 입력한 서로 다른 3개의 숫자 리스트
     * @return 사용자의 입력과 answer를 비교한 결과 리스트
     */
    public Result getResult(List<Integer> input) {

        Result result = new Result();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int number = input.get(i);
            if (answer.get(i).equals(number)) {
                result.addStrike();
            } else if (answer.contains(number)) {
                result.addBall();
            }
        }
        return result;
    }

    //== 테스트용 메서드 ==//

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(int[] list) {
        answer = new ArrayList<>();
        for (int i : list) {
            answer.add(i);
        }
    }
}
