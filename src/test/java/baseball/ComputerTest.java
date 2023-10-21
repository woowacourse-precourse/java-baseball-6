package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {
    private Computer computer;
    @Test
    void 중복되지않는_세자리_숫자를_생성한다(){

        int digitCount = 3;
        computer = new Computer(digitCount);

        // 숫자 리스트는 숫자 세개를 가지고 있다.
        var numberList = computer.getNumberList();
        assertEquals(digitCount,numberList.size());

        // 중복된 숫자가 없어야 한다.
        HashSet<Integer> numberSet = new HashSet<>(numberList);
        assertEquals(digitCount,numberSet.size());


    }

}