package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageConverterTest {

    private MessageConverter messageConverter = new MessageConverter();

    @Test
    void 스트라이크_볼_카운팅_메서드() {
        System.out.println(messageConverter.getResultMessage(List.of(1, 2, 3), List.of(2, 1, 3)));
    }

    @Test
    void Map_String_변환하기() {
        Map<String, Integer> testMap = messageConverter.getResultMessage(List.of(1, 2, 3), List.of(0, 5, 9));
        System.out.println(messageConverter.getResultMessageToString(testMap));
    }
}