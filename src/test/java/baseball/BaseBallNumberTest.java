package baseball;


import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.BaseBallNumber;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseBallNumber 관련 테스트")
class BaseBallNumberTest {


    @ParameterizedTest(name = "{0} 실패, 값 : {1}")
    @MethodSource("inValidNumberArray")
    @DisplayName("잘못된 사용자 입력이 들어온 경우 BaseBallNumber 생성 실패 테스트")
    void generateNumber_InvalidInputString_ThrownException(String reason, String inputNumber) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> BaseBallNumber.generateNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("제대로된 사용자 입력이 왔을 때 BaseBallNumber 생성 성공 테스트")
    void generateNumber_ValidInputString_Success() {
        // given
        // when
        BaseBallNumber baseBallNumber = BaseBallNumber.generateNumber("123");

        // then
        assertThat(baseBallNumber.getBaseBallNumberCount()).isEqualTo(3);
    }

    @RepeatedTest(500)
    @DisplayName("1 ~ 9 사이의 서로 다른 임의의수가 만들어 지는지 테스트")
    void generateRandomNumbers_Success() {
        // given
        Set<Integer> numberSet = new HashSet<>();

        // when
        BaseBallNumber baseBallNumber = BaseBallNumber.generateRandomNumbers();
        int[] numbers = baseBallNumber.getNumbers();
        for(int number : numbers) {
            numberSet.add(number);
        }

        // then
        assertThat(baseBallNumber.getBaseBallNumberCount()).isEqualTo(3);
        assertThat(Arrays.stream(numbers).allMatch(number -> number >= 1 && number <= 9)).isTrue();
        assertThat(numberSet).hasSize(3);
    }

    @ParameterizedTest(name = "입력값 = {0} ->  {1} 스트라이크 {2} 볼")
    @MethodSource("InputStringStream")
    @DisplayName("두 BaseBallNumber 간의 strike와 ball에 대한 계산이 제대로 이루어지는지 확인하는 테스트")
    void compare_Success(String inputString, int strikeCount, int ballCount) {
        // given
        BaseBallNumber computerNumber = BaseBallNumber.generateNumber("123");
        AtomicInteger strike = new AtomicInteger(0);
        AtomicInteger ball = new AtomicInteger(0);

        // when
        BaseBallNumber inputBaseBallNumber = BaseBallNumber.generateNumber(inputString);

        computerNumber.compare((targetNumber, computerIndex) ->
                inputBaseBallNumber.compare((inputNumber, inputIndex) -> {
                    if(!Objects.equals(targetNumber, inputNumber)) return;

                    if(computerIndex.equals(inputIndex)) {
                        strike.getAndIncrement();
                    }
                    else {
                        ball.getAndIncrement();
                    }
                })
        );

        // then
        assertThat(strike.get()).isEqualTo(strikeCount);
        assertThat(ball.get()).isEqualTo(ballCount);

    }

    static Stream<Arguments> inputStringStream() {
        return Stream.of(
                Arguments.of("123", 3, 0),
                Arguments.of("234", 0, 2),
                Arguments.of("456", 0, 0),
                Arguments.of("789", 0, 0),
                Arguments.of("321", 1, 2),
                Arguments.of("132", 1, 2)
        );
    }

    static Stream<Arguments> inValidNumberStream() {
        return Stream.of(
                Arguments.of("3자리보다 큰 숫자 문자열이 들어온 경우", "1234"),
                Arguments.of("3자리보다 작은 숫자 문자열이 들어온 경우", "12"),
                Arguments.of("-가 포함된 경우", "-112"),
                Arguments.of("영어 소문자가 포함된 경우", "a12"),
                Arguments.of("영어 소문자로만 이루어진 경우", "abc"),
                Arguments.of("한글로만 이루어진 경우", "테스트"),
                Arguments.of("특수문자가 포함된 경우", "~!@"),
                Arguments.of("특수문자가 포함되어 3자리인 경우", "~12"),
                Arguments.of("특수문자가 포함되고 3자리보다 큰 경우", "123!"),
                Arguments.of("특수문자가 포함되고 3자리보다 작은 경우", "1!")
        );
    }

}
