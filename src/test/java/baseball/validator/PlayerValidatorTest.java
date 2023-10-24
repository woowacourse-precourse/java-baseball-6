package baseball.validator;

import baseball.model.player.PlayerValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
class PlayerValidatorTest {

    PlayerValidator playerValidator = new PlayerValidator();

    @Test
    @DisplayName("사용자가 3자리 초과한 숫자를 입력하면 에러가 발생한다.")
    void input_size_error(){
        assertThatThrownBy(() -> playerValidator.validateExpectedNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사용자가 중복된 숫자를 입력하면 에러가 발생한다.")
    @ValueSource(strings = {"133", "222", "1455", "9999"})
    void input_duplicate_error(String number){
        assertThatThrownBy(() -> playerValidator.validateExpectedNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
