package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    @Test
    @DisplayName("플레이어가 컴퓨터가 선택한 서로 다른 3자리의 수를 예상하여 입력한다.")
    public void inputThreeNumberTest(){
        String inputNumbers = "123";
        InputController inputController = new InputController();

        run(inputNumbers);
        List<Integer> targetNumbers = Arrays.asList(1,2,3);

        assertThat(inputController.getPlayerGuessNumber()).isEqualTo(targetNumbers);
    }
    @Test
    @DisplayName("플레이어가 컴퓨터가 선택한 서로 다른 4자리의 수를 예상하여 입력한다.")
    public void inputFourNumberTest(){
        String inputNumbers = "1234";
        InputController inputController = new InputController();
        run(inputNumbers);
        assertThatThrownBy(inputController::getPlayerGuessNumber).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}
