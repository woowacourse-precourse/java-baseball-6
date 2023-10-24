package baseball.domain;

import baseball.utils.GameNoticeUtil;
import baseball.utils.RandomNumberCreator;
import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class BaseBall implements Game {

    private Calculator calculator;

    public BaseBall(Calculator calculator) {
        this.calculator = calculator;
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
        GameNoticeUtil.requireInputNumber();
        String inputStringNumbers = inputBaseballNumbers();
        Validator.inputValidate(inputStringNumbers);

        List<Integer> baseballResults = calculator.calculate(inputStringNumbers, computerNumbers);
        return Printer.printHint(baseballResults);
    }

    /* 숫자 값 입력 */
    public String inputBaseballNumbers() {
        return Console.readLine();
    }
}
