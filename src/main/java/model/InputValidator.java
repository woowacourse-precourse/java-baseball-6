package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    /**
     * 사용자 입력에 대한 검증 기능
     * 조건에 맞지 않으면 예외 발생
     */
    public void validateUserInputNum(List<Integer> inputNum) {
        Set<Integer> set = new HashSet<>(inputNum);
        if (inputNum.size() != 3) throw new IllegalArgumentException("3자리 수를 입력해야합니다.");
        if (inputNum.size() != set.size()) throw new IllegalArgumentException("각각 다른 숫자를 입력해주세요.");
    }

    public void validateUserInputCoin(int coin) {
        if (coin != 1 && coin != 2) throw new IllegalArgumentException("1또는 2를 입력하세요.");
    }
}
