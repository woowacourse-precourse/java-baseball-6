package baseball.service.impl;

import baseball.service.ValidateJudgeService;
import baseball.vo.UserCode;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidateJudgeServiceImpl implements ValidateJudgeService {

    @Override
    public List<Integer> validateAndCompareCodes(List<Integer> baseballCodes, UserCode userCode) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int userCodeIndex = 0; userCodeIndex < userCode.getUserCodeSize(); userCodeIndex++) {
            for (int j = 0; j < baseballCodes.size(); j++) {
                Integer userCodeElement = userCode.getUserCodeElement(userCodeIndex);
                Integer baseballCode = baseballCodes.get(j);
                if (userCodeIndex != j && userCodeElement.equals(baseballCode)) {
                    ballCount += 1;
                } else if (userCodeIndex == j && userCodeElement.equals(baseballCode)) {
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
