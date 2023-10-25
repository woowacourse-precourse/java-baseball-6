package baseball.player;

import baseball.number.Numbers;
import baseball.result.Result;

/**
 * 숫자 야구를 진행하는 유저를 의미하며 sealed class로 User, Computer만 상속가능하다.
 *
 * @author Seongha Park
 */
public sealed class Player permits User, Computer {
    protected Numbers numbers;

    /**
     * 숫자 야구를 하기 위한 Numbers를 랜덤 생성 / 입력하는 함수이다.
     */
    public void createNumbers() {
    }

    /**
     * 숫자 야구를 위한 비교 함수이다.
     *
     * @param other 비교할 대상이다.
     * @return 비교 결과가 Result 클래스로 객체화되어 반환된다.
     */
    public Result compareWith(Player other) {
        return numbers.compareWith(other.numbers);
    }
}
