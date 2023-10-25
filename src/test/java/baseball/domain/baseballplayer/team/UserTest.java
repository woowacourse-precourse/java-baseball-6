package baseball.domain.baseballplayer.team;

import baseball.domain.baseballplayer.dto.Ball;
import baseball.domain.baseballplayer.team.validator.UserInputValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    private final User user = User.newInstance(UserInputValidator.newInstance());

    @AfterEach
    void consoleClose() {
        close();
    }

    @Test
    void 입력값_성공_테스트() {
        // given
        systemSetIn("123");

        // when
        user.createNewBall();
        Ball ball = user.getBall();

        // then
        assertThat(ball.numbers())
                .isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 세자리_숫자_초과_입력값_실패_테스트() {
        // given
        systemSetIn("1234");

        // when & then
        whenInvalidBallIsRequested_thenIllegalArgumentExceptionIsThrown();
    }

    @Test
    void 세자리_숫자_미만_입력값_실패_테스트() {
        // given
        systemSetIn("34");

        // when & then
        whenInvalidBallIsRequested_thenIllegalArgumentExceptionIsThrown();
    }

    @Test
    void 숫자외에_입력값_실패_테스트() {
        // given
        systemSetIn("우12");

        // when & then
        whenInvalidBallIsRequested_thenIllegalArgumentExceptionIsThrown();
    }

    @Test
    void 제로_입력값_포함_실패_테스트() {
        // given
        systemSetIn("104");

        // when & then
        whenInvalidBallIsRequested_thenIllegalArgumentExceptionIsThrown();
    }

    private static void systemSetIn(final String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void whenInvalidBallIsRequested_thenIllegalArgumentExceptionIsThrown() {
        assertThatThrownBy(user::createNewBall)
                .isInstanceOf(IllegalArgumentException.class);
    }

}