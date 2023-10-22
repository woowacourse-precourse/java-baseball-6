package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputCommanderTest {

    @Test
    void 사용자의_입력을_받아온다(){
        String expected = "wooteco";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        InputCommander inputCommander = new InputCommander();

        String input = inputCommander.receiveInput();

        assertEquals(expected, input);
    }
}