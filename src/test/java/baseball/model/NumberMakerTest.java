package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberMakerTest {

    NumberMaker numberMaker = new NumberMaker();

    @DisplayName("서로 다른 3자리의 수를 만든다.")
    @Test
    void makeUniqueThreeNumbers() {
        List<Integer> numbers = numberMaker.makeAutoNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers).hasSize(3);
    }
}
