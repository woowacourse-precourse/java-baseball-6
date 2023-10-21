package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @DisplayName("최초 게임 시작시 숫자 야구 게임을 시작합니다. 문구를 출력한다.")
    @Test
    void startGameTest() {
        OutputView.startGame();
        assertThat(output.toString()).isEqualTo("숫자 야구 게임을 시작합니다.\n");
    }

    @DisplayName("3스트라이크시 3개의 숫자를 모두 맞히셨습니다! 게임종료 문구를 출력한다.")
    @Test
    void endGameTest() {
        OutputView.endGame();
        assertThat(output.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임종료\n");
    }
}
