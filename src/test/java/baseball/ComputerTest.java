package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer = new Computer();

    @Test
    void createRandomNumsTest() {
        computer.createRandomNums(3);
        List<Integer> randomNums = computer.getNums();
        assertThat(randomNums.size()).isEqualTo(3);
        assertThat(randomNums.stream().distinct().count()).isEqualTo(3);
        assertThat(randomNums.stream().filter(num -> num >= 1 && num <= 9).count()).isEqualTo(3);
    }


}