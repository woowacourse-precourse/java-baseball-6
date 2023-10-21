package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import camp.nextstep.edu.missionutils.test.NsTest;

public class OutputViewTest extends NsTest {

	@DisplayName("볼과 스트라이크의 출력결과를 확인한다.")
	@MethodSource("createCheckPrintResultTestValue")
	@ParameterizedTest
	void checkPrintResult(int ballCount, int strikeCount, String message) {
		OutputView outputView = new OutputView();
		
		outputView.printResult(ballCount, strikeCount);
		
		assertThat(output()).contains(message);
	}

	static Stream<Arguments> createCheckPrintResultTestValue() {
		return Stream.of(Arguments.of(0, 0, "낫싱"), Arguments.of(1, 1, "1볼 1스트라이크"), 
					Arguments.of(0, 1, "1스트라이크"), Arguments.of(2, 1, "2볼 1스트라이크"), 
					Arguments.of(0, 3, "3스트라이크"));
	}

	@Override
	protected void runMain() {
		// TODO Auto-generated method stub

	}
}
