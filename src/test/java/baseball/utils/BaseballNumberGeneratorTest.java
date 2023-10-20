package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("[Baseball Generator]")
class BaseballNumberGeneratorTest {

    private static List<Integer> BASEBALL_NUMBER_RANGE_LIST = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private List<Integer> baseball;

    @BeforeEach
    void generateBaseball() {
        this.baseball = BaseballNumberGenerator.generate();
    }

    @RepeatedTest(1000)
    @DisplayName("3 자리 수 숫자를 생성 - 3자리 인지 여부")
    public void generateRandomBaseballNumber_LengthTest() {
        assertThat(this.baseball.size()).isEqualTo(3);
    }

    @RepeatedTest(1000)
    @DisplayName("3 자리 수 숫자를 생성 - 중복된 값 여부 확인")
    public void generateRandomBaseballNumber_ContainsNumberTest() {
        final Set<Integer> duplicateChecklist = new HashSet<>(this.baseball);
        assertThat(this.baseball.size()).isEqualTo(duplicateChecklist.size());
    }

    @RepeatedTest(1000)
    @DisplayName("3 자리 수 숫자를 생성 - 생성된 숫자가 범위내에 존재하는지 확인")
    public void generateRandomBaseballNumber_WithinRange() {
        for (Integer number : this.baseball) {
            Assertions.assertTrue(BASEBALL_NUMBER_RANGE_LIST.contains(number));
        }
    }
}