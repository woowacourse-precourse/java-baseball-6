package baseball.service;

import static baseball.util.ThreeOutCount.getThreeOutCount;

import baseball.config.WithinRange;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerationQuestionList {

    private final static String LESS_THAN_OUTCOUNT_ERROR = "설정 하신 값의 범위는 설정하신 아웃카운트 보다 작습니다.";

    private final List<Integer> ballCountList;

    public GenerationQuestionList(ArrayList<Integer> ballCountList) {
        this.ballCountList = ballCountList;
    }

    public List<Integer> generateRandomNumberList(WithinRange randomNumberInRange) {

        if (!validWithinRange(randomNumberInRange)) {
            throw new IllegalArgumentException(LESS_THAN_OUTCOUNT_ERROR);
        }

        while (ballCountList.size() < getThreeOutCount()) {
            int randomNumber = Randoms.pickNumberInRange(randomNumberInRange.startInclusive(),
                    randomNumberInRange.endInclusive());

            if (!includeNumber(randomNumber, ballCountList)) {
                ballCountList.add(randomNumber);
            }
        }
        return ballCountList;
    }

    private boolean includeNumber(int randomNumber, List<Integer> checkedList) {
        return checkedList.contains(randomNumber);
    }

    public boolean validWithinRange(WithinRange randomNumberInRange) {
        int result = (randomNumberInRange.endInclusive() - randomNumberInRange.startInclusive()) + 1;
        if (getThreeOutCount() > result) {
            System.out.println();
            return false;
        }

        return true;
    }
}
