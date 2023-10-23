package view.processing;

import static utils.GameErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static utils.GameErrorMessage.ERROR_ONLY_NUMBERS_ALLOWED;
import static utils.GameErrorMessage.EXCEEDING_COUNT_ERROR_MESSAGE;
import static utils.GameErrorMessage.INVALID_LENGTH_MESSAGE;
import static utils.GameErrorMessage.NULL_INPUT_MESSAGE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void validateBaseballNumber_성공() {
        String baseballNumber = "123";
        validator.validateBaseballNumber(baseballNumber);
    }

    @Test
    void validateBaseballNumber_NPE_실패() {
        String baseballNumber = null;
        Assertions.assertThatThrownBy(() -> {
                validator.validateBaseballNumber(baseballNumber);
            }).isInstanceOf(NullPointerException.class)
            .hasMessageContaining(NULL_INPUT_MESSAGE);
    }

    @Test
    void validateBaseballNumber_3자리아님_실패() {
        String baseballNumber = "";
        Assertions.assertThatThrownBy(() -> {
                validator.validateBaseballNumber(baseballNumber);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INVALID_LENGTH_MESSAGE);
    }

    @Test
    void validateBaseballNumber_문자_실패() {
        String baseballNumber = "asd";
        Assertions.assertThatThrownBy(() -> {
                validator.validateBaseballNumber(baseballNumber);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_ONLY_NUMBERS_ALLOWED);
    }

    @Test
    void validateBaseballNumber_겹치는수_실패() {
        String baseballNumber = "112";
        Assertions.assertThatThrownBy(() -> {
                validator.validateBaseballNumber(baseballNumber);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(DUPLICATE_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void totalCountsNotExceedingLimit_성공() {
        int strike = 1;
        int ball = 2;
        validator.totalCountsNotExceedingLimit(strike, ball);
    }

    @Test
    void totalCountsNotExceedingLimit_3초과_실패() {
        int strike = 3;
        int ball = 1;
        Assertions.assertThatThrownBy(() -> {
                validator.totalCountsNotExceedingLimit(strike, ball);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(EXCEEDING_COUNT_ERROR_MESSAGE);
    }
}