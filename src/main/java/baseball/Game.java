package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    public void play(){
        Computer computer = new Computer();
        ArrayList<Integer> computerNumber = computer.getRandomNumber();

        //상대방(컴퓨터)의 Random 3자리 수 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("상대방(컴퓨터)랜덤 숫자 제대로 나오는 것 확인 : ");
        System.out.println(computerNumber);
        int flag = 0;
        while(flag!=2){
            //사용자(사람)으로 부터 입력 받기
            User user = new User();
            ArrayList<Integer> userNumber = user.readNumber();

            Hint hint = new Hint();
            hint.allScore(computerNumber, userNumber);
            //flag = Integer.parseInt(Console.readLine());
        }
    }
}