package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.model.NumberComparator;



import baseball.view.InputView;

import java.util.List;

public class GameController {

    private final ComputerNumber computer;
    private static UserNumber user;


    public GameController() {
        computer = new ComputerNumber();
    }

    public void start() {
        getNumberFromUser();
        getNumberCompare();

    }

    public  void getNumberFromUser(){
        user = new UserNumber(InputView.UserNumbertoList());//user에 vailidate에 입력으로 넣을 예정
    }

    public void getNumberCompare(){
        NumberComparator.compareNumber(ComputerNumber.generateComputerNumbers(),InputView.UserNumbertoList());

    }

    public void printCount(){

    }

    public void printStrike(){

    }

    public void printBall(){

    }

    public void printNothing(){

    }

//    public boolean isGameSet(){
//
//    }
}
