package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerNumberTest {

    @DisplayName("정답 숫자와 입력 숫자를 비교해 올바른 스트라이크, 볼 개수를 반환한다.")
    @Test
    void verifyStrike() {
        // given
        ComputerNumber computerNumber = new ComputerNumber();
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userNumber = List.of(1,3,2);

        // when
        int strike = computerNumber.verifyStrike(answer, userNumber);
        int ball = computerNumber.verifyBall(answer, userNumber);

        // then
        assertAll(
                () -> assertEquals(1, strike),
                () -> assertEquals(2, ball)
        );
    }

}