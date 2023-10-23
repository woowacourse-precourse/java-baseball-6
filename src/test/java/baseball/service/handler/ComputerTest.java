package baseball.service.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {


    @Test
    @DisplayName("컴퓨터생성(랜덤수 생성)")
    void 컴퓨터_생성() {
        //given
        int start_range = 1;
        int end_range = 9;
        int number_of_digits = 3;

        //when
        Computer computer = new Computer(start_range, end_range, number_of_digits);
        String result = computer.getComputerNumber();

        //then
        assertTrue(result.matches("[1-9]{3}"));
        int result_size = (Arrays.stream(result.split("")).distinct().toList()).size();
        assertEquals(result_size, number_of_digits);
    }


}