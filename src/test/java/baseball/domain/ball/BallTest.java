package baseball.domain.ball;

import baseball.exception.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @Test
    @DisplayName("Ball은 조건이 맞으면 정상 생성 되어야 한다.")
    void Ball_정상_생성() {
        int value = 1;
        Ball ball = new Ball(value);

        assertNotNull(ball);
    }

    @Test
    @DisplayName("Ball은 minRange 미만으로 설정될 수 없다.")
    void Ball은_minRange_미만이면_익셉션_발생() {
        int value = 0;
        assertThrows(OutOfRangeException.class, () -> new Ball(value));
    }

    @Test
    @DisplayName("Ball은 maxRange 초과로 설정될 수 없다.")
    void Ball은_minRange_초과이면_익셉션_발생() {
        int value = 10;
        assertThrows(OutOfRangeException.class, () -> new Ball(value));
    }

    @Test
    @DisplayName("동일한 Ball의 equals는 True이다.")
    void 동일한_값을_가진_Ball의_equals는_True() {
        int value = 1;
        Ball origin = new Ball(value);

        boolean equals = origin.equals(origin);

        assertTrue(equals);
    }

    @Test
    @DisplayName("같은 값을 가진 Ball의 equals는 True이다.")
    void 같은_값을_가진_Ball의_equals는_True() {
        int value = 1;
        Ball origin = new Ball(value);
        Ball target = new Ball(value);

        boolean equals = origin.equals(target);

        assertTrue(equals);
    }

    @Test
    @DisplayName("다른 값을 가진 Ball의 equals는 False이다.")
    void 다른_값을_가진_Ball의_equals는_False() {
        int originValue = 1;
        int targetValue = 2;
        Ball origin = new Ball(originValue);
        Ball target = new Ball(targetValue);

        boolean equals = origin.equals(target);

        assertFalse(equals);
    }

    @Test
    @DisplayName("Null을 가진 Ball의 equals는 False이다.")
    void Null_값을_가진_Ball의_equals는_False() {
        int originValue = 1;
        Ball origin = new Ball(originValue);
        Ball target = null;

        boolean equals = origin.equals(target);

        assertFalse(equals);
    }

    @Test
    @DisplayName("같은 값을 가진 Ball의 HashCode는 같다.")
    void 같은_값을_가진_Ball의_HashCode는_같다() {
        int value = 1;
        Ball origin = new Ball(value);
        Ball target = new Ball(value);

        assertEquals(origin.hashCode(), target.hashCode());
    }

    @Test
    @DisplayName("다른 값을 가진 Ball의 HashCode는 다르다.")
    void 다른_값을_가진_Ball의_HashCode는_다르다() {
        int originValue = 1;
        int targetValue = 2;
        Ball origin = new Ball(originValue);
        Ball target = new Ball(targetValue);

        assertNotEquals(origin.hashCode(), target.hashCode());
    }
}