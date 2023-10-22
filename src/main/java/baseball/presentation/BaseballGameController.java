package baseball.presentation;

import baseball.application.BaseballGameService;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;
import baseball.domain.BaseballResultState;
import baseball.infra.BaseballNumberGeneratorType;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            while(loopGame());
        } catch (IllegalArgumentException ex) {
            throw ex;
        }

    }

    private boolean loopGame() throws IllegalArgumentException {
        BaseballNumber computerBaseballNumber = baseballGameService.makeBaseballNumber(BaseballNumberGeneratorType.COMPUTER);
        BaseballNumber userBaseballNumber = null;
        boolean continueGame = true;

        while (continueGame) {
            userBaseballNumber = inputBaseballNumber();
            continueGame = printResultAndCheckGameEnd(userBaseballNumber, computerBaseballNumber);
        }

        continueGame = checkContinueGame();

        return continueGame;
    }

    private boolean printResultAndCheckGameEnd(BaseballNumber userBaseballNumber, BaseballNumber computerBaseballNumber) {
        BaseballResult baseballResult = baseballGameService.returnBaseballResult(userBaseballNumber, computerBaseballNumber);

        if (baseballResult.getCount(BaseballResultState.BALL) != 0) {
            System.out.print(String.format("%d%s ", baseballResult.getCount(BaseballResultState.BALL), BaseballResultState.BALL));
        }

        if (baseballResult.getCount(BaseballResultState.STRIKE) != 0) {
            System.out.print(String.format("%d%s ", baseballResult.getCount(BaseballResultState.STRIKE), BaseballResultState.STRIKE));
        }

        if (baseballResult.getCount(BaseballResultState.NOTHING) != 0) {
            System.out.print(BaseballResultState.NOTHING);
        }

        System.out.println();

        if (baseballResult.getCount(BaseballResultState.STRIKE) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return false;
        }

        return true;
    }


    private BaseballNumber inputBaseballNumber() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");

        return baseballGameService.makeBaseballNumber(BaseballNumberGeneratorType.USER);
    }

    private boolean checkContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String continueGame = Console.readLine();

        if (continueGame.equals("1")) {
            return true;
        }
        else if (continueGame.equals("2")) {
            return false;
        }
        else {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

}
