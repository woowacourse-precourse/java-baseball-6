package baseball.controller.input;

import baseball.domain.BallsFixture;
import baseball.domain.ball.Balls;
import baseball.domain.result.Result;
import baseball.exception.DuplicateException;
import baseball.exception.OutOfRangeException;
import baseball.exception.WrongInputException;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @BeforeEach
    void consoleClose() {
        Console.close();
    }

    @Test
    @DisplayName("입력이 숫자가 아니면 익셉션 발생")
    void 입력이_숫자가_아니면_익셉션_발생() {
        final byte[] buf = String.join("\n", "abc").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThrows(WrongInputException.class, Input::read);
    }

    @Test
    @DisplayName("입력이 중복되면 익셉션 발생")
    void 입력이_중복되면_익셉션_발생() {
        final byte[] buf = String.join("\n", "112").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThrows(DuplicateException.class, Input::read);
    }

    @Test
    @DisplayName("입력이 3개보다 적으면 올바르지 않으면 익셉션 발생")
    void 입력이_3개보다_적으면_익셉션_발생() {
        final byte[] buf = String.join("\n", "42").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThrows(OutOfRangeException.class, Input::read);
    }

    @Test
    @DisplayName("입력이 3개보다 많으면 올바르지 않으면 익셉션 발생")
    void 입력이_3개보다_많으면_익셉션_발생() {
        final byte[] buf = String.join("\n", "4256").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThrows(OutOfRangeException.class, Input::read);
    }

    @Test
    @DisplayName("사용자의 입력이 모두 일치하면 3 스트라이크 반환")
    void 입력_모두_일치_3스트라이크() {
        final byte[] buf = String.join("\n", "425").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = Input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(3, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 1개 일치하면 1스트라이크 반환")
    void 입력_1개_일치_1스트라이크() {
        final byte[] buf = String.join("\n", "489").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = Input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(1, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 1개가 일치하고, 위치가 다르면 1볼 반환")
    void 입력_1개_일치_위치다름_1볼() {
        final byte[] buf = String.join("\n", "567").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = Input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(0, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 2개가 일치하고, 1개만 위치가 다르면 1스트라이크 1볼 반환")
    void 입력_한개의_값위치동일_한개의_값동일_위치다름_1스트라이크_1볼() {
        final byte[] buf = String.join("\n", "456").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = Input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(1, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 모두다름")
    void 입력_모두_다름() {
        final byte[] buf = String.join("\n", "789").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = Input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(0, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("계속 하는 질문의 1번 선택하면 True가 반환된다.")
    void 계속_할거냐는_질문_1를_넣으면_True() {
        final byte[] buf = String.join("\n", "1").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        boolean isContinue = Input.isContinue();

        assertTrue(isContinue);
    }

    @Test
    @DisplayName("계속 하는 질문의 2번 선택하면 False가 반환된다.")
    void 계속_할거냐는_질문_2를_넣으면_False() {
        final byte[] buf = String.join("\n", "2").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        boolean isContinue = Input.isContinue();

        assertFalse(isContinue);
    }

    @Test
    @DisplayName("계속 하는 질문에 다른 값을 입력하면 익셉션 발생")
    void 계속_할거냐는_질문_잘못된_입력값_익셉션_발생() {
        final byte[] buf = String.join("\n", "abc").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, Input::isContinue);
        assertEquals("잘못된 입력입니다.", e.getMessage());
    }
}