package baseball.player;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import baseball.util.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * Player중 Computer가 가지고 있는 숫자에 대한 정보를 담는 클래스이다.
 *
 * @author Seongha Park
 */
public final class Computer extends Player {
    private final int MAX_SIZE = 3;

    /**
     * edu.missionutils.Randoms를 사용하여 1~9의 랜덤 숫자를 생성하고 중복 유효성을 체크한다. 중복이 되지 않는다면 임시 List에 추가한다.
     */
    @Override
    public void createNumbers() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < MAX_SIZE) {
            addUniqueNumber(numbers);
        }

        this.numbers = new Numbers(numbers);
    }

    private void addUniqueNumber(List<Number> numbers) {
        Number number = generateNumber(numbers);

        NumberValidator.checkNumberValidate(number);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private Number generateNumber(List<Number> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return new Number(randomNumber);
    }

    /**
     * 숫자 야구를 위한 비교 함수이다.
     *
     * @param other 비교할 대상이다.
     * @return 비교 결과가 Result 클래스로 객체화되어 반환된다.
     */
    @Override
    public Result compareWith(Player other) {
        return super.compareWith(other);
    }
}
