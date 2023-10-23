package baseball.domain;

import baseball.util.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    private RandomNumber randomNumber;

    @BeforeEach
    void setup() {
        RandomNumber randomNumber = RandomNumber.create(RandomNumberGenerator.generate());
    }

    @Test
    @DisplayName("랜덤 넘버 ")
    void randomNumberLengthTest() {

    }
}