package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	while (true) {
    		
    		try {
    			baseballGame();
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				break;
			}
    		
    		
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		
    		try {
    			String restartOrEnd = Console.readLine();
    			
    			if (!(restartOrEnd.equals("1") || restartOrEnd.equals("2"))) {
    				throw new IllegalArgumentException("1, 2가 아닌 다른 숫자를 입력했습니다.");
    			}
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				
				break;
			}
    		
    		
    	}
    }
    
    private static void baseballGame() throws IllegalArgumentException {
    	
    	List<Integer> com = pickNumbers();
    	
    	while (true) {
    		System.out.print("숫자를 입력해주세요 : ");
        	String userPick = Console.readLine();
        	
    		List<Integer> user = new ArrayList<Integer>();
    		
    		for (int i = 0; i < userPick.length(); i++) {
    			char nxtPick = userPick.charAt(i);
    			int cvt = nxtPick - '0';
    			user.add(cvt);
    		}
    		
    		int[] result = checkNumbers(com, user);
    		
    		if (result[0] == 3) {
    			System.out.println("3스트라이크");
    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    			break;
    		} else if (result[0] == 0 && result[1] == 0) {
    			System.out.println("낫싱");
    		} else {
    			System.out.printf("%d스트라이크 %d볼%n", result[0], result[1]);
    		}
    	}
    }
    
    private static List<Integer> pickNumbers() {
    	List<Integer> numbers = new ArrayList<Integer>();
    	
    	while (numbers.size() < 3) {
    		int ranNum = Randoms.pickNumberInRange(1, 9);
    		
    		if(!numbers.contains(ranNum)) {
    			numbers.add(ranNum);
    		}
    	}
    	
    	return numbers;
    }
    
    private static int[] checkNumbers(List<Integer> comPick, List<Integer> userPick) {
    	
    	int[] result = new int[2]; // 0 : Strike, 1 : Ball
    	
    	for (int i = 0; i < comPick.size(); i++) {
			for (int j = 0; j < comPick.size(); j++) {
				if (i == j && userPick.get(i) == comPick.get(j)) {
					result[0]++;
				} else if (userPick.get(i) == comPick.get(j)) {
					result[1]++;
				} else {}
			}
		}
    	
    	return result;
    	
    }
}