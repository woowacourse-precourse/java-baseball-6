package baseball.model;

import java.util.List;
import java.util.function.BiPredicate;

/**
 * 사용자와 컴퓨터의 선택된 숫자 리스트를 비교하여 스트라이크와 볼의 개수를 계산하는 클래스입니다.
 *
 * <p>스트라이크와 볼을 판단하기 위한 조건이 구현되어 있으며,
 * 주어진 두 리스트를 비교하여 해당 조건에 따라 개수를 반환합니다.</p>
 */
public class BallCounter {

    /**
     * 주어진 컴퓨터의 숫자 리스트와 사용자의 숫자 리스트를 비교하여 스트라이크 개수를 반환합니다.
     *
     * @param computerNumbers 컴퓨터의 선택된 숫자 리스트
     * @param userNumbers 사용자의 입력된 숫자 리스트
     * @return 스트라이크 개수
     */
    public int countStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return count(computerNumbers, userNumbers,
                (computerNumber, index) -> computerNumber.equals(userNumbers.get(index)));
    }

    /**
     * 주어진 컴퓨터의 숫자 리스트와 사용자의 숫자 리스트를 비교하여 볼 개수를 반환합니다.
     * 단, 동일 위치에 있는 숫자는 제외합니다.
     *
     * @param computerNumbers 컴퓨터의 선택된 숫자 리스트
     * @param userNumbers 사용자의 입력된 숫자 리스트
     * @return 볼 개수
     */
    public int countBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return count(computerNumbers, userNumbers,
                (computerNumber, index) -> userNumbers.contains(computerNumber) && userNumbers.indexOf(computerNumber) != index);
    }

    /**
     * 주어진 조건에 따라 두 리스트를 비교하여 일치하는 숫자의 개수를 반환합니다.
     *
     * @param computerNumbers 컴퓨터의 선택된 숫자 리스트
     * @param userNumbers 사용자의 입력된 숫자 리스트
     * @param condition 스트라이크 또는 볼을 판단하기 위한 조건
     * @return 일치하는 숫자의 개수
     */
    private int count(List<Integer> computerNumbers, List<Integer> userNumbers, BiPredicate<Integer, Integer> condition) {
        int count = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (condition.test(computerNumbers.get(i), i)) {
                count++;
            }
        }
        return count;
    }
}
