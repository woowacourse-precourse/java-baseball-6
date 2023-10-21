package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.domain.BaseballNumber;

public class BaseballCheckAnswerServiceTest {

	@DisplayName("볼의 개수를 확인한다.")
	@MethodSource("createCheckBallCountTestValue")
	@ParameterizedTest
	void checkBallCount(int number, int count) {
		BaseballNumber baseballNumber = new BaseballNumber(List.of(1, 2, 3));
		BaseballCheckAnswerService service = new BaseballCheckAnswerService();
		int answer = service.getBallCount(baseballNumber, number);

		assertEquals(answer, count, "[ERROR] 값이 서로 다릅니다.");
	}
	
	@DisplayName("스트라이크의 개수를 확인한다.")
	@MethodSource("createCheckStrikeCountTestValue")
	@ParameterizedTest
	void checkStrikeCount(int number, int count) {
		BaseballNumber baseballNumber = new BaseballNumber(List.of(1, 2, 3));
		BaseballCheckAnswerService service = new BaseballCheckAnswerService();
		int answer = service.getStrikeCount(baseballNumber, number);

		assertEquals(answer, count, "[ERROR] 값이 서로 다릅니다.");
	}

	static Stream<Arguments> createCheckBallCountTestValue() {
		return Stream.of(Arguments.of(312, 3), Arguments.of(234, 2), Arguments.of(671, 1),
					Arguments.of(789, 0), Arguments.of(321, 2));
	}
	
	static Stream<Arguments> createCheckStrikeCountTestValue() {
		return Stream.of(Arguments.of(123, 3), Arguments.of(156, 1), Arguments.of(127, 2),
					Arguments.of(312, 0), Arguments.of(832, 0));
	}
}
