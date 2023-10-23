package baseball.service.handler;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer computer = new Computer();

    @Test
    void getRandomNumber() {
        //given
        int start_range = 1;
        int end_range = 9;

        //when
        String result = computer.getRandomNumber(start_range, end_range);

        //then
        assertTrue(result.matches("[1-9]{3}"));
    }


}