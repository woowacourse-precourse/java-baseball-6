package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Nested
    class RandomLibraryTest {
        private final List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        @Test
        void testRandomsLibrary() {
            assertThat(Randoms.pickNumberInList(integers)).isIn(integers);
            assertThat(Randoms.pickNumberInRange(1, 9)).isIn(integers);
            assertThat(Randoms.shuffle(integers)).containsAll(integers);
        }
    }

    @Nested
    class ConsoleLibraryTest {
        @Test
        void testConsoleLibrary() {
            String inputValue = "12345";
            System.setIn(new ByteArrayInputStream(inputValue.getBytes()));
            String readValue = Console.readLine();
            Console.close();

            assertThat(readValue).isEqualTo(inputValue);
        }
    }
}
