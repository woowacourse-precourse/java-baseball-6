package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballNumbers {

    List<Integer> baseballNumbers;

    public BaseballNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbersString = Console.readLine();
        // TODO: 야구숫자 입력값에 대한 예외처리 필요
        this.baseballNumbers = inputNumbersString.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public List<Integer> getNumbers() {
        return baseballNumbers;
    }
}
