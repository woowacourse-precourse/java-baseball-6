package baseball.application.result;

import baseball.application.PrintStateApplication;
import baseball.application.numbers.GenerateNumbersApplication;
import baseball.domain.BaseballResultRepository;
import camp.nextstep.edu.missionutils.Console;


public class GetResultApplication {
    boolean isContinue;
    boolean isCorrect;
    private static final BaseballResultRepository baseballResultRepository = BaseballResultRepository.getInstance();
    private static final GenerateNumbersApplication generateAnswerController = new GenerateNumbersApplication();

    public GetResultApplication() {
    }

    public boolean getResult() {
        boolean answer = false;
        isCorrect = isCorrectNumbers(baseballResultRepository.getBall(), baseballResultRepository.getStrike());
        if (isCorrect) {

            PrintStateApplication.printEndState();

            generateAnswerController.initilizeNumbers();
            isContinue = isContinueNumbers();

            if (isContinue) {
                generateAnswerController.generateNumbers();
                answer = false;
            } else {
                answer = true;
            }
        }
        return answer;
    }

    private boolean isContinueNumbers() {
        int val = Console.readLine().charAt(0) - '0';
        boolean result = false;
        switch (val) {
            case 1:
                result = true;
                break;
            case 2:
                result = false;
                break;
        }
        return result;
    }

    private boolean isCorrectNumbers(Integer countBall, Integer countStrike) {
        if (countBall == 0 && countStrike == 0) {
            System.out.println("낫싱");
        } else {
            if (countBall != 0) {
                System.out.print(countBall + "볼 ");
            }
            if (countStrike != 0) {
                System.out.println(countStrike + "스트라이크");
            } else {
                System.out.println();
            }
        }

        return countStrike == 3;
    }

}
