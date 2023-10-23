package baseball.application.result;

import baseball.application.PrintStateApplication;
import baseball.application.numbers.GenerateAnswerApplication;
import baseball.domain.BaseballRepository;
import camp.nextstep.edu.missionutils.Console;

public class GetResultApplication {
    boolean isContinue;
    boolean isCorrect;
    private BaseballRepository baseballRepository = BaseballRepository.getInstance();
    private GenerateAnswerApplication generateAnswerController = new GenerateAnswerApplication();
    public GetResultApplication() {
    }

    public boolean getResult() {
        boolean answer = false;
        isCorrect = isCorrectNumbers(baseballRepository.getBall(), baseballRepository.getStrike());
        if (isCorrect) {

            PrintStateApplication.printEndState();

            generateAnswerController.initilizeAnswer();
            isContinue = getUserContinue();

            if (isContinue) {
                generateAnswerController.generateNumbers();
                answer = false;
            } else {
                answer = true;
            }
        }
        return answer;
    }

    private boolean getUserContinue() {
        int val = Console.readLine().charAt(0)-'0';
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
        if (countBall == 0 && countStrike == 0)
            System.out.println("낫싱");
        else {
            if (countBall != 0){
                System.out.print(countBall +"볼 ");
            }
            if (countStrike != 0)
                System.out.println(countStrike +"스트라이크");
            else System.out.println();
        }

        if (countStrike == 3) return true;
        else return false;
    }

}
