package baseball.game.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.model.dto.RoundResultDto;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("문구_출력_볼")
    public void resultOutputBall() {
        RoundResultDto roundResult = new RoundResultDto(1, 0);
        OutputView outputView = new OutputView();

        outputView.printResult(roundResult);
        assertThat(output()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("문구_출력_스트라이크")
    public void resultOutputStrike() {
        RoundResultDto roundResult = new RoundResultDto(0, 2);
        OutputView outputView = new OutputView();

        outputView.printResult(roundResult);
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("문구_출력_볼_스트라이크")
    public void resultOutputBoth() {
        RoundResultDto roundResult = new RoundResultDto(1, 1);
        OutputView outputView = new OutputView();

        outputView.printResult(roundResult);
        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("문구_출력_낫싱")
    public void resultOutputNothing() {
        RoundResultDto roundResult = new RoundResultDto(0, 0);
        OutputView outputView = new OutputView();

        outputView.printResult(roundResult);
        Assertions.assertThat(output()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("문구_게임종료")
    public void outputGameEnd() {
        OutputView outputView = new OutputView();

        outputView.printGameEnd();
        Assertions.assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}