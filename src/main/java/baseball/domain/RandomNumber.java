package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 랜덤 세 자리 수를 생성하기 위한 라이브러리 호출 pickNumberInRange(시작 범위, 끝 범위) : 한 자리 수 랜덤 추출 메서드
 */
public class RandomNumber {

    private List<Integer> num;

    public RandomNumber() {
        num = new ArrayList<>();
    }

    public List<Integer> make() {
        return IntStream.range(0, 3)
                .mapToObj(i -> extract())
                .collect(Collectors.toList());
    }

    private Integer extract() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
