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
    public void checkTargetNumberContainsAllNumeric_Success(final String value) {
        Assertions.assertTrue(StringUtils.isNumeric(value));
    }

    static Stream<Arguments> containsAllNumericArgs_Success(){
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
    public void checkTargetNumberContainsAllNumeric_Failure(final String value) {
        Assertions.assertFalse(StringUtils.isNumeric(value));
    }


    static Stream<Arguments> containsAllNumericArgs_Failure(){
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



}