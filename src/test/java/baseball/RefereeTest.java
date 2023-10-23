package baseball;

import baseball.model.BallRule;
import baseball.model.GameRule;
import baseball.model.PlayNumber;
import baseball.model.Referee;
import baseball.model.StrikeRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    private GameRule strikeRule;
    private GameRule ballRule;

    @BeforeEach
    void beforeEach() {
        strikeRule = new StrikeRule();
        ballRule = new BallRule();
    }

    @Test
    void 스트라이크_테스트() {
        // given
        PlayNumber computerNumber = PlayNumber.from("325");
        PlayNumber userNumber = PlayNumber.from("123");
        // when
        int strike = Referee.answerResult(strikeRule, computerNumber, userNumber);
        // then
        Assertions.assertThat(strike).isEqualTo(1);
    }

    @Test
    void 볼_테스트() {
        // given
        PlayNumber computerNumber = PlayNumber.from("123");
        PlayNumber userNumber = PlayNumber.from("256");
        // when
        int ball = Referee.answerResult(ballRule, computerNumber, userNumber);
        // then
        Assertions.assertThat(ball).isEqualTo(1);
    }
}
