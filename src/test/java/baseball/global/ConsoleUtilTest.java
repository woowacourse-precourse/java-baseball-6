package baseball.global;

import baseball.global.utils.ConsoleUtil;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConsoleUtilTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@DisplayName("ball, strike 개수에 따라 올바른 출력이 이루어져야 한다.")
	@ParameterizedTest
	@CsvSource({"0,0,낫싱", "1,0,1볼", "2,0,2볼", "3,0,3볼", "0,1,1스트라이크", "0,2,2스트라이크",
			"1,1,1볼 1스트라이크", "2,1,2볼 1스트라이크", "0,3,3스트라이크3개의 숫자를 모두 맞히셨습니다! 게임 종료"})
	void should_output_when_ballAndStrike(int ball, int strike, String output) {
		ConsoleUtil.ballAndStrikeCountOutput(ball, strike);
		Assertions.assertThat(output).isEqualTo(outContent.toString().replaceAll("\n", ""));
	}
}
