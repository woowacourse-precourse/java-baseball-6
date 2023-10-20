package baseball.controller;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameControllerTest {

    @DisplayName("String을 Numbers로 변환해주는 기능")
    @Test
    void 사용자_입력값_convert(){
        //given
        GameController controller=new GameController();
        String input="123";

        //when
        Numbers numbers=controller.convertToNumbers(input);

        //then
        assertThat(numbers.splitNumbers()).isEqualTo(input.split(""));
    }

    @DisplayName("재시작여부 입력값의 validate 기능")
    @ParameterizedTest
    @ValueSource(strings={"11","21","1a","a1","a","4","0"})
    void 재시작_입력값_validate(String input){
        //given
        GameController controller=new GameController();

        //when&then
        assertThatThrownBy(()->controller.validateOption(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 따라 게임 재시작여부를 결정하는 기능")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:false"},delimiter = ':')
    void 재시작_기능(String input,boolean expected){
        GameController controller=new GameController();
        assertThat(controller.isContinue(input)).isEqualTo(expected);
    }
}
