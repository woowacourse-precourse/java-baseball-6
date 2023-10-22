package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    // generateNum
    public static final int SIZE = 3;
    public static final int MIN_NUM = 3;
    public static final int MAX_NUM = 3;

    List<Integer> answerNum;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerNum = generateAnswer();
    }

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < SIZE) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }
}
