package computer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {
    @Test
    @DisplayName("힌트가 올바르게 저장되고 로드되는지")
    void 힌트_테스트(){
        //given
        Hint hint=Hint.getInstance();
        int strike=1;
        int ball=2;

        //when
        hint.save(strike,ball);

        //then
        Assertions.assertThat(hint.loadStrike()).isEqualTo(strike);
        Assertions.assertThat(hint.loadBall()).isEqualTo(ball);

    }

    @Test
    @DisplayName("힌트가 새로 입력될때마다 기존의 값이 초기화되고 새로 입력된 값이 저장되어야 한다.")
    void 힌트_클리어_테스트(){
        //given
        Hint hint=Hint.getInstance();
        int strike=2;
        int ball=0;

        //when
        hint.save(strike,ball);

        //then
        Assertions.assertThat(hint.loadStrike()).isEqualTo(strike);
        Assertions.assertThat(hint.loadBall()).isEqualTo(ball);
    }
}