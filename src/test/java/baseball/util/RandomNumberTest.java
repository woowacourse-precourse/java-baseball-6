package baseball.util;

import baseball.validation.ValidationNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumberTest {
    final RandomUtil randomNumber = RandomUtil.of();
    @Test
    @DisplayName("세자리 랜덤 수 생성 확인")
    public void makeRandomNumbers() throws Exception {
        // when
        List<Integer> computer = randomNumber.getRandomNumber();

        // then
        ValidationNumber.validateNumbers(computer);
    }
}
