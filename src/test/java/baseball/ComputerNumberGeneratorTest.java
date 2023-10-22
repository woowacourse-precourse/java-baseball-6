package baseball;

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

        Assertions.assertEquals(3, threeDigitNum.size()); //세 자리 수인지

        for (Integer num: threeDigitNum){ //각 숫자가 0~9인지
            Assertions.assertTrue(num>=0 && num<=9);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(threeDigitNum); //각 숫자가 중복이 없는지
        Assertions.assertEquals(3,uniqueNumbers.size());
    }
}