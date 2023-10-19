package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	do {
    		
    		baseballGame();
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		
    	} while (continueGame());
    }
    
    private static void baseballGame() {
    	
    	List<Integer> com = getComNumbers();
    	
    	while (true) {
    		List<Integer> user = getUserNumbers();
    		
    		int[] result = checkNumbers(com, user);
    		
    		StringBuilder sb = new StringBuilder();
    		
    		if (result[0] > 0) sb.append(result[0] + "볼 ");
    		if (result[1] > 0) sb.append(result[1] + "스트라이크");
    		if (sb.isEmpty()) sb.append("낫싱");
    		
    		System.out.println(sb.toString());
    		
    		if (result[1] == 3) {
    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    			break;
    		}
    	}
    }
    
    private static List<Integer> getComNumbers() {
    	List<Integer> numbers = new ArrayList<Integer>();
    	
    	while (numbers.size() < 3) {
    		int ranNum = Randoms.pickNumberInRange(1, 9);
    		
    		if(!numbers.contains(ranNum)) {
    			numbers.add(ranNum);
    		}
    	}
    	
    	return numbers;
    }
    
	private static List<Integer> getUserNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		String userPick = Console.readLine();
		
		if (userPick.length() != 3) throw new IllegalArgumentException("세 자리 숫자를 입력해 주세요.");
		
		List<Integer> user = new ArrayList<Integer>();
		
		for (char nxtPick : userPick.toCharArray()) {
			
			
			if (!Character.isDigit(nxtPick)) throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
			
			int cvt = nxtPick - '0';
			
			if (user.contains(cvt)) throw new IllegalArgumentException("동일한 숫자는 입력할 수 없습니다.");
			
			if (cvt == 0) throw new IllegalArgumentException("0은 숫자 야구 게임이 포함되지 않습니다.");
			
			user.add(cvt);
		}

		return user;
	}
    
    private static int[] checkNumbers(List<Integer> comPick, List<Integer> userPick) {
    	
    	int[] result = new int[2]; // 0 : Ball, 1 : Strike
    	
    	for (int i = 0; i < comPick.size(); i++) {
			for (int j = 0; j < comPick.size(); j++) {
				if (i == j && userPick.get(i) == comPick.get(j)) {
					result[1]++;
				} else if (userPick.get(i) == comPick.get(j)) {
					result[0]++;
				} else {}
			}
		}
    	
    	return result;
    	
    }
    
    private static boolean continueGame() {
		
    	String input = Console.readLine();
    	
    	if (input.equals("1")) {
    		return true;
    	} else if (input.equals("2")) {
    		return false;
    	} else {
    		throw new IllegalArgumentException("1, 2 중에서 입력해 주세요!");
    	}
    }
}