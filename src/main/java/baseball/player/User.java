package baseball.player;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import baseball.util.NumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Player중 실제 플레이어인 유저가 가지고 있는 숫자에 대한 정보를 담는 클래스이다.
 *
 * @author Seongha Park
 */
public final class User extends Player {

    /**
     * 유저에게 edu.missionutils.Console을 통해 문자를 입력받는다. 해당 문자가 숫지인지, 숫지라면 1 ~ 9 사이인지 현재 List에 중복된 것은 없는지 판단 후 임시 List에
     * 추가한다.
     */
    @Override
    public void createNumbers() {
        String[] input = inputNumbers();

        List<Number> numbers = new ArrayList<>();
        for (String obj : input) {
            Number number = NumberValidator.convertToNumber(obj);

            NumberValidator.checkNumberValidate(number);
            checkDuplicate(numbers, number);

            numbers.add(number);
        }

        this.numbers = new Numbers(numbers);
    }

    private void checkDuplicate(List<Number> numbers, Number number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private String[] inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine().split("");
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
