package baseball.controller;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
