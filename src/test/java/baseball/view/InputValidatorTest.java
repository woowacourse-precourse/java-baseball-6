package baseball.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void init() {
        inputValidator = new InputValidator();
    }

    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void 빈값을_넣으면_예외가_발생한다(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateInput(input));
    }
}
