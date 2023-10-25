package baseball.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("랜덤 숫자 3자리 생성")
    void generateRandomNumber() {
        //given
        List<Integer> randomNumbers = new ArrayList<>();
        Computer computer = new Computer();
        //when
        randomNumbers = computer.generateNumber();
        //then
        Assertions.assertEquals(3, randomNumbers.size());
    }
}