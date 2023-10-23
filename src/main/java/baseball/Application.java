package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import baseball.ComputerNum;

public class Application {
    public static void main(String[] args) {
        
    	System.out.println("숫자 야구 게임을 시작합니다.");

    	while(true) {
    		// 랜덤 숫자 추출
    		ComputerNum computerNum = new ComputerNum();
    		List<Integer> answer = computerNum.getNumber();
    		
    	}
    }
}
