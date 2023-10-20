package baseball.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ComputerTest {

    private List<Integer> computerNumbers;

    @BeforeEach
    @DisplayName("객체생성")
    public void getInstance() {
        Computer computer = new Computer();
        computerNumbers = computer.getNumbers();
    }

    @Test
    @DisplayName("Computer객체가 3자리 숫자를 생성하는지 확인")
    public void generateThreeDigitNumberTest() {
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Computer객체가 중복된 숫자를 가지지 않는지 확인")
    public void generateUniqueNumberTest() {
        for (int i = 0; i < computerNumbers.size(); i++) {
            for (int j = i + 1; j < computerNumbers.size(); j++) {
                assertNotEquals(computerNumbers.get(i), computerNumbers.get(j));
            }
        }
    }
}
