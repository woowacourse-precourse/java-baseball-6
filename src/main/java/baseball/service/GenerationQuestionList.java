package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
import java.util.List;

public class GenerationQuestionList {
    private static final int NUMBER_IN_RANGE_MIN = 1;
    private static final int NUMBER_IN_RANGE_MAX = 9;
    private static final int NUMBER_LIST_SIZE_MAX = 3;
    private final List<Integer> ThreeRandomNumberList;

    public GenerationQuestionList(List<Integer> threeRandomNumberList) {
        ThreeRandomNumberList = threeRandomNumberList;
    }

    public List<Integer> generateThreeRandomNumber() {
        while (ThreeRandomNumberList.size() < NUMBER_LIST_SIZE_MAX) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_IN_RANGE_MIN, NUMBER_IN_RANGE_MAX);

            if (!includeNumber(randomNumber, ThreeRandomNumberList)) {
                ThreeRandomNumberList.add(randomNumber);
            }
        }
        return ThreeRandomNumberList;
    }

    private boolean includeNumber(int randomNumber, Collection checkedCollection) {
        if (checkedCollection.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
