package baseball.service;

import baseball.vo.GameResult;

public interface MessageGenerateService {

    String makeMessage(GameResult gameResult);
}
