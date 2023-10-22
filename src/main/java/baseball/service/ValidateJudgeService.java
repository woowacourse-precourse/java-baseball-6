package baseball.service;

import baseball.vo.BaseballCode;
import baseball.vo.GameResult;
import baseball.vo.RestartDecisionCode;
import baseball.vo.UserCode;

public interface ValidateJudgeService {

    GameResult validateAndCompareCodes(BaseballCode baseballCode, UserCode userCode);

    void validateLegalUserCode(UserCode userCode);

    boolean restartValidateCode(RestartDecisionCode code);
}
