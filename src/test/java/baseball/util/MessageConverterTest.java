package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class MessageConverterTest {

    @Test
    void 스트라이크_볼_카운팅_메서드() {
        System.out.println(MessageConverter.getResultMessage(List.of(1, 2, 3), List.of(2, 1, 3)));
    }

    @Test
    void Map_String_변환하기() {
        Map<String, Integer> testMap = MessageConverter.getResultMessage(List.of(1, 2, 3), List.of(2, 1, 3));
        System.out.println(MessageConverter.getResultMessageToString(testMap));
    }
}