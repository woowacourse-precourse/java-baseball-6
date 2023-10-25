package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

class DiffNumberRandomGeneratorTest {
    @DisplayName("원하는 길이가 생성되는지 검증")
    @Test
    public void validateLength3() {
        DiffNumberRandomGenerator rg = new DiffNumberRandomGenerator();
        String make = rg.make(3);

        assertThat(make.length()).isEqualTo(3);
    }

    @DisplayName("각 숫자가 1~9 사이 값인지 검증")
    @Test
    public void validateNumber() {
        DiffNumberRandomGenerator rg = new DiffNumberRandomGenerator();
        String make = rg.make(3);

        assertTrue(make.matches("[1-9]+"));
    }

    @DisplayName("각 숫자가 모두 다른 값인지 검증")
    @Test
    public void validateDiffNum() {
        DiffNumberRandomGenerator rg = new DiffNumberRandomGenerator();
        String make = rg.make(3);

        assertNotEquals(make.charAt(0), make.charAt(1));
        assertNotEquals(make.charAt(1), make.charAt(2));
        assertNotEquals(make.charAt(0), make.charAt(2));
    }
}