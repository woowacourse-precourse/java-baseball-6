package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    public void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String continueBaseball = "1";
        while (continueBaseball.equals("1")) {
            BaseballNumber answerNumberList = createBaseballAnswerNumberList();
            playBaseball(answerNumberList);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueBaseball = Console.readLine();
        }

        System.out.println("게임 종료");
    }

    private BaseballNumber createBaseballAnswerNumberList() {
        return BaseballNumber.createComputerNumber();
    }

    private void playBaseball(BaseballNumber computerNumber) {
        while (true) {
            BaseballNumber userNumber = inputBaseballNumber();
            BaseballCount baseballCount = checkBaseballResult(computerNumber, userNumber);
            baseballCount.printBaseballResult();
            if (baseballCount.isAllStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private BaseballNumber inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        return BaseballNumber.createNumberByString(inputString);
    }

    private BaseballCount checkBaseballResult(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int strike = checkStrikeCount(computerNumber, userNumber);
        int ball = checkBallCount(computerNumber, userNumber);
        return new BaseballCount(strike, ball);
    }

    private int checkStrikeCount(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int checkBallCount(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (computerNumber.get(i) == userNumber.get(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
