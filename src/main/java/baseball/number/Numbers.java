package baseball.number;

import baseball.util.NumbersComparator;
import baseball.result.Result;
import java.util.List;

/**
 * Player가 생성한/입력한 숫자들에 대한 정보를 가지고 있는 클래스이다. Number의 구조로 이루어져 있다.
 *
 * @author Seongha Park
 */
public class Numbers {
    List<Number> numbers;
    static final int MAX_SIZE = 3;
    static final int NOT_INCLUDE = -1;

    /**
     * List를 이용해 생성하며, List의 크기가 3을 넘을 경우, 에러를 반환한다.
     */
    public Numbers(List<Number> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        this.numbers = numbers;
    }

    /**
     * 다른 Player와 숫자를 비교한다.
     *
     * @param other 비교할 피 대상자의 Numbers이다.
     * @return 비교 결과를 담는 Result 클래스이다.
     */
    public Result compareWith(Numbers other) {
        return new NumbersComparator().compareWith(this, other);
    }

    /**
     * List에서 idx의 요소를 꺼내 반환하는 함수이다.
     */
    public Number getNumber(int index) {
        return numbers.get(index);
    }

    /**
     * 숫자가 List에 존재하는지 확인한다.
     *
     * @param number 중복 여부를 확인 할 피 대상자이다.
     * @return 중복되지 않았을 경우 -1을 출력하며, 중복되었을 경우 중복된 자리의 인덱스를 반환한다.
     */
    public int includeNumber(Number number) {
        if (numbers.contains(number)) {
            return numbers.indexOf(number);
        }
        return NOT_INCLUDE;
    }
}
