package Controller;

import static Util.Validator.validateMenuChoice;

import Model.Computer;
import Model.User;
import Util.NumberCompare;
import View.InputView;
import View.OutputView;
import View.RetryView;
import camp.nextstep.edu.missionutils.Console;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private final RetryView retryView;

    private final NumberCompare numberCompare = new NumberCompare();

    public MainController(InputView inputView , OutputView outputView, RetryView retryView){
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryView = retryView;
    }

    public void run() throws IllegalArgumentException{
        try {

            outputView.printGameStart();
            Computer computer = new Computer();

            while (true) {
                inputView.printUserInput();
                User user = new User();
                int[] result = numberCompare.getNumberCount(computer.getComputerNumber(),
                        user.getuserNumber());
                resultPrint(result);
                if (correctNumber(result)) {
                    if (!retryGame()) {
                        break;
                    } else {
                        run();
                        break;
                    }
                }

            }
        } catch (IllegalArgumentException e){
            throw e;
        }

    }


    private void resultPrint(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] != 0 && result[1] == 0) {
            System.out.printf("%d 볼\n", result[0]);
        } else if (result[0] == 0) {
            System.out.printf("%d 스트라이크\n", result[1]);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", result[0], result[1]);
        }

    }

    private boolean correctNumber(int[] result){

        if(result[1]==3){
            return true;
        }

        return false;
    }

    private boolean retryGame() {
        retryView.RetryPrint();
        String retryNumber = Console.readLine();
        validateMenuChoice(retryNumber);
        return retryNumber.equals("1");
    }
}
