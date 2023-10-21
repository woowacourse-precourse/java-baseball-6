package baseball.controller;

import baseball.service.GameLogic;
import baseball.service.InputNumbers;
import baseball.vo.Computer;
import baseball.view.PrintMessage;
import baseball.vo.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBall {

    private Computer computer;

    private User user;
    //게임 시작
    public void startGame(){
        boolean playGame=true;
        PrintMessage.printGameStart();
        do{
            setComputer();
            playGame=doGame();
        }while (playGame);
    }

    public void setComputer(){
        List<Integer>randomNumbers= GameLogic.generateRandomNumbers();
        computer =new Computer(randomNumbers);
        System.out.println(computer);
    }

    public void userInput(){
        PrintMessage.requestNumber();
        user = InputNumbers.setInputNumber();
    }

    public boolean doGame(){
        boolean gameEnd=false;
        boolean retry=false;
        do {
            userInput();
            gameEnd=GameLogic.compareResult(computer,user);
        }while (!gameEnd);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input= Console.readLine();
        if(input.equals("1")){
            retry=true;
        }else if(input.equals("2")){
            retry=false;
        }
        return retry;
    }
}
