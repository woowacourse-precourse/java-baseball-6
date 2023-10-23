package baseball;

import baseball.model.GameRule;
import baseball.model.PlayNumber;
import baseball.model.Referee;
import baseball.model.StrikeRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    private GameRule strikeRule;

    @BeforeEach
    void beforeEach() {
        strikeRule = new StrikeRule();
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
}
