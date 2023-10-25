package baseball.GameController;

import baseball.Judge.Judge;
import baseball.User.User;
import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    private static User user = new User();

    private static GameController gameController = new GameController();

    private static Judge judge = new Judge();

    private static ArrayList<Integer> answer = new ArrayList<>();

    @Test
    void checkInput() throws Exception {

        Assertions.assertThatThrownBy(() -> gameController.checkInput(user, "1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자여야 합니다.");
        Assertions.assertThatThrownBy(() -> gameController.checkInput(user, "120"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9사이 숫자여야 합니다.");
        Assertions.assertThatThrownBy(() -> gameController.checkInput(user, "111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로다른 숫자여야 합니다.");


    }

    @Test
    void judgeResult() {
        Integer[] arr = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        Assertions.assertThat(gameController.judgeResult(judge, "123", list))
                .isEqualTo(3);
    }
}