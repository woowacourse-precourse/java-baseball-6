package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[도메인] 사용자 테스트에서")
class UserTest {
    
    @Nested
    @DisplayName(" 생성할 때")
    class CreateUserValidationCase {
        //happy case
        @ParameterizedTest
        @ValueSource(strings = {"1234", "2345", "3456"})
        void _세자리_숫자로_입력되지_않는_경우_오류가_발생합니다(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new User(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"A12", "-12", "00$", "99b"})
        void _입력은_숫자로_구성되어야_합니다(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new User(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"111", "222", "333", "224", "233", "999"})
        void _입력은_중복될_수_없습니다(final String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new User(input));
        }

    }

}