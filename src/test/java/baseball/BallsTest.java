package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class BallsTest extends NsTest {

	@Test
	void 숫자_길이_검사() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1524"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 숫자_검사() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1c4"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 숫자_범위_검사() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("609"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 숫자_중복_검사() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("114"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
