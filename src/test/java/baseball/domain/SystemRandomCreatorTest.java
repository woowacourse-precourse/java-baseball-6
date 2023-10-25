package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SystemRandomCreator 클래스")
class SystemRandomCreatorTest {

    private final SystemRandomCreator randomCreator = SystemRandomCreator.getInstance();

    @Test
    void 올바른_범위_내의_숫자를_생성하는지_확인() {
        int randomNumber = randomCreator.createRandomNumber();

        assertTrue(randomNumber >= SystemRandomCreator.MIN_NUMBER
            && randomNumber <= SystemRandomCreator.MAX_NUMBER);
    }
}