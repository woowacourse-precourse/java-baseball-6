package baseball.ui.output.format;

import java.util.Map;

public interface ResultFormatStringCreator {
    String toString(Map<String, Integer> resultMap);
}
