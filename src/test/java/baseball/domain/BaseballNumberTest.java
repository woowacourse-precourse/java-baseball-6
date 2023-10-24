package baseball.domain;

import baseball.util.BaseballNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballNumberTest {

    private final BaseballNumberGenerator generator = new BaseballNumberGenerator();

    @DisplayName("야구 게임에 사용되는 세자리 숫자 생성 테스트")
    @Test
    public void 야구_게임에_사용되는_세자리_숫자_생성_저장() {
        assertDoesNotThrow(generator::generate);
    }

    @DisplayName("서로 같은 숫자 생성시 테스트")
    @Test
    public void 서로_같은_숫자_생성_저장() {
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(1, 1, 3));
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(2, 2, 2));
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(1, 3, 3));
    }

    @DisplayName("1~9 범위 밖의 숫자 생성시 테스트")
    @Test
    public void 범위_밖의_숫자_생성_저장() {
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(0, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(1, 10, 3));
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(1, 2, -1));
    }

}

