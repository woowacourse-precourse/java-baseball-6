package baseball.domain;

import baseball.utils.NumbersValidator;
import baseball.utils.ResultPrinter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.domain.RandomNumberCreator.*;
import static baseball.utils.BaseballGameNoticeUtil.*;

public class BaseBall {

    private BaseballCalculator baseballCalculator;

    public BaseBall(BaseballCalculator baseballCalculator) {
        this.baseballCalculator = baseballCalculator;
    }

    /**
     * 1. 입력 받기
     * 1-2. 입력 값 검증
     * 2. 게임 실행(+ 값 출력)
     * 3.
     *
     */
    public void baseBallRun() {
        // 랜덤 값 생성
        List<Integer> computerNumbers = makeRandomNumber();
        boolean isCorrect = baseBallStart(computerNumbers);

        while (!isCorrect) { // 정답 맞출 때 까지 반복
            isCorrect = baseBallStart(computerNumbers);
        }
    }

    public boolean baseBallStart(List<Integer> computerNumbers) {
        /**
         * 1. 숫자 입력(+ 입력 값 검증)
         * 2. 입력 값 계산기에 전달
         * 3. 계산 값 출력
         */
        requireInputNumber();
        String userInputNumbers = inputBaseballNumbers();
        NumbersValidator.inputValidate(userInputNumbers);

        List<Integer> baseballResult = baseballCalculator.calculator(userInputNumbers, computerNumbers);
        return ResultPrinter.printHint(baseballResult);
    }

    /* 숫자 값 입력 */
    public String inputBaseballNumbers() {
        return Console.readLine();
    }
}
