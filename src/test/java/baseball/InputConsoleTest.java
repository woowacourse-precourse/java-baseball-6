package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputConsoleTest {

    @Test
    void 숫자가_아닐시_예외를_던진다(){
        InputConsole inputConsole = new InputConsole();
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(inputConsole::readPrediction)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3을_넘어가면_예외를_던진다(){
        InputConsole inputConsole = new InputConsole();
        String input = "1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(inputConsole::readPrediction)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자가_있으면_예외를_던진다(){
        InputConsole inputConsole = new InputConsole();
        String input = "222";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(inputConsole::readPrediction)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_입력은_읽어서_그대로_반환한다(){
        InputConsole inputConsole = new InputConsole();
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = inputConsole.readPrediction();

        assertEquals("123", result);
    }

    @Test
    void 게임재시작시_1과2가_아니면_예외를_던진다(){
        InputConsole inputConsole = new InputConsole();
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(inputConsole::readPrediction)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임재시작시_1과2인경우_입력을_그대로_반환한다(){
        InputConsole inputConsole = new InputConsole();
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = inputConsole.readUserIntentionForNewGame();

        assertEquals("1", result);
    }

}