package baseball.service;

import baseball.config.withinRange;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerationQuestionList {

    private final List<Integer> ballCountList;
    private static final int OUT_COUNT = 3;

    public GenerationQuestionList(ArrayList<Integer> ballCountList) {
        this.ballCountList = ballCountList;
    }

    public List<Integer> generateRandomNumberList(withinRange randomNumberInRange) {

        if (!validWithinRange(randomNumberInRange)) {
            throw new IllegalArgumentException("설정 하신 값의 범위는 설정하신 아웃카운트 보다 작습니다.");
        }

        while (ballCountList.size() < OUT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(randomNumberInRange.startInclusive(),
                    randomNumberInRange.endInclusive());

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

    public boolean validWithinRange(withinRange randomNumberInRange) {
        int result = (randomNumberInRange.endInclusive() - randomNumberInRange.startInclusive()) + 1;
        if (OUT_COUNT > result) {
            System.out.println();
            return false;
        }

        return true;
    }
}
