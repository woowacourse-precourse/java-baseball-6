package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    static ByteArrayOutputStream outContent;

    @BeforeEach
    void beforeEach() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("이닝 종료 시 안내 문구가 출력된다.")
    public void 이닝_종료시_안내_문구가_출력된다() {
        // given
        Game game = new Game();

        // when
        game.checkRestart();

        // then
        String expectedOutput = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + "\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }
}
