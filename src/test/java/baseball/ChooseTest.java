package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ChooseTest extends NsTest {

	@Test
	void 선택숫자_숫자_검사() {
		assertRandomNumberInRangeTest(() ->
						assertThatThrownBy(() -> runException("135", "a"))
								.isInstanceOf(IllegalArgumentException.class),
				1, 3, 5
		);
	}

	@Test
	void 선택숫자_값_검사() {
		assertRandomNumberInRangeTest(() ->
						assertThatThrownBy(() -> runException("135", "5"))
								.isInstanceOf(IllegalArgumentException.class),
				1, 3, 5
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}
