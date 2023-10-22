package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

class NumberFactoryTest {

	@DisplayName("pickUniqueNumbersInRange()가 주어진 범위내에서 주어진 크기의 수를 반환한다.")
	@Test
	void testRangeAndNumberSize() {
	    // given
		int startNumber = 1;
		int endNumber = 9;
		int count = 3;

		// when
		List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);

	    // then
		assertThat(randomNumbers).allMatch(number -> number >= 1 && number <= 9);
		assertThat(randomNumbers.size()).isEqualTo(count);
	}

	@DisplayName("pickUniqueNumbersInRange()가 주어진 범위내에서 중복되지 않은 수를 반환한다.")
	@Test
	void testDuplication() {
		// given
		int startNumber = 1;
		int endNumber = 9;
		int count = 3;

		// when
		List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);

		// then
		Long nonDuplicatedNumbersCount = randomNumbers.stream().distinct().count();
		assertThat(nonDuplicatedNumbersCount).isEqualTo(count);
	}

}
