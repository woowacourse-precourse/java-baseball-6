package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void 세자리_숫자_생성() {
        Computer computer = new Computer();

        List<Integer> answer = computer.createAnswer();

        assertEquals(3, answer.size());
    }
}