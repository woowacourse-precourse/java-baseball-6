package collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.exception.InvalidTripleSizeException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class TripleTest {

    @DisplayName("같은 타입인 3개 요소로 Triple 생성 가능")
    @Test
    void createTriple() {
        // given
        // when
        final Triple<Integer> intTriple = Triple.of(1, 2, 3);
        final Triple<String> stringTriple = Triple.of("1", "2", "3");

        // then
        assertThat(intTriple)
                .extracting("first", "second", "third")
                .containsExactly(1, 2, 3);

        assertThat(stringTriple)
                .extracting("first", "second", "third")
                .containsExactly("1", "2", "3");
    }

    @DisplayName("size가 3인 Set으로 Triple 생성 가능")
    @Test
    void createTripleWithSetHasThreeElements() {
        // given
        final Set<Integer> input1 = new LinkedHashSet<>(List.of(1, 2, 3));
        final Set<String> input2 = new LinkedHashSet<>(List.of("1", "2", "3"));

        // when
        final Triple<Integer> intTriple = Triple.fromSet(input1);
        final Triple<String> stringTriple = Triple.fromSet(input2);

        // then
        assertThat(intTriple)
                .extracting("first", "second", "third")
                .containsExactly(1, 2, 3);

        assertThat(stringTriple)
                .extracting("first", "second", "third")
                .containsExactly("1", "2", "3");
    }

    @DisplayName("size가 3인 List로 Triple 생성 가능")
    @Test
    void createTripleWithListHasThreeElements() {
        // given
        final List<Integer> input1 = List.of(1, 2, 3);
        final List<String> input2 = List.of("1", "2", "3");

        // when
        final Triple<Integer> intTriple = Triple.fromList(input1);
        final Triple<String> stringTriple = Triple.fromList(input2);

        // then
        assertThat(intTriple)
                .extracting("first", "second", "third")
                .containsExactly(1, 2, 3);

        assertThat(stringTriple)
                .extracting("first", "second", "third")
                .containsExactly("1", "2", "3");
    }

    @DisplayName("size가 3이 아닌 List로 Triple 생성 시 예외 발생")
    @Test
    void createTripleWithListNotHasThreeElements() {
        // given
        final List<Integer> input1 = List.of(1);
        final List<Integer> input2 = List.of(1, 2, 3, 4);

        // when
        // then
        assertThatThrownBy(
                () -> Triple.fromList(input1)
        )
                .isInstanceOf(InvalidTripleSizeException.class)
                .hasMessage(InvalidTripleSizeException.INVALID_TRIPLE_SIZE_MESSAGE);

        assertThatThrownBy(
                () -> Triple.fromList(input2)
        )
                .isInstanceOf(InvalidTripleSizeException.class)
                .hasMessage(InvalidTripleSizeException.INVALID_TRIPLE_SIZE_MESSAGE);
    }

    @DisplayName("size가 3이 아닌 List로 Triple 생성 시 예외 발생")
    @Test
    void ateTripleWithListNotHasThreeElements() {
        // given
        final List<Integer> input1 = List.of(1);
        final List<Integer> input2 = List.of(1, 2, 3, 4);

        // when
        // then
        assertThatThrownBy(
                () -> Triple.fromList(input1)
        )
                .isInstanceOf(InvalidTripleSizeException.class)
                .hasMessage(InvalidTripleSizeException.INVALID_TRIPLE_SIZE_MESSAGE);

        assertThatThrownBy(
                () -> Triple.fromList(input2)
        )
                .isInstanceOf(InvalidTripleSizeException.class)
                .hasMessage(InvalidTripleSizeException.INVALID_TRIPLE_SIZE_MESSAGE);
    }
}