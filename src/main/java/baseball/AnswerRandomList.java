package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class AnswerRandomList {
    private List<Integer> ThreeRandomNumberList;

    public AnswerRandomList(List<Integer> threeRandomNumberList) {
        ThreeRandomNumberList = threeRandomNumberList;
    }

    public List<Integer> generateThreeRandomNumber() {
        while (ThreeRandomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ThreeRandomNumberList.contains(randomNumber)) {
                ThreeRandomNumberList.add(randomNumber);
            }
        }
        return ThreeRandomNumberList;
    }
}
