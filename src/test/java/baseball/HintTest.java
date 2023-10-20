package baseball;

import baseball.Model.GameData;
import baseball.View.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HintTest {
    GameData gameData = new GameData();
    OutputView outputView = new OutputView(gameData);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 힌트정상계산_확인_볼스트라이크(){
        gameData.setBallCount(2);
        gameData.setStrikeCount(1);
        outputView.printHint();
        Assertions.assertThat(outContent.toString().trim()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 힌트정상계산_확인_낫싱(){
        gameData.setBallCount(0);
        gameData.setStrikeCount(0);
        outputView.printHint();
        Assertions.assertThat(outContent.toString().trim()).isEqualTo("낫싱");
    }

    @Test
    void 힌트정상계산_확인_스트라이크만(){
        gameData.setBallCount(0);
        gameData.setStrikeCount(1);
        outputView.printHint();
        Assertions.assertThat(outContent.toString().trim()).isEqualTo("1스트라이크");
    }

    @Test
    void 힌트정상계산_확인_볼만(){
        gameData.setBallCount(2);
        gameData.setStrikeCount(0);
        outputView.printHint();
        Assertions.assertThat(outContent.toString().trim()).isEqualTo("2볼");
    }
}
