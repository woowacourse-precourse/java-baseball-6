package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static baseball.model.constants.Constant.GAME_START_PHRASE;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @Test
    @DisplayName("게임 시작 문구인 '숫자 야구 게임을 시작합니다.'를 출력합니다.")
    void 게임시작문구출력() {
        OutputView outputView = new OutputView();

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printGameStart();

        String actualOutput = outputStream.toString().trim();

        assertEquals(GAME_START_PHRASE, actualOutput);
    }
}