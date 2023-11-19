package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComputerGeneratorTest {
    private ComputerGenerator computerGenerator;

    @BeforeEach
    void set() {
        computerGenerator = new ComputerGenerator();
    }

    @DisplayName("컴퓨터가 3자리 인지 검증")
    @ParameterizedTest
    @CsvSource(value = {"3,true", "4,false", "2,false"})
    void validateComputerSize(int size, boolean isValid) {
        List<Integer> computerNumbers = computerGenerator.createNumber();

        boolean actual = computerNumbers.size() == size;
        boolean expected = isValid;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
