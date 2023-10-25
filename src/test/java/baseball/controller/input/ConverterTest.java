package baseball.controller.input;

import baseball.domain.BallsFixture;
import baseball.domain.ball.Balls;
import baseball.domain.result.Result;
import baseball.exception.DuplicateException;
import baseball.exception.OutOfRangeException;
import baseball.exception.WrongInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    @DisplayName("String을 Balls로 반환 성공 해야 한다.")
    void 컨버팅_성공() {
        Balls convertBall = Converter.convert("425");

        Balls balls = BallsFixture.fixture().build(); //425

        Result result = convertBall.compare(balls);

        assertEquals(3, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("길이가 3 미만이면 익셉션 발생")
    void 길이가_3미만이면_익셉션_발생() {
        assertThrows(OutOfRangeException.class, () -> Converter.convert("12"));
    }

    @Test
    @DisplayName("길이가 3 초과이면 익셉션 발생")
    void 길이가_3초과이면_익셉션_발생() {
        assertThrows(OutOfRangeException.class, () -> Converter.convert("1234"));
    }

    @Test
    @DisplayName("숫자가 아니면 익셉션 발생")
    void 숫자가_아니면_익셉션_발생() {
        assertThrows(WrongInputException.class, () -> Converter.convert("abc"));
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 익셉션 발생")
    void 중복된_숫자_익셉션_발생() {
        assertThrows(DuplicateException.class, () -> Converter.convert("111"));
    }
}