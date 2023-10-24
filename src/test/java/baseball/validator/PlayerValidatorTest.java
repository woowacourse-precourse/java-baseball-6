package baseball.validator;

import baseball.model.player.PlayerValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class PlayerValidatorTest {

    PlayerValidator playerValidator = new PlayerValidator();

    @Test
    @DisplayName("사용자가 3자리 초과한 숫자를 입력하면 에러가 발생한다.")
    void input_size_error(){
        assertThatThrownBy(() -> playerValidator.validateExpectedNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
