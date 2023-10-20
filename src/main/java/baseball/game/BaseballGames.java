package baseball.game;

import baseball.domain.UserCode;
import baseball.service.UserCodeService;
import baseball.service.ValidateJudgeService;
import baseball.service.impl.UserCodeServiceImpl;
import baseball.service.impl.ValidateJudgeServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class BaseballGames {

    private static final ValidateJudgeService validateJudgeService = new ValidateJudgeServiceImpl();
    private static final UserCodeService userCodeService = new UserCodeServiceImpl();

    public void playBaseball(List<Integer> baseballCode) {

        UserCode codes = new UserCode(new ArrayList<>());

        while (true) {
            UserCode userCode = userCodeService.makeUserCode(codes);
            validateJudgeService.validateLegalUserCode(userCode.getCodes());
            break;
        }
    }
}
