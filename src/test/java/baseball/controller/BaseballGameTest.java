package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    @DisplayName("gameStart() 테스트")
    void testGameStartMessage() {
        baseballGame.gameStart();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }
}