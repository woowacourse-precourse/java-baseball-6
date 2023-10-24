package baseball.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    void 스트라이크_개수_테스트() {
        BaseballNumbers computerNumber = new BaseballNumbers(List.of(1, 2, 3));
        BaseballNumbers playerNumber = new BaseballNumbers(List.of(4, 2, 5));

        int strikeCount = computerNumber.getStrikeCount(playerNumber);

        Assertions.assertEquals(1, strikeCount);
    }

    @Test
    void 볼_개수_테스트() {
        BaseballNumbers computerNumber = new BaseballNumbers(List.of(1, 2, 3));
        BaseballNumbers playerNumber = new BaseballNumbers(List.of(2, 3, 4));

        int ballCount = computerNumber.getBallCount(playerNumber);

        Assertions.assertEquals(2, ballCount);
    }

    @Test
    void 낫싱_판단_테스트() {
        BaseballNumbers computerNumber = new BaseballNumbers(List.of(1, 2, 3));
        BaseballNumbers playerNumber = new BaseballNumbers(List.of(4, 5, 6));

        boolean isNothing = computerNumber.isNothing(playerNumber);

        Assertions.assertTrue(isNothing);
    }

    @Test
    void 세_자리_숫자가_아닐_경우_예외_발생() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumbers inputNumber = new BaseballNumbers("ab23");
        });

        Assertions.assertEquals("입력은 정확히 세 자리 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void 세_자리_숫자가_맞을_경우_예외_미발생() {
        Assertions.assertDoesNotThrow(() -> {
            BaseballNumbers inputNumber = new BaseballNumbers("567");
        });
    }

    @Test
    void 입력에_중복된_숫자가_존재할_시_예외_발생() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BaseballNumbers inputNumber = new BaseballNumbers("322");
        });

        Assertions.assertEquals("중복된 숫자를 입력할 수 없습니다.", exception.getMessage());
    }
}