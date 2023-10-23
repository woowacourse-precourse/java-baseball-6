package baseball;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    private String computerNum;
    private String userNum;
    // 생성자
    public Baseball(){
        initBaseball();
    }


    public void initBaseball(){
        // 컴퓨터 수 세팅
        this.computerNum=setComputerNum();
        // 사용자 입력 숫자 초기화
        this.userNum="";
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

//        String a=Console.readLine();

    }
}
