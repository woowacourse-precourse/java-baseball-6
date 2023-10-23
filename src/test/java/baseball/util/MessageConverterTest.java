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
}