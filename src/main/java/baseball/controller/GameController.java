package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.NumberComparator;
import baseball.util.Result;
import baseball.vailidation.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;


public class GameController {

    private final ComputerNumber computer;


    public GameController() {
        computer = new ComputerNumber();
    }

    public void start() {
        Result result;
        do {
            System.out.println(computer.getNumbers());
            result = getNumberCompare();
            printCount(result);
        } while (!isGameSet(result));

    }

    public List<String> getNumberFromUser(){
        List<String> VaildateNumber = InputView.UserNumbertoList();

        NumberValidator.checkLength(VaildateNumber);
        NumberValidator.checkRedundancy(VaildateNumber);
        NumberValidator.checkZero(VaildateNumber);

        return VaildateNumber;
    }

    public Result getNumberCompare(){
        return NumberComparator.compareNumber(computer.getNumbers(),getNumberFromUser());

    }

    public void printCount(Result count){
        OutputView.printResultMessage(count.ball, count.strike);
    }



    public boolean isGameSet(Result count) {
        if(count.strike == 3){
            OutputView.printGameSetMessage();
            computer.resetNumbers();
        }
        return true;
    }

}
