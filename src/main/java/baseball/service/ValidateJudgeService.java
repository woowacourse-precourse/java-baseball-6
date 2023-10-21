package baseball.service;

import baseball.vo.BaseballCode;
import baseball.vo.UserCode;
import java.util.List;

public interface ValidateJudgeService {

    List<Integer> validateAndCompareCodes(BaseballCode baseballCode, UserCode userCode);

    void validateLegalUserCode(UserCode userCode);

    boolean restartValidateCode(Integer code);
}
