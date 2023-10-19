package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    // 사용자 입력값 검증
    public void isThreeDigit(List<Integer> userNumbers) {
        if (userNumbers.size() != 3)
            throw new IllegalArgumentException("3자리 수를 입력하세요.");
    }

    public void isNotInSameNumber(List<Integer> userNumbers) {
        int originSize = userNumbers.size();
        List<Integer> distinct = userNumbers.stream().distinct().toList();

        if (originSize != distinct.size())
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요.");
    }

    // 재시작/종료 입력값 검증
    public void isOneOrTow(int restartNumber) {
        if ( (restartNumber != 1) && (restartNumber != 2) )
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
