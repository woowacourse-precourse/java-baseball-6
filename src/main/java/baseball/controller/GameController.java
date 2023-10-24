package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.model.NumberComparator;


import baseball.util.Result;
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
            result = getNumberCompare();
            System.out.println(computer.getNumbers());
            printCount(result);
        } while (!isGameSet(result));

    }

    public List<String> getNumberFromUser(){
        return InputView.UserNumbertoList();
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
        InputView.restart();
        }
        return false;
    }

}
