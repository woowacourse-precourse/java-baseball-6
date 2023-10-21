package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberGeneratorTest {
    @DisplayName("입력한 count만큼 랜덤한 값이 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"3,2,7", "5,4,10", "7,1,9"}) // count 만큼 개수를 생성하므로 count < endNum- startNum이 되게 값을 설정해야합니다.
    void 입력한_값만큼_생성(int count, int startNum, int endNum) {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers(count, startNum, endNum);
        Assertions.assertThat(randomNumbers.size()).isEqualTo(count);
    }

    @DisplayName("startNum이상 endNum이하의 값이 생성되어야합니다.")
    @ParameterizedTest
    @CsvSource(value = {"3,2,7", "5,4,10", "7,1,9"})
    void 입력값_범위_테스트(int count, int startNum, int endNum) {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers(count, startNum, endNum);

        boolean notOutOfRange = randomNumbers.stream()
                .filter(value -> value < startNum || value > endNum)
                .findAny()
                .isEmpty();

        Assertions.assertThat(notOutOfRange).isTrue();
    }
}