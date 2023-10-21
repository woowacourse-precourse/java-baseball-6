package baseball.service;

import baseball.vo.UserCode;
import java.util.List;

public interface ValidateJudgeService {

    List<Integer> validateAndCompareCodes(List<Integer> baseballCode, UserCode userCode);

    void validateLegalUserCode(UserCode userCode);

    boolean restartValidateCode(Integer code);
}
