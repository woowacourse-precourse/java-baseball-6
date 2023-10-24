package baseball;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
		
    	List<Integer> computer = new ArrayList<>();
    	while (computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
    
    	
		/*
		 * System.out.println("숫자 야구 게임을 시작합니다."); System.out.print("숫자를 입력해주세요 : ");
		 * 
		 * String gamerNum = Console.readLine();
		 * 
		 * System.out.println("프로그램 종료");
		 */
    	
    	System.out.println("computer : "  +computer);
    	//Console.readLine();
    }
}
