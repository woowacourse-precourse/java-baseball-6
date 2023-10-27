package baseball;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {
    @DisplayName("스트라이크 3개가 되어 경기가 종료되는 경우 테스트")
    @Test
    void isGameEndTest(){
        //given
        Score score = new Score(3,0);
        //when
        //then
        assertThat(Referee.isGameEnd(score)).isTrue();
    }

    @DisplayName("스트라이크가 3개가 되지 않아 경기종료가 안되는 경우 테스트")
    @Test
    void isGameNotEndTest(){
        //given
        Score score = new Score(2,1);
        //when
        //then
        assertThat(Referee.isGameEnd(score)).isFalse();
    }

}