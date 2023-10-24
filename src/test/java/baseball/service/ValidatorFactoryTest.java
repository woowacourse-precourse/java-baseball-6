package baseball.service;

import baseball.validation.GameNumberValidator;
import baseball.validation.SingleNumberValidator;
import baseball.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidatorFactoryTest {

    @DisplayName("올바른 검증기 가져오는지 확인")
    @ParameterizedTest(name = "{index} {displayName} value={0}, {1}")
    @MethodSource("checkValidatorParametersProvider")
    void checkGetValidatorFactory(Class<?> source, Class<?> target) {
        Validator validator = ValidatorFactory.getValidator(source);
        Assertions.assertThat(validator.getClass()).isEqualTo(target);
    }


    static Stream<Arguments> checkValidatorParametersProvider() {
        return Stream.of(
                Arguments.arguments(String.class, SingleNumberValidator.class),
                Arguments.arguments(List.class, GameNumberValidator.class)
        );
    }
}