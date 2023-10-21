package baseball.domain;

import baseball.utils.BaseballGameNoticeUtil;
import baseball.utils.NumbersValidator;
import baseball.utils.RandomNumberCreator;
import baseball.utils.ResultPrinter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class BaseBall implements Game {

    private BaseballCalculator baseballCalculator;

    public BaseBall(BaseballCalculator baseballCalculator) {
        this.baseballCalculator = baseballCalculator;
    }

    @Override
    public void gameRun() {
        // 랜덤 값 생성
        List<Integer> computerNumbers = RandomNumberCreator.makeRandomNumber();
        boolean isCorrect = gameStart(computerNumbers);

        while (!isCorrect) { // 정답 맞출 때 까지 반복
            isCorrect = gameStart(computerNumbers);
        }
    }

    @Override
    public boolean gameStart(List<Integer> computerNumbers) {
        /**
         * 1. 숫자 입력(+ 입력 값 검증)
         * 2. 입력 값 계산기에 전달
         * 3. 계산 값 출력
         */
        BaseballGameNoticeUtil.requireInputNumber();
        String userInputNumbers = inputBaseballNumbers();
        NumbersValidator.inputValidate(userInputNumbers);

        List<Integer> baseballResult = baseballCalculator.calculate(userInputNumbers, computerNumbers);
        return ResultPrinter.printHint(baseballResult);
    }

    /* 숫자 값 입력 */
    public String inputBaseballNumbers() {
        return Console.readLine();
    }
}
