package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BaseballNumberCreatorTest {

    @RepeatedTest(10)
    @DisplayName("1 ~ 9 사이 수가 생성되는지 확인하는 테스트")
    void create() {
        // given
        NumberCreator numberCreator = new BaseballNumberCreator();

        // when
        int actual = numberCreator.create();

        // then
        assertTrue(1 <= actual && actual <= 9);
    }
}