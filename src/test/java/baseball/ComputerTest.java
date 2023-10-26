package baseball;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;
    private List<Integer> generated;

    @BeforeEach
    public void given() {
        computer = new Computer();
        generated = computer.generateComputer();
    }

    @Test
    @DisplayName("컴퓨터 랜덤수 생성 테스트")
    public void testGenerateComputer(){

        //when
        int expect = 3;
        int actual = generated.size();

        //then
        assertEquals(expect, actual);
    }

    @Test
    @DisplayName("랜덤수 유효 숫자인지 테스트")
    public void testValidComputer(){
        //then
        for (int index: generated) {
            assertTrue(index >= 1 && index <= 9);
        }
    }

    @Test
    @DisplayName("랜덤수 중복이 있는지 테스트")
    public void testDuplicate(){

        //when
        HashSet<Integer> deDuplicated = new HashSet<>(generated);
        //then
        assertEquals(generated.size(), deDuplicated.size());
    }

}