package baseball;

import baseball.view.GameView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameViewTest {

    @Test
    void testGameStartMessage() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // 표준 출력을 outputStream으로 변경

        GameView gameView = new GameView();

        // Act
        gameView.displayGameStartMessage();

        // Assert
        String expectedMessage = "숫자 야구 게임을 시작합니다.";
        assertEquals(expectedMessage, outputStream.toString().trim());  // 출력된 메시지를 확인

        // 다시 표준 출력을 원래대로 설정
        System.setOut(System.out);
    }

    @Test
    void testGameOverMessage() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // 표준 출력을 outputStream으로 변경

        GameView gameView = new GameView();

        // Act
        gameView.displayGameOverMessage();

        // Assert
        String expectedMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertEquals(expectedMessage, outputStream.toString().trim());  // 출력된 메시지를 확인

        // 다시 표준 출력을 원래대로 설정
        System.setOut(System.out);
    }

}
