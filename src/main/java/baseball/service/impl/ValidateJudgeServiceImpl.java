package baseball.service.impl;

import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import baseball.vo.GameResult;
import baseball.vo.UserCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidateJudgeServiceImpl implements ValidateJudgeService {

    private static final GameResult result = new GameResult(new ArrayList<>());

    private static void validateCode(BaseballCode baseballCode, UserCode userCode, List<Integer> count,
                                     int userCodeIndex, int baseballCodeIndex) {
        Integer userCodeElement = userCode.getUserCodeElement(userCodeIndex);
        Integer baseballCodeElement = baseballCode.getBaseballCodeElement(baseballCodeIndex);
        if (userCodeIndex != baseballCodeIndex && userCodeElement.equals(baseballCodeElement)) {
            count.set(1, count.get(1) + 1);
        } else if (userCodeIndex == baseballCodeIndex && userCodeElement.equals(baseballCodeElement)) {
            count.set(0, count.get(0) + 1);
        }
    }

    @Override
    public GameResult validateAndCompareCodes(BaseballCode baseballCode, UserCode userCode) {
        List<Integer> count = Arrays.asList(0, 0);

        for (int userCodeIndex = 0; userCodeIndex < userCode.getUserCodeSize(); userCodeIndex++) {
            for (int baseballCodeIndex = 0; baseballCodeIndex < baseballCode.getBaseballCodeSize();
                 baseballCodeIndex++) {
                validateCode(baseballCode, userCode, count, userCodeIndex, baseballCodeIndex);
            }
        }
        return result.makeNewGameResult(count);
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
