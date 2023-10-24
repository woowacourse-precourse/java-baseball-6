package baseball.util;

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
    void 스트라이크_볼_카운팅_메서드() {
        System.out.println(messageConverter.getResultMessage(List.of(1, 2, 3), List.of(2, 1, 3)));
    }

    @Test
    void Map_String_변환하기() {
        Map<String, Integer> testMap = messageConverter.getResultMessage(List.of(1, 2, 3), List.of(0, 5, 9));
        assertTrue(messageConverter.getResultMessageToString(testMap) instanceof String);
    }
}