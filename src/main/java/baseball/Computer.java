package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    int computerIdx = 0;
    int userIdx = 0;
    int strike = 0;
    int ball = 0;
    List<Integer> computer = new ArrayList<>(); // 컴퓨터가 생성한 난수 저장소
    boolean isOut = false;
    void setRandomNumber(){ // 난수 생성
        isOut = false;
        computer.clear();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    public void startGame(){ // 게임 시작 안내 멘트 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void isCorrect(User user){ // strike와 ball개수 세기
        for(int i : computer){
            for(int j : user.userNumberList){
                if(j==i && computerIdx == userIdx){
                    strike++;
                }else if(j==i){
                    ball++;
                }
                userIdx++;
            }
            computerIdx++;
            userIdx = 0;
        }
    }

    public void printResult(){
        if(strike == 0 && ball ==0){
            System.out.println("낫싱");
        }else if(strike!=0 && ball==0 && strike!=3){
            System.out.println(strike+"스트라이크");
        }else if(strike == 0){
            System.out.println(ball+"볼");
        }else if(strike==3){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isOut = true;
        }else{
            System.out.println(ball+"볼"+strike+"스트라이크");
        }
        strike = 0;
        ball = 0;
        computerIdx = 0;
        userIdx = 0;
    }
}
