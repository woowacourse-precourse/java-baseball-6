package baseball.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserPlayerTest {

    @ParameterizedTest
    @ValueSource(ints = {123, 456, 789, 987})
    void 정상_값_정수_입력(int input) {
        new UserPlayer(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {122, 988, 203})
    void 오류_값_정수_입력(int input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserPlayer(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "987"})
    void 정상_값_문자_입력(String input) {
        new UserPlayer(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "988", "203", "", "a12", "aaa"})
    void 오류_값_문자_입력(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new UserPlayer(input);
        });
    }
}