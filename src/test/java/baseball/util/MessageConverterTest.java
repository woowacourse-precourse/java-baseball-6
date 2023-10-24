package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MessageConverterTest {

    private MessageConverter messageConverter = new MessageConverter();

    @Test
    void String을_List로_변환() {
        String example = "316";
        assertTrue(messageConverter.convertStrToList(example) instanceof List<Integer>);
    }

    @Test
    void 스트라이크_볼_카운팅() {
        System.out.println(messageConverter.getResultMessage(List.of(1, 2, 3), List.of(2, 1, 3)));
    }

    @Test
    void Map_String_변환하기() {
        Map<String, Integer> testMap = messageConverter.getResultMessage(List.of(1, 2, 3), List.of(3, 1, 6));
        assertTrue(messageConverter.getResultMessageToString(testMap) instanceof String);
    }

    @Test
    void 스트라이크_출력() {
        Map<String, Integer> testMap = messageConverter.getResultMessage(List.of(1, 2, 3), List.of(1, 6, 7));
        assertEquals(messageConverter.getResultMessageToString(testMap), "1스트라이크");
    }

    @Test
    void 볼_출력() {
        Map<String, Integer> testMap = messageConverter.getResultMessage(List.of(1, 2, 3), List.of(6, 1, 7));
        assertEquals(messageConverter.getResultMessageToString(testMap), "1볼");
    }

    @Test
    void 스트라이크_볼_출력() {
        Map<String, Integer> testMap = messageConverter.getResultMessage(List.of(1, 2, 3), List.of(1, 7, 2));
        assertEquals(messageConverter.getResultMessageToString(testMap), "1볼 1스트라이크");
    }
}