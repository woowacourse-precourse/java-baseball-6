package baseball.domain;

import baseball.constant.BaseballSystemPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("사용자 객체")
class PlayerTest {

    static Stream<Arguments> getProperNumbers() {
        return Stream.of(Arguments.of(List.of(1, 2, 3))
                , Arguments.of(List.of(4, 5, 6))
                , Arguments.of(List.of(7, 8, 9))
                , Arguments.of(List.of(1, 5, 8))
                , Arguments.of(List.of(3, 2, 1))
        );
    }

    @DisplayName("고유한 3자리 숫자로 객체를 생성하는데 성공한다.")
    @ParameterizedTest(name = "[{index}차]시도: randomNumbers: {0}")
    @MethodSource("getProperNumbers")
    void testCreatePlayer(List<Integer> randomNumbers) {
        /// given
        List<Integer> playerNumbers = new ArrayList<>();
        int condition = BaseballSystemPolicy.LIMIT_LENGTH.getCondition();

        // when
        Player player = new Player(randomNumbers);
        for (int index = 0; index < condition; index++) {
            Integer playerNumber = player.getValue(index);
            playerNumbers.add(playerNumber);
        }

        // then
        long uniqueNumberCount = playerNumbers.stream().distinct().count();
        Assertions.assertThat(uniqueNumberCount).isEqualTo(condition);
    }

    @DisplayName("잘못된 데이터를 바탕으로 객체를 생성하면 IllegalArgumentException 이 발생한다.")
    @Nested
    class DomainConstraintViolation {

        static Stream<Arguments> getNonDuplicateNumbers() {
            return Stream.of(Arguments.of(List.of(1, 2, 2))
                    , Arguments.of(List.of(4, 5, 5))
                    , Arguments.of(List.of(7, 7, 9))
                    , Arguments.of(List.of(8, 8, 8))
                    , Arguments.of(List.of(3, 2, 3))
            );
        }

        static Stream<Arguments> getLessThan3orGraterThan3() {
            return Stream.of(Arguments.of(List.of(1, 2))
                    , Arguments.of(List.of(4))
                    , Arguments.of(List.of(7, 7, 9, 9))
                    , Arguments.of(List.of(1, 2, 8, 8, 8))
            );
        }

        static Stream<Arguments> getNotRequirementValue() {
            return Stream.of(Arguments.of(List.of(1, 2, 0))
                    , Arguments.of(List.of(4, 10, 3))
                    , Arguments.of(List.of(7, 9, 10))
                    , Arguments.of(List.of(0, 1, 2))
            );
        }

        @DisplayName("고유하지 않은 데이터를 가지고 객체를 생성하면 IllegalException 이 발생하여 실패한다.")
        @ParameterizedTest(name = "[{index}차]시도: randomNumbers: {0}")
        @MethodSource("getNonDuplicateNumbers")
        void failDuplicateNumbers(List<Integer> nonDuplicateNumbers) {
            //given
            //when
            //then
            Assertions.assertThatThrownBy(() -> new Player(nonDuplicateNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3자리가 아닌 데이터로 객체를 생성하면 IllegalException 이 발생하여 실패한다. ")
        @ParameterizedTest(name = "[{index}차]시도: randomNumbers: {0}")
        @MethodSource("getLessThan3orGraterThan3")
        void failNotSize3(List<Integer> Not3SizeRandomNumbers) {
            //given
            //when
            //then
            Assertions.assertThatThrownBy(() -> new Player(Not3SizeRandomNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("[1~9] 숫자로 이루어지지 않은 데이터로 객체를 생성하면 IllegalException 이 발생하여 실패한다. ")
        @ParameterizedTest(name = "[{index}차]시도: randomNumbers: {0}")
        @MethodSource("getNotRequirementValue")
        void failNotValue(List<Integer> NotRequirementNumbers) {
            //given
            //when
            //then
            Assertions.assertThatThrownBy(() -> new Player(NotRequirementNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


}