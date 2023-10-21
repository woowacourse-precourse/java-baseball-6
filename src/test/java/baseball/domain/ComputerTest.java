package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void ComputerNumbers의_사이즈가_범위를_벗어나면_IllegalArgumentException가_발생한다() {
		List<Integer> computerNumbers = new ArrayList<>();
		computerNumbers.add(1);
		computerNumbers.add(2);
		computerNumbers.add(3);
		computerNumbers.add(4);

		assertThatThrownBy(() -> new Computer(computerNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
