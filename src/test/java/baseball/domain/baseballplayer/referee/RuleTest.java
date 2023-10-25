package baseball.domain.baseballplayer.referee;

import baseball.domain.baseballplayer.dto.Ball;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    @Test
    void 스트라이크_카운트_규칙_테스트() {
        // given
        Ball offenseTeamBallNumbers = new Ball(List.of(1, 2, 3));
        Ball defenseTeamBallNumbers = new Ball(List.of(1, 2, 3));

        final Rule rule = Rule.newInstance();
        rule.setTeamsBallNumbers(offenseTeamBallNumbers, defenseTeamBallNumbers);

        // when
        int strikeCount = rule.calculateStrikeCount();

        // then
        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 볼_카운트_규칙_테스트() {
        // given
        Ball offenseTeamBallNumbers = new Ball(List.of(1, 2, 3));
        Ball defenseTeamBallNumbers = new Ball(List.of(3, 9, 1));

        final Rule rule = Rule.newInstance();
        rule.setTeamsBallNumbers(offenseTeamBallNumbers, defenseTeamBallNumbers);

        // when
        int ballCount = rule.calculateBallCount();

        // then
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void 스트라이크_카운트와_볼_카운트_테스트() {
        // given
        Ball offenseTeamBallNumbers = new Ball(List.of(1, 2, 3));
        Ball defenseTeamBallNumbers = new Ball(List.of(3, 2, 9));

        final Rule rule = Rule.newInstance();
        rule.setTeamsBallNumbers(offenseTeamBallNumbers, defenseTeamBallNumbers);

        // when
        int ballCount = rule.calculateBallCount();
        int strikeCount = rule.calculateStrikeCount();

        // then
        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
    }

}