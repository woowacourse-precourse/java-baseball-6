package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> makeAnswerList() {
        List<Integer> answerRandomList = new ArrayList<>();
        while (answerRandomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerRandomList.contains(randomNumber)) {
                answerRandomList.add(randomNumber);
            }
        }

        return answerRandomList;
    }

}