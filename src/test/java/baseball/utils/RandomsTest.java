package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsTest {

	@Test
	@DisplayName("pickNumberInList 메서드는 비어있는 List 타입의 객체가 들어오면 IllegalArgumentException을 발생시킨다.")
	void pickNumberInListTest_IAE() {
		//given
		final List<Integer> emptyList = Collections.emptyList();

		//expected
		assertThatThrownBy(() -> Randoms.pickNumberInList(emptyList))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("numbers cannot be empty.");
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	@DisplayName("pickNumberInRange 메서드의 반환 값은 인자 값은 정수형 기준으로 올바른 값을 넘겼다면 endInclusive 보다 항상 1이 작다")
	void pickNumberInRange(final int endInclusive) {
		//given
		final int result = Randoms.pickNumberInRange(0, endInclusive);

		//expected
		assertThat(result).isLessThan(3);
	}

	@Test
	@DisplayName("pickNumberInList 메서드는 인자 값을 null로 받았을 때 처리하지 못하고 NPE가 발생한다.")
	void pickNumberInListTest_NPE() {
		//given
		@SuppressWarnings("DataFlowIssue") final ThrowingCallable nullArgumentCalling = () -> Randoms.pickNumberInList(
			null);

		//expected
		assertThatThrownBy(nullArgumentCalling)
			.isInstanceOf(NullPointerException.class);
	}

	@ParameterizedTest
	@MethodSource("thrownBy")
	@DisplayName("""
			pickNumberInRange 메서드는 begin 값이 endInclusive 보다 크거나,
			endInclusive 값 혹은 begin ~ endInclusive의 범위가 int로 표현 가능한 값 보다 클 경우
			IllegalArgumentException이 발생한다.
		""")
	void pickNumberInRangeTest(final Case testCase) {
		//given
		final ThrowingCallable wrongArgumentCalling = () -> Randoms.pickNumberInRange(
			testCase.begin(),
			testCase.endInclusive()
		);

		//expected
		assertThatThrownBy(wrongArgumentCalling)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(testCase.throwCause());
	}

	private static Stream<Arguments> thrownBy() {
		return Stream.of(
			Arguments.of(new Case(2, 1, "startInclusive cannot be greater than endInclusive.")),
			Arguments.of(new Case(1, 0x7fffffff, "endInclusive cannot be greater than Integer.MAX_VALUE.")),
			Arguments.of(new Case(-1, 0x7fffffff - 1, "the input range is too large."))
		);
	}

	private record Case(int begin, int endInclusive, String throwCause) {
	}

}
