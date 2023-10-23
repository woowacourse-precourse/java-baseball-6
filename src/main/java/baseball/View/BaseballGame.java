package baseball.View;

import baseball.Controller.NumberController;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    NumberController numbers=new NumberController();


    Integer[] userNumbers={};
    Integer[] randomNumbers={};
    public void run(){
        //게임 전체 루프
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            randomNumbers=numbers.createRandomNumber();

            readUserNumber();

        }
    }
    public void readUserNumber(){
        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            String userSay = readLine();
            userNumbers=numbers.getUserNumber(userSay);
        }
    }


}

