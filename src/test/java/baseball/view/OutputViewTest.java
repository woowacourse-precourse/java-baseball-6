package baseball.view;

import baseball.dto.response.GameResultResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private static ByteArrayOutputStream outputStream;
    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("볼과 스트라이크가 없으면 낫싱을 출력한다.")
    public void 낫싱_결과_출력() throws Exception {
        
        // given
        GameResultResponse gameResultResponse = new GameResultResponse(0, 0);

        // when
        OutputView.printResult(gameResultResponse);
        String expect = "낫싱\n";
        
        // then
        assertThat(outputStream.toString()).isEqualTo(expect);
    }

    @Test
    @DisplayName("결과 값과 일치하는 볼, 스트라이크 개수를 출력한다.")
    public void 볼_스트라이크_결과_출력() throws Exception {

        // given
        GameResultResponse gameResultResponse = new GameResultResponse(1, 1);

        // when
        OutputView.printResult(gameResultResponse);
        String expect = gameResultResponse.getBallCount() + "볼" + " " + gameResultResponse.getStrikeCount() + "스트라이크\n";

        // then
        assertThat(outputStream.toString()).isEqualTo(expect);
    }
}