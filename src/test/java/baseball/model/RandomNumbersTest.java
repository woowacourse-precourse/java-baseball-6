package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {

    RandomNumbers randomNumbers = new RandomNumbers();
    List<Number> generatedNumbers = randomNumbers.getRandomNumbers();

    @Test
    @DisplayName("3개의 랜덤 숫자가 만들어져야 한다.")
    public void is_RandumNumber_Size_3() {
        assertEquals(3, generatedNumbers.size());
    }

    @Test
    @DisplayName("랜덤 숫자들은 중복되지 않아야 한다.")
    public void randomNumbers_Should_Not_Contain_Duplicates() {
        assertEquals(generatedNumbers.size(), generatedNumbers.stream().distinct().count());
    }
    
}