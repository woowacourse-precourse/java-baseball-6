package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    // 정답 숫자 설정
    public List<Integer> createAnswerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int answerNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(answerNumber)) {
                computer.add(answerNumber);
            }
        }
        return computer;
    }


}
