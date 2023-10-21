package baseball.service.impl;

import baseball.service.MessageGenerateService;
import java.util.List;

public class MessageGenerateServiceImpl implements MessageGenerateService {
    @Override
    public String makeMessage(List<Integer> resultList) {
        Integer strikeCount = resultList.get(0);
        Integer ballCount = resultList.get(1);
        if (strikeCount.equals(3)) {
            return strikeCount + "스트라이크";
        } else if (ballCount.equals(0) && !strikeCount.equals(0)) {
            return strikeCount + "스트라이크";
        } else if (!ballCount.equals(0) && !strikeCount.equals(0)) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (!ballCount.equals(0)) {
            return ballCount + "볼";
        }
        return "낫싱";
    }
}
