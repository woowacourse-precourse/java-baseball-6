package baseball;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    final int SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    User user = new User();

    @Test
    void userTest() {
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        user.inputNumbers();
        List<Integer> numbers = user.getNumbers();

        Assertions.assertThat(numbers.size()).isEqualTo(SIZE);
        for (Integer number : numbers) {
            Assertions.assertThat(number).isInstanceOf(Integer.class);
        }
        for (Integer number : numbers) {
            Assertions.assertThat(number).isBetween(START_INCLUSIVE, END_INCLUSIVE);
        }
        Set<Integer> duplicate = new HashSet<>(numbers);
        Assertions.assertThat(duplicate.size()).isEqualTo(SIZE);
    }

    @Test
    void duplicateTest() {
        String input = "112";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> {
            user.inputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nonCharacterTest() {
        String input = "a34";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> {
            user.inputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void incorrectSizeTest() {
        String input = "12345";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(() -> {
            user.inputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}