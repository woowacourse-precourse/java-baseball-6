package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    Message message = new Message();
    @Test
    void scoreMessage() {
        List<Integer> score = List.of(0, 0);
        assertEquals("낫싱", message.scoreMessage(score));
        score = List.of(1, 0);
        assertEquals("1볼", message.scoreMessage(score));

        score = List.of(0, 1);
        assertEquals("1스트라이크", message.scoreMessage(score));

        score = List.of(1, 1);
        assertEquals("1볼 1스트라이크", message.scoreMessage(score));

        score = List.of(2, 1);
        assertEquals("2볼 1스트라이크", message.scoreMessage(score));

    }
}