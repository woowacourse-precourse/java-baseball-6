package baseball;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 랜덤 숫자를 생성하는 구현체
 * nextstep의 Randoms 객체를 사용하여 Random 숫자를 반환하도록 만들었습니다.
 */
public class NsRandomGenerator implements RandomGenerator {
    @Override
    public int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
