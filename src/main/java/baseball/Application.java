package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	List<Integer> computerNum = setComputerNum();
    	System.out.println(computerNum);
    	while(true) {
    	List<Integer> userNum = inputUserNum();
    	checkNum(computerNum,userNum);
    	int isReplay = Integer.parseInt(Console.readLine());
    	if(isReplay == 1) continue;
    	else break;
    	}
    }
    
    //상대방 슷자 셋팅
    public static List<Integer> setComputerNum(){
    	List<Integer> computerNum = new ArrayList<>();
    	while (computerNum.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computerNum.contains(randomNumber)) {
    	        computerNum.add(randomNumber);
    	    }
    	}
    	return computerNum;
    }
    
    //사용자 숫자 입력
    public static List<Integer> inputUserNum(){
    	System.out.println("숫자를 입력해주세요 : ");
    	List<Integer> userNum = new ArrayList<>();
    	int tmpUserNum = Integer.parseInt(Console.readLine());
    	if(tmpUserNum<100||tmpUserNum>999) {
    		throw new IllegalArgumentException();
    	}
    	userNum.add(tmpUserNum/100);
    	userNum.add(tmpUserNum/10%10);
    	userNum.add(tmpUserNum%10);
    	return userNum;
    }
    
    //이 메서드는 클래스로만들어 객체화하는게 낫지않을까?
    public static void checkNum(List<Integer> computerNum, List<Integer> userNum) {
    	
}
}