package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class BaseballNumberTest {
    @ParameterizedTest
    @DisplayName("객체 생성 성공 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void newInstanceSuccessTest(int value) {
        assertDoesNotThrow(() -> new BaseballNumber(value));
    }

    @ParameterizedTest
    @DisplayName("객체 생성 실패 테스트 - 범위 벗어남")
    @ValueSource(ints = {-1, 0, 10})
    void newInstanceFailTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(value));
    }

    @ParameterizedTest
    @DisplayName("랜덤 객체 생성 성공 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void randomInstanceSuccessTest(int value) {
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            when(pickNumberInRange(BaseballNumber.START_NUMBER, BaseballNumber.END_NUMBER))
                    .thenReturn(value);
            assertDoesNotThrow(BaseballNumber::createRandomNumber);
        }
    }

    @ParameterizedTest
    @DisplayName("랜덤 객체 생성 실패 테스트 - 범위 벗어남")
    @ValueSource(ints = {-1, 0, 10})
    void randomInstanceFailTest(int value) {
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            when(Randoms.pickNumberInRange(eq(BaseballNumber.START_NUMBER), eq(BaseballNumber.END_NUMBER)))
                    .thenReturn(value);
            assertThrows(IllegalArgumentException.class, BaseballNumber::createRandomNumber);
        }

    }
}