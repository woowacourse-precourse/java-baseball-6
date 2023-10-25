package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void strike3() {
        Computer computer = new Computer();
        int[] randomNumberArray = computer.getNumberArray();
        String randomNumberString = Arrays.stream(randomNumberArray)
                .mapToObj(randomNumber -> String.valueOf(randomNumber))
                .collect(Collectors.joining());

        Result result = computer.check(randomNumberString);
        assertThat(result.print()).isEqualTo("3스트라이크");
    }

    @Test
    void ball() {
        Computer computer = new Computer();
        int[] randomNumberArray = computer.getNumberArray();
        String randomNumberString = "00" + randomNumberArray[0];

        Result result = computer.check(randomNumberString);
        assertThat(result.print()).isEqualTo("1볼");
    }

    @Test
    void ballAndStrike() {
        Computer computer = new Computer();
        int[] randomNumberArray = computer.getNumberArray();
        String randomNumberString = "0" + randomNumberArray[0] + randomNumberArray[2];

        Result result = computer.check(randomNumberString);
        assertThat(result.print()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void nothing() {
        Computer computer = new Computer();
        String randomNumberString = "000";

        Result result = computer.check(randomNumberString);
        assertThat(result.print()).isEqualTo("낫싱");
    }
}
