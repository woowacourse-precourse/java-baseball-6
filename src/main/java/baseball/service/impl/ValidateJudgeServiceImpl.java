package baseball.service.impl;

import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import baseball.vo.UserCode;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidateJudgeServiceImpl implements ValidateJudgeService {

    @Override
    public List<Integer> validateAndCompareCodes(BaseballCode baseballCode, UserCode userCode) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int userCodeIndex = 0; userCodeIndex < userCode.getUserCodeSize(); userCodeIndex++) {
            for (int baseballCodeIndex = 0; baseballCodeIndex < baseballCode.getBaseballCodeSize();
                 baseballCodeIndex++) {
                Integer userCodeElement = userCode.getUserCodeElement(userCodeIndex);
                Integer baseballCodeElement = baseballCode.getBaseballCodeElement(baseballCodeIndex);
                if (userCodeIndex != baseballCodeIndex && userCodeElement.equals(baseballCodeElement)) {
                    ballCount += 1;
                } else if (userCodeIndex == baseballCodeIndex && userCodeElement.equals(baseballCodeElement)) {
                    strikeCount += 1;
                }
            }
        }
        return Arrays.asList(strikeCount, ballCount);
    }

    @Override
    public void validateLegalUserCode(UserCode userCode) {
        Set<Integer> userCodeSet = userCode.convertUserCodeToSet();
        if (userCode.getUserCodeSize() != 3 || userCodeSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean restartValidateCode(Integer code) {
        if (code == 1) {
            return true;
        } else if (code == 2) {
            return false;
        }
        throw new IllegalArgumentException();
    }


}
