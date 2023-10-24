package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameManagerTest {

    private GameManager gameManager = new GameManager();

    @Test
    @DisplayName("게임 종료 후 , 재시작 또는 종료 외의 다른 입력시, 예외처리")
    void 종료_후_입력_예외() {
        assertThatThrownBy(() -> gameManager.validateRestartOrExitWrongInput("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼 개수 정상 출력 확인")
    void 볼_개수_체크() {
        gameManager.setAnswer(List.of(1, 2, 3));
        gameManager.setInputConvertList("392");
        int ballCount = gameManager.getBallCount();
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("스트라이크 개수 정상 출력 확인")
    void 스트라이크_개수_체크() {
        gameManager.setAnswer(List.of(1, 2, 3));
        gameManager.setInputConvertList("143");
        int strikeCount = gameManager.getStrikeCount();
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    @DisplayName("낫싱 정상 출력 확인")
    void 낫싱_테스트() {
        gameManager.setAnswer(List.of(1, 5, 3));
        gameManager.setInputConvertList("768");
        boolean isNoting = gameManager.isNothing();
        assertThat(isNoting).isTrue();
    }


}