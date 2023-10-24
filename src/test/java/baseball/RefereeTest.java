package baseball;

import baseball.model.rule.BallRule;
import baseball.model.rule.GameRule;
import baseball.model.number.PlayNumber;
import baseball.model.Referee;
import baseball.model.rule.StrikeRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    void 스트라이크_테스트() {
        // given
        GameRule gameRule = new StrikeRule();
        PlayNumber computerNumber = PlayNumber.from("325");
        PlayNumber userNumber = PlayNumber.from("123");
        // when
        int strike = Referee.answerResult(gameRule, computerNumber, userNumber);
        // then
        Assertions.assertThat(strike).isEqualTo(1);
    }

    @Test
    void 볼_테스트() {
        // given
        GameRule gameRule = new BallRule();
        PlayNumber computerNumber = PlayNumber.from("123");
        PlayNumber userNumber = PlayNumber.from("256");
        // when
        int ball = Referee.answerResult(gameRule, computerNumber, userNumber);
        // then
        Assertions.assertThat(ball).isEqualTo(1);
    }

    @Test
    void 볼_및_스트라이크_테스트() {
        // given
        GameRule ballRule = new BallRule();
        GameRule strikeRule = new StrikeRule();
        PlayNumber computerNumber = PlayNumber.from("123");
        PlayNumber userNumber = PlayNumber.from("293");
        // when
        int ball = Referee.answerResult(ballRule, computerNumber, userNumber);
        int strike = Referee.answerResult(strikeRule, computerNumber, userNumber);
        // then
        Assertions.assertThat(ball).isEqualTo(1);
        Assertions.assertThat(strike).isEqualTo(1);
    }
}
