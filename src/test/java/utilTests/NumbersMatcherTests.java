package utilTests;

import baseball.container.ApplicationContainer;
import baseball.util.matcher.NumbersMatcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumbersMatcherTests {
    private final ApplicationContainer container = new ApplicationContainer();
    private final NumbersMatcher numbersMatcher = container.getNumbersMatcher();

    private List<Integer> targetNumbers;
    private String inputNumbers;

    @BeforeEach
    void beforeEach() {
        targetNumbers = new ArrayList<>();
    }

    @Test
    @DisplayName("볼: 0, 스트라이크: 1")
    void test1() {
        // given
        int[] numbers = {2, 5, 7};

        for (int number : numbers)
            targetNumbers.add(number);

        inputNumbers = "358";

        // when
        String result = numbersMatcher.matches(targetNumbers, inputNumbers);

        // then
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("볼: 3, 스트라이크: 0")
    void test2() {
        // given
        int[] numbers = {3, 5, 8};

        for (int number : numbers)
            targetNumbers.add(number);

        inputNumbers = "835";

        // when
        String result = numbersMatcher.matches(targetNumbers, inputNumbers);

        // then
        assertThat(result).isEqualTo("3볼");
    }

    @Test
    @DisplayName("볼: 1, 스트라이크: 1")
    void test3() {
        // given
        int[] numbers = {1, 2, 3};

        for (int number : numbers)
            targetNumbers.add(number);

        inputNumbers = "329";

        // when
        String result = numbersMatcher.matches(targetNumbers, inputNumbers);

        // then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("볼: 0, 스트라이크: 3")
    void test4() {
        // given
        int[] numbers = {5, 6, 9};

        for (int number : numbers)
            targetNumbers.add(number);

        inputNumbers = "569";

        // when
        String result = numbersMatcher.matches(targetNumbers, inputNumbers);

        // then
        assertThat(result).isEqualTo("3스트라이크");
    }
}
