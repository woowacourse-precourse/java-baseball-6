package baseball;

import baseball.application.PrintStateApplication;
import baseball.application.result.CalculateResultApplication;
import baseball.application.numbers.GenerateNumbersApplication;
import baseball.application.numbers.GetUserNumbersApplication;
import baseball.application.result.GetResultApplication;

public class Application {

    static GenerateNumbersApplication generateAnswerController;
    static GetUserNumbersApplication getUserAnwerController;
    static CalculateResultApplication calculateResultController;
    static GetResultApplication getResultController;

    public static void main(String[] args) {

        generateAnswerController = new GenerateNumbersApplication();
        PrintStateApplication.printStartState();

        while (true){
            PrintStateApplication.printInputState();
            getUserAnwerController = new GetUserNumbersApplication();
            calculateResultController = new CalculateResultApplication();
            getResultController = new GetResultApplication();

            if (getResultController.getResult()){
                break;
            }
        }
    }
}
