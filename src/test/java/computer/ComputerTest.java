package computer;

import baseball.Balls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터 숫자가 정상적으로 만들어지는지 테스트")
    void 컴퓨터_숫자(){
        //given
        Computer computer=new Computer();

        //when


        //then
        Assertions.assertThatCode(()->computer.makeComputerNumber())
                .doesNotThrowAnyException();
    }

}