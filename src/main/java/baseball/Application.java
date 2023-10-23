package baseball;

import baseball.application.PrintStateApplication;
import baseball.application.result.CalculateResultApplication;
import baseball.application.numbers.GenerateAnswerApplication;
import baseball.application.numbers.GetUserAnswerApplication;
import baseball.application.result.GetResultApplication;

public class Application {

    static GenerateAnswerApplication generateAnswerController;
    static GetUserAnswerApplication getUserAnwerController;
    static CalculateResultApplication calculateResultController;
    static GetResultApplication getResultController;

    public static void main(String[] args) {

        generateAnswerController = new GenerateAnswerApplication();
        PrintStateApplication.printStartState();

        while (true){

            PrintStateApplication.printInputState();
            getUserAnwerController = new GetUserAnswerApplication();
            calculateResultController = new CalculateResultApplication();
            getResultController = new GetResultApplication();

            if (getResultController.getResult()){
                break;
            }
        }
    }
}
