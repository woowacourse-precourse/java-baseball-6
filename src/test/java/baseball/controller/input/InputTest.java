package baseball.controller.input;

import baseball.domain.BallsFixture;
import baseball.domain.ball.Balls;
import baseball.domain.result.Result;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @BeforeEach
    void consoleClose(){
        Console.close();
    }

    @Test
    @DisplayName("입력이 숫자가 아니면 익셉션 발생")
    void 입력이_숫자가_아니면_익셉션_발생() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "abc").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, input::read);

        assertEquals("숫자만 입력해주세요.", e.getMessage());
    }

    @Test
    @DisplayName("입력이 중복되면 익셉션 발생")
    void 입력이_중복되면_익셉션_발생() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "112").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, input::read);

        assertEquals("중복된 숫자가 있습니다.", e.getMessage());
    }

    @Test
    @DisplayName("입력이 3개보다 적으면 올바르지 않으면 익셉션 발생")
    void 입력이_3개보다_적으면_익셉션_발생() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "42").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, input::read);

        assertEquals("입력된 숫자가3개 미만입니다.", e.getMessage());
    }

    @Test
    @DisplayName("입력이 3개보다 많으면 올바르지 않으면 익셉션 발생")
    void 입력이_3개보다_많으면_익셉션_발생() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "4256").getBytes();
        System.setIn(new ByteArrayInputStream(buf));


        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, input::read);

        assertEquals("입력된 숫자가3개 초과입니다.", e.getMessage());
    }

    @Test
    @DisplayName("사용자의 입력이 모두 일치하면 3 스트라이크 반환")
    void 입력_모두_일치_3스트라이크() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "425").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(3, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 1개 일치하면 1스트라이크 반환")
    void 입력_1개_일치_1스트라이크() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "489").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(1, result.strike());
        assertEquals(0, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 1개가 일치하고, 위치가 다르면 1볼 반환")
    void 입력_1개_일치_위치다름_1볼() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "567").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(0, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 2개가 일치하고, 1개만 위치가 다르면 1스트라이크 1볼 반환")
    void 입력_한개의_값위치동일_한개의_값동일_위치다름_1스트라이크_1볼() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "456").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(1, result.strike());
        assertEquals(1, result.ball());
    }

    @Test
    @DisplayName("사용자의 입력이 모두다름")
    void 입력_모두_다름() {
        Input input = new Input();
        final byte[] buf = String.join("\n", "789").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Balls ballsFixture = BallsFixture.fixture().build();

        Balls inputBalls = input.read();

        Result result = inputBalls.compare(ballsFixture);

        assertEquals(0, result.strike());
        assertEquals(0, result.ball());
    }
}