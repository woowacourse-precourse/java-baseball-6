package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CheckException {

    /**
     * 사용자가 입력한 숫자를 예외 검사하고 정수 리스트로 변환합니다.
     *
     * @param tempBall 사용자가 입력한 숫자 문자열
     * @return 숫자 예외가 없는 경우 변환된 정수 리스트 반환
     * @throws IllegalArgumentException 사용자 입력이 잘못된 경우 발생
     */

    protected static List<Integer> giveException(String tempBall) {
        List<Integer> integerTempBall;

        try {
            integerTempBall = Arrays.stream(tempBall.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }

        if (integerTempBall.size() != 3) {
            throw new IllegalArgumentException("입력한 숫자는 3개여야 합니다.");
        }

        if (integerTempBall.contains(0)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }

        Set<Integer> tempSet = new HashSet<>(integerTempBall);
        if(tempSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }

        return integerTempBall;
    }
}
