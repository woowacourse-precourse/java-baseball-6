package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerationQuestionList {

    private final List<Integer> ballCountList;

    public GenerationQuestionList(ArrayList<Integer> ballCountList) {
        this.ballCountList = ballCountList;
    }

    public List<Integer> generateRandomNumberList(int startInclusive, int endInclusive, int outCount) {

        while (ballCountList.size() < outCount) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);

            if (!includeNumber(randomNumber, ballCountList)) {
                ballCountList.add(randomNumber);
            }
        }
        return ballCountList;
    }

    private boolean includeNumber(int randomNumber, List<Integer> checkedList) {
        if (checkedList.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
