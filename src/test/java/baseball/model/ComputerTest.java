package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 숫자를 생성할 수 있다")
    void createNumbers(){
        List<Integer> numbers = Computer.createNumbers();
        Set<Integer> nonDuplicateNumbers = numbers.stream().collect(Collectors.toSet());
        List<Integer> validNumbersRange = List.of(1,2,3,4,5,6,7,8,9);

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(nonDuplicateNumbers.size()).isEqualTo(3);
        assertThat(validNumbersRange).containsAll(numbers);
    }
}