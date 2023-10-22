package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constant.StrikeBall;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("볼카운트 결과 도메인 클래스의 객체에")
class BallCountTest {

    @Test
    @DisplayName("스트라이크 개수 요청시 정상 값을 반환하는가")
    void getStrikeNum() {
        // given
        final BallCount ballCount =
                new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.STRIKE, StrikeBall.NONE));

        // when
        final long strikeNum = ballCount.getStrikeNum();

        // then
        assertThat(strikeNum).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수 요청시 정상 값을 반환하는가")
    void getBallNum() {
        // given
        final BallCount ballCount =
                new BallCount(List.of(StrikeBall.STRIKE, StrikeBall.BALL, StrikeBall.NONE));

        // when
        final long strikeNum = ballCount.getStrikeNum();

        // then
        assertThat(strikeNum).isOne();
    }

    @Test
    @DisplayName("")
    void checkResultStatus() {}
}
