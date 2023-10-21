package baseball.service.impl;

import baseball.service.ValidateJudgeService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateJudgeServiceImpl implements ValidateJudgeService {

    @Override
    public List<Integer> validateAndCompareCodes(List<Integer> baseballCodes, List<Integer> userCodes) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < userCodes.size(); i++) {
            for (int j = 0; j < baseballCodes.size(); j++) {
                Integer userCode = userCodes.get(i);
                Integer baseballCode = baseballCodes.get(j);
                if (i != j && userCode.equals(baseballCode)) {
                    ballCount += 1;
                } else if (i == j && userCode.equals(baseballCode)) {
                    strikeCount += 1;
                }
            }
        }
        return Arrays.asList(strikeCount, ballCount);
    }

    @Override
    public void validateLegalUserCode(List<Integer> userCode) {
        Set<Integer> userCodeSet = new HashSet<>(userCode);
        if (userCode.size() != 3 || userCodeSet.size() != 3) {
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
