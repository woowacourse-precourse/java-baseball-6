package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
    	System.out.print("숫자 야구 게임을 시작합니다.");
    	
    	List<Integer> randomList = new ArrayList<Integer>();
    	for(int i=0; i < 3; i++) {
    		randomList.add(Randoms.pickNumberInRange(1, 9));
    	}
    	checkRandomNum(randomList);
    	
    	System.out.println(randomList);
    	
    	boolean n = true;
    	while(n) {
    		n = BaseballGame(randomList);
    	}
    }

	public static boolean BaseballGame(List<Integer> randomList) throws IllegalArgumentException {
		System.out.println();
    	System.out.print("숫자를 입력해주세요 : ");
    	String textNum = Console.readLine().trim();
    	List<Integer> inputList = new ArrayList<>();
    	for(int i = 0; i < textNum.length(); i++) {
    		int input = Integer.valueOf(textNum.substring(i, i + 1));
    		inputList.add(input); 
    	}
    	checkInput(inputList);
    	
    	int strike = 0;
    	int ball = 0;
    	for(int i = 0; i < randomList.size(); i++) {
    		for(int j = 0; j < inputList.size(); j++) {
    			if(randomList.get(i) == inputList.get(j) && i == j) {
    				strike++;
    			} else if(randomList.get(i) == inputList.get(j)) {
    				ball++;
    			}
    		}
    	}
    	
    	if(strike == 0 && ball == 0) {
    		System.out.print("낫싱");
    	} else {
	    	if(ball > 0) {
	    		System.out.print(ball + "볼 ");
	    	}
	    	
	    	if(strike > 0) {
	    		System.out.print(strike + "스트라이크");
	    	}
	    	
	    	if(strike == 3) {
	    		System.out.println();
    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    			int input = Integer.valueOf(Console.readLine());
    			if(input == 1) {
    				main(null);
    				return false;
    			} else if(input == 2){
    				System.out.print("게임종료");
    				return false;
    			}
    		}
    	}
    	return true;
    }
	
    private static void checkRandomNum(List<Integer> randomList) {
    	for(int i = 0; i < randomList.size(); i++) {
    		for(int j = i+1; j < randomList.size(); j++) {
    			if(randomList.get(i) == randomList.get(j)) {
    				randomList.set(j, Randoms.pickNumberInRange(1, 9));
    			}
    		}
    	}
	}

	private static void checkInput(List<Integer> inputList) {
		if(inputList.size() != 3) {
    		throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
    	}
		
		for(int i = 0; i < inputList.size(); i++) {
    		for(int j = i+1; j < inputList.size(); j++) {
    			if(inputList.get(i) == inputList.get(j)) {
    				throw new IllegalArgumentException("중복된 숫자는 불가합니다.");
    			}
    		}
    	}
	}
}
