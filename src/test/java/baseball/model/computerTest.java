package baseball.model;

import baseball.utils.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class computerTest {

    @DisplayName("서로 다른 세 가지 수 생성 - 컴퓨터")
    @Test
    public void randomNumber_test() throws Exception {
        //given
        // generator로 랜덤 생성하는 수 주입
        NumberGenerator numberGenerator = new NumberGenerator() {
            private final Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
            @Override
            public int generateNumberInRange(int min, int max) {
                return iterator.next();
            }
        };

        computer computer = new computer(numberGenerator);
        //when
        computer.generate();

        List<Integer> generatedNumbers = computer.getComNumber();
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);

        //then
        assertEquals(expectedNumbers.size(), generatedNumbers.size());

        for (Integer num : expectedNumbers){
            assertTrue(generatedNumbers.contains(num));
        }
     } 
  
}