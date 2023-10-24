package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("플레이어로부터 서로 다른 3자리의 수를 입력 받는다.")
    @Test
    void setPlayerNumber() throws Exception{
        //given
        Player player = new Player("123");

        //when //then
        assertThat(player.getPlayerNumber()).isEqualTo("123");
    }

    @DisplayName("플레이어는 유효한 수(3자리의 수)의 범위를 입력해야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","12","1234"})
    void setPlayerNumberLengthCorrect(String playerNumber) throws Exception{
        //given parameter

        // when // then
        assertSimpleTest(() ->
                    assertThatThrownBy(() -> new Player(playerNumber))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("잘못된 값을 입력하셨습니다.(입력값 3자리수)")
                );
    }

    @DisplayName("각 자리수가 1부터 9까지의 숫자가 아닌경우")
    @ParameterizedTest
    @ValueSource(strings = {"0z3","-11","z12","#$#"})
    void setPlayerNumberIsDigitCharInString(String playerNumber) throws Exception{
        //given parameter

        //when //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Player(playerNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 값을 입력하셨습니다.(자연수가 아닌 수가 존재합니다.)")
        );
    }

    @DisplayName("각 자리 수의 숫자가 중복된 값이 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"122","333"})
    void setPlayerNumberIsDifferent(String playerNumber) throws Exception{
        //given parameter

        //when //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Player(playerNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 값을 입력하셨습니다.(중복된 숫자가 존재합니다.)")
        );
    }

}