package baseball.ui;

import java.util.Map;

public class ResultFormatStringCreatorImpl implements ResultFormatStringCreator {
    @Override
    public String toString(Map<String, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();
        if (resultMap.size() == 0) {
            return "낫싱";
        }
        if (resultMap.containsKey("볼")) {
            sb.append(resultMap.get("볼")).append("볼");
        }
        if (resultMap.containsKey("스트라이크")) {
            if (resultMap.size() == 2) {
                sb.append(" ");
            }
            sb.append(resultMap.get("스트라이크")).append("스트라이크");
        }
        return sb.toString();
    }
}

