package baseball.service;

import baseball.vo.GameResult;
import baseball.vo.Message;

public interface MessageGenerateService {

    Message makeMessage(GameResult gameResult);
}
