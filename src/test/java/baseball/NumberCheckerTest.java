package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * NumberChecker.class 의 테스트 코드 이다.
 */
class NumberCheckerTest {
    private final List<Integer> computerNumbers = new ArrayList<>(List.of(new Integer[]{1,2,3}));

    private NumberChecker checker;

    @BeforeEach
    void testInit() {
        checker = NumberChecker.setRandomNumbers(computerNumbers);
    }

    @Test
    void 볼_갯수가_2개일_경우_참인지_체크한다() {
        int expectCount = 2;
        List<Integer> inputNumbers = new ArrayList<>(List.of(new Integer[]{2,1,5}));

        int actualCount = checker.getBallCount(inputNumbers);

        assertThat(expectCount).isEqualTo(actualCount);
    }

    @Test
    void 볼_갯수가_없을_경우_참인지_체크한다() {
        int expectCount = 0;
        List<Integer> inputNumbers = new ArrayList<>(List.of(new Integer[]{5,6,7}));

        int actualCount = checker.getBallCount(inputNumbers);

        assertThat(expectCount).isEqualTo(actualCount);
    }

    @Test
    void 스트라이크_갯수가_2개일_경우_참인지_체크한다() {
        int expectCount = 2;
        List<Integer> inputNumbers = new ArrayList<>(List.of(new Integer[]{1,2,5}));

        int actualCount = checker.getStrikeCount(inputNumbers);

        assertThat(expectCount).isEqualTo(actualCount);
    }

    @Test
    void 스트라이크_갯수가_없을_경우_참인지_체크한다() {
        int expectCount = 0;
        List<Integer> inputNumbers = new ArrayList<>(List.of(new Integer[]{5,6,7}));

        int actualCount = checker.getStrikeCount(inputNumbers);

        assertThat(expectCount).isEqualTo(actualCount);
    }
}