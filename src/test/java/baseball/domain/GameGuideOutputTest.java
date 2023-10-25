package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameGuideOutputTest {

    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        PrintStream standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void startGame() {
        GameGuideOutput.startGame();
        assertEquals("숫자 야구 게임을 시작합니다.", captor.toString().trim());
    }

    @Test
    void inputBaseBall() {
        GameGuideOutput.inputBaseBall();
        assertEquals("숫자를 입력해주세요 : ", captor.toString());
    }

    @Test
    void gameEnd() {
        GameGuideOutput.gameEnd();
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", captor.toString().trim());
    }
}