package baseball.module;

import baseball.generator.ComputerNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ComputerNumberGeneratorTest {

    public ComputerNumberGenerator gameSession = new ComputerNumberGenerator();

    @Test
    @DisplayName("중복 되지 않은 랜덤한 3자리 수 확인")
    public void computerTest(){
        List<Integer> threeDigitNum= gameSession.makeUniqueNumbers();

        Assertions.assertEquals(3, threeDigitNum.size());

        for (Integer num: threeDigitNum){
            Assertions.assertTrue(num>=0 && num<=9);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(threeDigitNum);
        Assertions.assertEquals(3,uniqueNumbers.size());
    }
}