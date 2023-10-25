package baseball.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static baseball.factory.NumberFactory.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("NumberFactory 테스트")
public class NumberFactoryTest {
    @Nested
    @DisplayName("게임에서 사용할 숫자를 생성한다")
    public class getRandomNumberTest {
        @Test
        @DisplayName("무작위의 3자리 수를 생성하는데에 성공한다")
        public void successGetRandomNumber() {
            String randomNumber = getRandomNumber();
            String otherNumber = getRandomNumber();

            Assertions.assertAll(
                    () -> assertThat(randomNumber.length()).isEqualTo(3),
                    () -> assertThat(randomNumber).isNotBlank(),
                    () -> assertThat(randomNumber).isNotEmpty(),
                    () -> assertThat(randomNumber).isNotNull(),
                    () -> assertThat(randomNumber).isNotEqualTo(otherNumber)
            );
        }
    }
}
