package baseball.controller;

import baseball.service.RandomNumbers;
import baseball.view.PrintMessage;

public class BaseBall {

    private RandomNumbers randomNumbers;
    //게임 시작
    public void startGame(){
        boolean playGame=true;
        PrintMessage.printGameStart();
        getRandomNumbers();

    }

    public void getRandomNumbers(){
        randomNumbers=new RandomNumbers();
        System.out.println(randomNumbers);
    }

    
}
