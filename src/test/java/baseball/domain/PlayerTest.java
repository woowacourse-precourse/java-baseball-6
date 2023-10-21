package baseball.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {
    private Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    private static Stream<Arguments> provideConvertTestCases() {
        return Stream.of(Arguments.of("123", List.of(1, 2, 3)),
                Arguments.of("824", List.of(8, 2, 4)),
                Arguments.of("987", List.of(9, 8, 7)),
                Arguments.of("369", List.of(3, 6, 9)));
    }

    @ParameterizedTest
    @DisplayName("숫자 문자열 리스트 변환 테스트")
    @MethodSource("provideConvertTestCases")
    public void convertToIntegerListTest(String number, List<Integer> expectedNumberList) {
        Assertions.assertThat(player.convertToIntegerList(number)).isEqualTo(expectedNumberList);
    }
}