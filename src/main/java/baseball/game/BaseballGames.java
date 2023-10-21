package baseball.game;

import baseball.domain.UserCode;
import baseball.service.MessageGenerateService;
import baseball.service.UserCodeService;
import baseball.service.ValidateJudgeService;
import baseball.service.impl.MessageGenerateServiceImpl;
import baseball.service.impl.UserCodeServiceImpl;
import baseball.service.impl.ValidateJudgeServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class BaseballGames {

    private static final ValidateJudgeService validateJudgeService = new ValidateJudgeServiceImpl();
    private static final UserCodeService userCodeService = new UserCodeServiceImpl();
    private static final MessageGenerateService messageGenerateService = new MessageGenerateServiceImpl();

    private static final String END_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void playBaseball(List<Integer> baseballCode) {

        UserCode codes = new UserCode(new ArrayList<>());

        while (true) {
            UserCode userCode = userCodeService.makeUserCode(codes);
            validateJudgeService.validateLegalUserCode(userCode.getCodes());
            System.out.println("userCode.getCodes() = " + userCode.getCodes());
            System.out.println("baseballCode = " + baseballCode);
            List<Integer> resultList = validateJudgeService.validateAndCompareCodes(baseballCode, userCode.getCodes());
            String batResult = messageGenerateService.makeMessage(resultList);
            System.out.println(batResult);
            if (batResult.equals("3스트라이크")) {
                System.out.println(END_COMMENT);
                break;
            }
        }
    }
}
