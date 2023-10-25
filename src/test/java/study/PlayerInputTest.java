package study;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.Application;
import baseball.validation.GameRestartNumberValidator;
import camp.nextstep.edu.missionutils.test.NsTest;

public class PlayerInputTest extends NsTest {
	GameRestartNumberValidator gameRestartNumberValidator = new GameRestartNumberValidator();

	@Test
	void 예외_테스트_숫자_3자리_아닐떄() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("12"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외_테스트_숫자_0_있을때() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("120"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 사용자_답변_유효성_검사_1또는2_아닐때() {
		String playerAnswer = "3";

		Throwable throwable = catchThrowable(() -> {
			gameRestartNumberValidator.checkRestartNumberValidity(playerAnswer);
		});

		assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 예외_테스트_숫자_반복_있을때() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("122"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
