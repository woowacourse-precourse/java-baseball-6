package baseball.service;

import java.util.List;

public interface ValidateJudgeService {

    List<Integer> validateAndCompareCodes(List<Integer> baseballCode, List<Integer> userCode);

    void validateLegalUserCode(List<Integer> userCode);

    boolean restartValidateCode(Integer code);
}
