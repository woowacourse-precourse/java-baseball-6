package baseball;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private String computerNum;
//    private String userNum;
    // 생성자
    public Baseball(){
        initBaseball();
    }


    public void initBaseball(){
        // 컴퓨터 수 세팅
        this.computerNum=setComputerNum();
        // 사용자 입력 숫자 초기화
//        this.userNum="";
    }

    public String setComputerNum(){
        String computer = "";

        while(computer.length()<3) {
            // 서로 다른 세자리 수 생성
            int randomNum = Randoms.pickNumberInRange(1, 9);
            String numToString=Integer.toString(randomNum);

            if (!computer.contains(numToString)) {
                computer = computer.concat(numToString);
            }
        }

        return computer;
    }

    public void playBaseball(){
        System.out.println("숫자 야구 게임을 시작합니다.");
//        System.out.println(computerNum);
        do {
            int strikeNum=0;
            int ballNum=0;

            System.out.print("숫자를 입력해주세요 : ");
            String input=Console.readLine();


            for(int i=0;i<3;i++){
                if(input.charAt(i)==computerNum.charAt(i)) strikeNum++;
                else if(computerNum.contains(String.valueOf(input.charAt(i)))){
                    ballNum++;
                }
            }
            System.out.println(strikeNum+"스트라이크 "+ballNum+"볼");
            if(strikeNum==3) break;
        }while(true);

    }
}
