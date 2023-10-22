package process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ValidationNumber;

import java.util.List;

public class RandomNumberTest {
    final RandomNumber randomNumber = RandomNumber.of();
    @Test
    @DisplayName("세자리 랜덤 수 생성 확인")
    public void makeRandomNumbers() throws Exception {
        // when
        List<Integer> computer = randomNumber.getRandomNumber();

        // then
        ValidationNumber.validateNumbers(computer);
    }
}
