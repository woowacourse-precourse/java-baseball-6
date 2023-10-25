package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerNumbersTest {
    @Test
    public void 랜덤숫자_테스트(){
        //given
        ComputerNumbers computerNumbers = new ComputerNumbers();
        //then
        Assertions.assertNotEquals(computerNumbers.numbers[0].number,computerNumbers.numbers[1].number);
        Assertions.assertNotEquals(computerNumbers.numbers[0].number,computerNumbers.numbers[2].number);
        Assertions.assertNotEquals(computerNumbers.numbers[2].number,computerNumbers.numbers[1].number);
        Assertions.assertTrue(computerNumbers.numbers[0].number<10 &&0<computerNumbers.numbers[0].number);
        Assertions.assertTrue(computerNumbers.numbers[0].number<10 && 0<computerNumbers.numbers[0].number);
        Assertions.assertTrue(computerNumbers.numbers[0].number<10 && 0<computerNumbers.numbers[0].number);
    }
}