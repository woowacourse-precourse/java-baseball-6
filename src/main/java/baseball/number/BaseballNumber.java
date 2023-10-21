package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 야구게임에 필요한 3자리 수를 관리하는 클래스입니다.
 * 같은 BaseballNumber 클래스끼리 수를 비교할 수 있습니다.
 */
public class BaseballNumber {
    int[] values = {1, 1, 1};

    /**
     * 사용자의 입력이 규칙에 맞는지 확인합니다.
     * 1. 입력은 3자리여야 합니다.
     * 2. 각 자릿수는 1이상 9이하의 숫자여야 합니다.
     * 3. 각 자릿수의 숫자는 서로 겹치지 않아야 합니다.
     * @param input 3자리 숫자 형태의 문자열
     * @return 사용자의 입력이 규칙에 맞는지 여부
     */
    private boolean validateInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
            int value = Character.getNumericValue(input.charAt(i));
            if (value < 1 || value > 9) {
                return false;
            }
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }

    /**
     * 사용자 입력을 매개변수로 받아 BaseballNumber 클래스를 생성하는 생성자입니다.
     * 사용자 입력이 정해진 규칙을 만족하지 않으면 IllegalArgumentException 오류를 발생시킵니다.
     * @param input 문자열 형태의 사용자 입력
     */
    public BaseballNumber(String input) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            this.values[i] = Character.getNumericValue(input.charAt(i));
        }
    }

    /**
     * 컴퓨터를 위한 BaseballNumber 클래스를 생성하는 생성자입니다.
     * 규칙에 맞는 랜덤한 수를 자동으로 생성합니다.
     */
    public BaseballNumber() {
        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomValue)) randomValues.add(randomValue);
        }
        for (int i = 0; i < 3; i++) {
            this.values[i] = randomValues.get(i);
        }
    }

    /**
     * 자신의 번호 중 타겟 넘버와 일치하는 자릿수의 개수를 반환합니다.
     * @param target 비교를 위한 타겟 넘버
     * @return 타겟 넘버와 일치하는 자릿수의 개수
     */
    public int checkBall(int target) {
        int acc = 0;
        for (int value : this.values) {
            if (value == target) {
                acc++;
            }
        }
        return acc;
    }

    /**
     * 자신의 번호와 타겟을 숫자야구 규칙으로 비교합니다.
     * @param target 자신과 비교할 BaseballNumber 클래스
     * @return BaseballResult 클래스
     */
    public BaseballResult compareTo(BaseballNumber target) {
        BaseballResult result = new BaseballResult();
        for (int i = 0; i < 3; i++) {
            if (this.values[i] == target.values[i]) {
                result.strike++;
                continue;
            }
            result.ball += checkBall(target.values[i]);
        }
        return result;
    }
}