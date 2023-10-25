package baseball;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    
	public static List<Integer> makeRandomNumber () {
		List<Integer> computer = new ArrayList<>();
    	while (computer.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computer.contains(randomNumber)) {
    	        computer.add(randomNumber);
    	    }
    	}
    	return computer;
	}
	
	public static boolean checkDuplicate(String gamersNum) {
		for (int z = 0; z < gamersNum.length(); z++) {
			char oneChar = gamersNum.charAt(z);
			
			for (int x = z+1; x < gamersNum.length(); x++) {
				if (oneChar == gamersNum.charAt(x)) {
					System.out.print("중복된 숫자는 입력할 수 없습니다. 서로 다른 세자리수를 입력해 주세요. : ");
					return true;
				}
			}
		}
		return false;
	}
	
	public static List<Integer> sringToIntList(String gamersNum) {
		
		List<Integer> numberList = new ArrayList<>();
		
		for (int i = 0; i < gamersNum.length(); i++) {
			numberList.add(gamersNum.charAt(i) - '0');
		}
		
		return numberList;
	}
	
	public static List<Integer> getInputNumber(){
		System.out.print("숫자를 입력해주세요 : ");
		String gamersNum = Console.readLine();
		if (gamersNum.length() > 3) {
			throw new IllegalArgumentException("3글자 이상의 값은 입력할 수 없습니다.");
		} 
		
		boolean checkDuplicate = checkDuplicate(gamersNum);
		if (checkDuplicate) {
			throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
		}
		
		return sringToIntList(gamersNum);
	}
	
	
	public static void main(String[] args) {
    	
		System.out.println("숫자 야구 게임을 시작합니다."); 
		
		List<Integer> computer = makeRandomNumber();
    	System.out.println(computer);
		
		while (true) {
			int ball = 0;
			int strike = 0;

    		List<Integer> gamersNumList = getInputNumber();
    		
    		for (int j = 0; j < gamersNumList.size(); j++) {
    			
    			boolean isGamersNumExists = computer.contains(gamersNumList.get(j));
    			if (isGamersNumExists == true) {
    				ball += 1;
    			}
    			
    			if (computer.get(j) == gamersNumList.get(j)) {
    				strike += 1;
    			}
    		}
    		
    		if (strike == 3) {
    			System.out.println(strike + "스트라이크");
    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    	    	int reTryOrNot = Integer.parseInt(Console.readLine());
    	    	
    	    	if (reTryOrNot == 1) {
    	    		computer = makeRandomNumber();
    	        	System.out.println(computer);
    	    		continue;
    	    	} else if (reTryOrNot == 2){
    	    		System.out.println("게임 끝!");
    	    		break;
    	    	}
    	    } else if (ball != 0 && strike != 0) {
    			System.out.println(ball + "볼 " + strike + "스트라이크"); 
    		} else if (ball != 0) {
    			System.out.println(ball + "볼");
    		} else if (strike != 0){
    			System.out.println(strike + "스트라이크");
    		} else {
    			System.out.println("낫싱");
    		}
    	}
    }
}
