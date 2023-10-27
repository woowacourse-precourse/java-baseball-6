package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @DisplayName("랜덤 숫자의 길이가 3인지 테스트")
    @Test
    void isLengthThree() {
        //given
        String validBaseballNum = Computer.createValidBaseballNum();
        //when
        //then
        assertThat(validBaseballNum.length()).isEqualTo(3);
    }


}