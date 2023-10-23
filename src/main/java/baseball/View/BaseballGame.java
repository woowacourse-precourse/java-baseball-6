package baseball.View;

import baseball.Controller.CheckNumberController;
import baseball.Controller.NumberController;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    NumberController numbers=new NumberController();

    CheckNumberController checkNumbers= new CheckNumberController();

    Integer[] userNumbers={};
    Integer[] randomNumbers={};
    public void run(){
        //게임 전체 루프
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            randomNumbers=numbers.createRandomNumber();

            do {
                readUserNumber();
            }while(!checkUserNumber());

        }
    }
    public void readUserNumber(){

        System.out.println("숫자를 입력해주세요 :");
        String userSay = readLine();
        userNumbers=numbers.getUserNumber(userSay);

    }
    public boolean checkUserNumber(){
        //검사
        //ball의 경우
        checkNumbers.countBall(userNumbers,randomNumbers);
        //strike의 경우
        checkNumbers.countStrike(userNumbers,randomNumbers);
        if(checkNumbers.isCorrected()) return true;
        else return false;
    }


}

