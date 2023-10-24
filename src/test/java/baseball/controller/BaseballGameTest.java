package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    // 콘솔 출력 값 확인용 스트림 변수
    private static ByteArrayOutputStream outputStreamCaptor;
    private BaseballGame baseballGame;

    @BeforeEach
    public void reset() {
        baseballGame = new BaseballGame();

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("gameStart() 테스트")
    void testGameStartMessage() {
        baseballGame.gameStart();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("Retry 테스트")
    void testYesRetry() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(baseballGame.retryCheck()).isTrue();
    }

    @Test
    @DisplayName("NoRetry 테스트")
    void testNoRetry() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(baseballGame.retryCheck()).isFalse();
    }

    @Test
    @DisplayName("Retry IllegalArgumentException 예외 테스트")
    void testRetryIllegalArgumentException() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> baseballGame.retryCheck())
                .isInstanceOf(IllegalArgumentException.class);
    }
}