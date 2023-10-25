package baseball.learningtest.randoms;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    private static final int MIN = 1;
    private static final int MAX = 9;

    @Test
    @DisplayName("범위내의 무작위 숫자를 반환한다.")
    public void should_returnRandomNumberInRange_when_pickingNumberInRange() {

        //when
        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);

        //then
        assertThat(inRange(randomNumber)).isTrue();
    }

    @Test
    @DisplayName("리스트범위내의 난수를 생성한다")
    public void should_returnRandomNumberInRangeForList_when_pickNumberInList() {
        List<Integer> list = List.of(1, 3, 5, 7, 9);

        //when
        int randomNumber = Randoms.pickNumberInList(list);

        //then
        assertThat(list).contains(randomNumber);
    }

    @Test
    @DisplayName("범위내의 무작위 숫자들을 중복되지 않게 반환한다.")
    public void should_returnUniqueRandomNumbersInRange_when_pickingMultipleUniqueNumbersInRange() {

        //when
        List<Integer> randomNumbers = Randoms
                .pickUniqueNumbersInRange(MIN, MAX, 3);

        //then
        assertThat(randomNumbers).hasSize(3);
        assertThat(randomNumbers.stream().distinct().count()).isEqualTo(3);
        for (Integer number : randomNumbers) {
            assertThat(inRange(number)).isTrue();
        }
    }

    private static boolean inRange(Integer number) {
        return MIN <= number && number <= MAX;
    }

}
