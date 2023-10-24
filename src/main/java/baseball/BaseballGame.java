package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    public void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            BaseballNumber answerNumberList = createComputerBaseballNumber();
            playBaseball(answerNumberList);
        } while (wantToContinueGame());
        System.out.println("게임 종료");
    }

    private BaseballNumber createComputerBaseballNumber() {
        return BaseballNumber.createComputerNumber();
    }

    private void playBaseball(BaseballNumber computerNumber) {
        while (true) {
            BaseballNumber userNumber = inputUserBaseballNumber();
            BaseballCount baseballCount = createBaseballCount(computerNumber, userNumber);
            System.out.println(baseballCount.getResultBriefing());
            if (baseballCount.isAllStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private BaseballNumber inputUserBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        return BaseballNumber.createNumberByString(inputString);
    }

    private BaseballCount createBaseballCount(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int strike = checkStrikeCount(computerNumber, userNumber);
        int ball = checkBallCount(computerNumber, userNumber);
        return new BaseballCount(strike, ball);
    }

    private int checkStrikeCount(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerBaseballNumber.get(i) == userBaseballNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int checkBallCount(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (computerBaseballNumber.get(i) == userBaseballNumber.get(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private boolean wantToContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        validateContinueGameInput(inputString);
        return inputString.equals("1");
    }

    private void validateContinueGameInput(String inputString) {
        if(!inputString.equals("1") && !inputString.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
