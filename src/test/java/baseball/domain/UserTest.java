package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserTest {


    @Nested
    @DisplayName("사용자를 생성할 때")
    class CreateUserValidationCase {


        //happy case
        @ParameterizedTest
        @ValueSource(strings = {"1234", "2345", "3456"})
        void 세자리로_구성되지_않는_경우_오류가_발생합니다(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new User(input));
        }
    }

}