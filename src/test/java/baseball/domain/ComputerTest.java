package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ComputerTest {


    @Test
    @DisplayName("상대방 서로 다른 랜덤 수 생성 - 성공")
    public void initComputerBaseBallNumberSuccess() throws Exception{
        //given
        Computer computer = new Computer();

        //when
        computer.initComputerBaseBallNumber();

        //then
        Assertions.assertThat(3).isEqualTo(Arrays.stream(computer.getBaseballNumber().toArray()).distinct().count());

    }
}
