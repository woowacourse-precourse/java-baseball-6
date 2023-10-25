package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final BaseballDisplay baseballDisplay = new BaseballDisplay();

    public void startBaseball() {
        baseballDisplay.startGame();
        do {
            BaseballNumber answerNumberList = createComputerBaseballNumber();
            playBaseball(answerNumberList);
        } while (wantToContinueGame());
        baseballDisplay.gameOver();
    }

    private BaseballNumber createComputerBaseballNumber() {
        return BaseballNumber.createComputerNumber();
    }

    private void playBaseball(BaseballNumber computerNumber) {
        while (true) {
            BaseballNumber userNumber = inputUserBaseballNumber();
            BaseballCount baseballCount = createBaseballCount(computerNumber, userNumber);
            baseballDisplay.displayMessage(baseballCount.getResultBriefing());
            if (baseballCount.isAllStrike()) {
                baseballDisplay.allStrikeAndRoundOver();
                break;
            }
        }
    }

    private BaseballNumber inputUserBaseballNumber() {
        baseballDisplay.baseballNumberInputRequest();
        String inputString = Console.readLine();
        return BaseballNumber.createNumberByString(inputString);
    }

    private BaseballCount createBaseballCount(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int strike = checkStrikeCount(computerNumber, userNumber);
        int ball = checkBallCount(computerNumber, userNumber);
        return new BaseballCount(strike, ball);
    }

    private int checkStrikeCount(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        return baseballCountStrategy(new StrikeCountStrategy(computerBaseballNumber, userBaseballNumber));
    }

    private int checkBallCount(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        return baseballCountStrategy(new BallCountStrategy(computerBaseballNumber, userBaseballNumber));
    }

    private int baseballCountStrategy(CountStrategy countStrategy) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += countStrategy.counting(i);
        }
        return count;
    }

    private boolean wantToContinueGame() {
        baseballDisplay.continueGameInputRequest();
        String inputString = Console.readLine();
        validateContinueGameInput(inputString);
        return inputString.equals("1");
    }

    private void validateContinueGameInput(String inputString) {
        if (!inputString.equals("1") && !inputString.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
