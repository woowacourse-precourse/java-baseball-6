package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


class ComputerTest {
    @Test
    public void selectNumbersDuplicatedTest(){
        Computer computer = new Computer();

        List<Integer> numbers = computer.selectNumbers();
        Set<Integer> validateDuplication = new HashSet<>(numbers);

        Assertions.assertThat(validateDuplication.size()).isEqualTo(numbers.size());
    }


}