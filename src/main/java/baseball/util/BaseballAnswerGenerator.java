package baseball.util;

import baseball.util.constants.BaseballGameConstants;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballAnswerGenerator {

    public static int[] generate() {
        int[] result = new int[BaseballGameConstants.NUM_LENGTH];
        int idx = 0;
        while (idx < BaseballGameConstants.NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BaseballGameConstants.MIN_NUM, BaseballGameConstants.MAX_NUM);
            if (containsValue(result, idx, randomNumber)) {
                continue;
            }
            result[idx++] = randomNumber;
        }
        return result;
    }

    private static boolean containsValue(int[] arr, int size, int target) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
}
