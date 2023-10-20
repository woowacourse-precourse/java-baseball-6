package computer;

import baseball.Balls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터 수 유효성 검사")
    void 컴퓨터_숫자(){
        //given
        Computer computer=new Computer();

        //when


        //then
        Assertions.assertThatCode(()->computer.makeComputerNumber())
                .doesNotThrowAnyException();
    }

}