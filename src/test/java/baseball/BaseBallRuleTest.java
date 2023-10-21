package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallRuleTest {

    @Test
    @DisplayName("3스트라이크면 게임 룰 통과")
    void 룰_적용_테스트(){
        //given
        int strike=3;
        GameRule rule=new BaseBallRule();

        //when
        boolean pass=rule.isRulePass(strike);

        //then
        Assertions.assertThat(pass).isEqualTo(true);

    }

    @Test
    @DisplayName("3스트라이크가 아니면 게임 룰 불통과")
    void 룰_실패_테스트(){
        //given
        int strike=2;
        GameRule rule=new BaseBallRule();

        //when
        boolean pass=rule.isRulePass(strike);

        //then
        Assertions.assertThat(pass).isEqualTo(false);

    }
}