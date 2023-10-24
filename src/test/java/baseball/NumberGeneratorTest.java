package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    private static NumberGenerator generator;

    @BeforeAll
    static void setUp(){
        generator = new NumberGenerator();
    }

    @Test
    @DisplayName("랜덤한 숫자 3개를 생성하는지 테스트")
    void randomNumberSizeTest(){
        List<Integer> randomNumbers = generator.generateNumber();

        assertEquals(3, randomNumbers.size());
    }

    @Test
    @DisplayName("랜덤한 숫자 3개가 중복되지 않는지 테스트")
    void distinctRandomNumberTest(){
        List<Integer> randomNumbers;
        int i = 0;

        for(i = 0; i < 10000000; i++){
            randomNumbers = generator.generateNumber();

            if(isDuplicate(randomNumbers)) break;
        }

        assertEquals(10000000, i);
    }

    @Test
    @DisplayName("중복 검사 함수가 잘 작동하는지 테스트")
    void isDuplicateTest(){
        List<Integer> duplicationList = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> distinctionList = new ArrayList<>(Arrays.asList(1, 2, 3));

        boolean duplication = isDuplicate(duplicationList);
        boolean distinction = isDuplicate(distinctionList);

        assertEquals(duplication, true);
        assertEquals(distinction, false);
    }

    boolean isDuplicate(List<Integer> randomNumbers){
        for(int i = 0; i < randomNumbers.size(); i++){
            for(int k = i + 1; k < randomNumbers.size(); k++){
                if(randomNumbers.get(i) == randomNumbers.get(k)) return true;
            }
        }

        return false;
    }
}