package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void numberTest(){
        Numbers  numbers = new Numbers();
        List<Integer> test = numbers.makeRandomNumbers();
        assertEquals(3, test.size());

        for(int num : test){
            assertTrue(num >= 1 && num <= 9);
        }

        Set<Integer> uniqueTest = new HashSet<>(test);
        assertEquals(3, uniqueTest.size());

    }
}
