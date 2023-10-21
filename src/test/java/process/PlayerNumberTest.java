package process;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumberTest {

    final List<Integer> playerInput = new ArrayList<>();
    final PlayerNumberProcess playerNumberProcess = PlayerNumberProcess.getInstance(playerInput);

    @Test
    @DisplayName("플레이어에게 세자리수를 입력받는다")
    public void 세자리수_입력_받기() throws Exception {
        // given
        String input = "123";

        // when
        List<Integer> numbers = playerNumberProcess.getNumbers(input);

        String result = "";
        for (int num : numbers
        ) {
            result += String.valueOf(num);
        }

        // then
        Assertions.assertThat(result).isEqualTo(input);
    }
    
    @Test
    @DisplayName("플레이어가 숫자가 아닌 값을 입력")
    public void inputTypeError() throws Exception {
        // given
        String input = "ld2";

        // then
        Assertions.assertThatThrownBy(() -> playerNumberProcess.getNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)  // 예상되는 exception
                .hasMessage("숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("플레이어가 세자리 숫자를 입력하지 않은 경우")
    public void inputSizeError() throws Exception {
        // given
        String input = "12";


        // then
        Assertions.assertThatThrownBy(() -> playerNumberProcess.getNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세자리 수를 입력해주세요.");

    }

    @DisplayName("플레이어가 1-9사이의 값을 입력하지 않은 경우")
    @Test
    public void inputRangeError() throws Exception {
        // given
        String input = "012";

        // then
        Assertions.assertThatThrownBy(() -> playerNumberProcess.getNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1-9사이의 값을 입력해주세요.");

    }

    @DisplayName("플레이어가 동일한 숫자를 함께 입력했을 경우")
    @Test
    public void inputDuplicateError() throws Exception {
        // given
        String input = "112";

        // then
        Assertions.assertThatThrownBy(() -> playerNumberProcess.getNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 숫자를 입력해주세요.");

    }

}
