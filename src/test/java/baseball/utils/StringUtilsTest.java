package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;


import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("[String Utils]")
class StringUtilsTest {

    @ParameterizedTest
    @MethodSource("containsAllNumericArgs_Success")
    @DisplayName("문자가 모두 숫자로 이루어져 있는지 확인 - 성공 시( 모두 숫자 일 시 ) true 리턴")
    public void checkTargetStringContainsAllNumeric_Success(final String value) {
        Assertions.assertTrue(StringUtils.isNumeric(value));
    }

    static Stream<Arguments> containsAllNumericArgs_Success() {
        return Stream.of(
                arguments("123123"),
                arguments("44982"),
                arguments("44"),
                arguments("42222"),
                arguments("3982"),
                arguments("392")
        );
    }

    @ParameterizedTest
    @MethodSource("containsAllNumericArgs_Failure")
    @DisplayName("문자가 모두 숫자로 이루어져 있는지 확인 - 실패 시( 문자가 포함되어 있을 때 ) false 리턴")
    public void checkTargetStringContainsAllNumeric_Failure(final String value) {
        Assertions.assertFalse(StringUtils.isNumeric(value));
    }


    static Stream<Arguments> containsAllNumericArgs_Failure() {
        return Stream.of(
                arguments("1231 23"),
                arguments("44982."),
                arguments("44;"),
                arguments("4A2222"),
                arguments("4@"),
                arguments("39a82"),
                arguments(" 392 "),
                arguments(" "),
                arguments("")
        );
    }


    @ParameterizedTest
    @MethodSource("isEqualLength_Success")
    @DisplayName("입력한 길이와 문자가 같은 길이를 가지는지 테스트 - 성공 시( 길이가 같을 시 ) true 리턴")
    public void checkTargetStringEqualLength_Success(final String value, final int len) {
        Assertions.assertTrue(StringUtils.isLengthEqual(value, len));
    }

    static Stream<Arguments> isEqualLength_Success() {
        return Stream.of(
                arguments("123123", 6),
                arguments("44982", 5),
                arguments("44a", 3),
                arguments("42222 ", 6),
                arguments("3982", 4),
                arguments("", 0),
                arguments(" ", 1),
                arguments("   ", 3),
                arguments("39AAAAAAA2", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("isEqualLength_Failure")
    @DisplayName("입력한 길이와 문자가 같은 길이를 가지는지 테스트 - 실패 시( 길이가 다를 시 ) false 리턴")
    public void checkTargetStringEqualLength_Failure(final String value, final int len) {
        Assertions.assertFalse(StringUtils.isLengthEqual(value, len));
    }

    static Stream<Arguments> isEqualLength_Failure() {
        return Stream.of(
                arguments("123123", 3),
                arguments("44982", 2),
                arguments("44a", 6),
                arguments("42222 ", 8),
                arguments("3982", 0),
                arguments("", 1),
                arguments(" ", 2),
                arguments("   ", 0),
                arguments("39AAAAAAA2", 11)
        );
    }

    @ParameterizedTest
    @MethodSource("isEqualLength_Exception")
    @DisplayName("입력한 길이와 문자가 같은 길이를 가지는지 테스트 - 예외 ( 내가 입력한 길이가 음수일 떄 ) IlligalArgumentException")
    public void checkTargetStringEqualLength_Exception(final String value, final int len) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StringUtils.isLengthEqual(value, len));
    }

    static Stream<Arguments> isEqualLength_Exception() {
        return Stream.of(
                arguments("123123", -1),
                arguments("44982", -100),
                arguments("39AAAAAAA2", -4)
        );
    }


    @ParameterizedTest
    @MethodSource("hasDuplicate_Success")
    @DisplayName("문자열이 중복된 값을 가지는지 테스트 - 성공(중복된 문자가 하나라도 있을 시) true 리턴")
    public void checkTargetHasDuplicate_Success(final String value) {
        Assertions.assertTrue(StringUtils.hasDuplicate(value));
    }

    static Stream<Arguments> hasDuplicate_Success() {
        return Stream.of(
                arguments("123123"),
                arguments("44982"),
                arguments("  "),
                arguments("&&"),
                arguments("abca"),
                arguments("abc a"),
                arguments("''''"),
                arguments("39AAAAAAA2")
        );
    }

    @ParameterizedTest
    @MethodSource("hasDuplicate_Failure")
    @DisplayName("문자열이 중복된 값을 가지는지 테스트 - 실패(중복된 문자가 없을 시) false 리턴")
    public void checkTargetHasDuplicate_Failure(final String value) {
        Assertions.assertFalse(StringUtils.hasDuplicate(value));
    }

    static Stream<Arguments> hasDuplicate_Failure() {
        return Stream.of(
                arguments("123"),
                arguments("4982"),
                arguments(" "),
                arguments(""),
                arguments("abc"),
                arguments("abc리 "),
                arguments("'"),
                arguments("39A2")
        );
    }
}