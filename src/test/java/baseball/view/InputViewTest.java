package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputStream inputStream;

    @Test
    @DisplayName("숫자 입력 문구를 출력받은 후, 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력합니다.")
    void 사용자_게임_숫자_입력() {
        String playerNumbers = "123";

        try {
            inputStream = new ByteArrayInputStream(playerNumbers.getBytes());
            System.setIn(inputStream);

            String actualInput = InputView.setGameInput();

            assertEquals(playerNumbers, actualInput);
        } catch (Exception ignored) {
        }
    }

    @Test
    @DisplayName("재시작 숫자 입력 문구를 출력받은 후, 게임 플레이어는 재시작하고 싶을 시 숫자 1, 종료를 원할 시 숫자 2를 입력합니다.")
    void 사용자_재시작_숫자_입력() {
        String restartNumber = "1";

        try {
            inputStream = new ByteArrayInputStream(restartNumber.getBytes());
            System.setIn(inputStream);

            String actualInput = InputView.setRestartInput();

            assertEquals(restartNumber, actualInput);
        } catch (Exception ignored) {
        }
    }
}