package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class UserNumberTest {

    @DisplayName("사용자 수 정상적인 값 입력되면 성공")
    @Test
    void inputNormalUserNumber(){
        String inputNumber = "123";
        UserNumber userNumber = new UserNumber(inputNumber);
        assertThat(userNumber.getNumber()).isEqualTo(List.of(1, 2, 3));
    }

}