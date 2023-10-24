package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Computer{
	
	public static List<Integer> randomList;
	public static Set<Integer> randomSet;

	public static void generate() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		
		randomList = new ArrayList<>(3);
		randomSet = new HashSet<Integer>(3);
		while (randomList.size() < 3) {
		    int randomNumber = Randoms.pickNumberInRange(1, 9);
		    if (!randomSet.contains(randomNumber)) {
		    	randomList.add(randomNumber);
		    	randomSet.add(randomNumber);
		    }
		}
    }
	
	public static Integer get(int index) {
		return randomList.get(index);
	}
	
	public static boolean contains(int n) {
		return randomSet.contains(n);
	}
}

class MyNumber{
	
	public static List<Integer> arr = new ArrayList<>(3);
	
	public static void input() throws IllegalArgumentException {
		System.out.print("숫자를 입력해주세요 : ");

		String data = Console.readLine();
		
		//1-9인 숫자가 아니거나, 길이가 3이 아니거나, 같은 숫자가 들어왔을 때
		if(data.length() != 3) {
			throw new IllegalArgumentException();
		}
		
		if(data.charAt(0) == data.charAt(1) | data.charAt(0) == data.charAt(2) | data.charAt(1) == data.charAt(2)) {
			throw new IllegalArgumentException();
		}
		
		if((int)data.charAt(0) < 49 | (int)data.charAt(0) > 57 | 
				(int)data.charAt(1) < 49 | (int)data.charAt(1) > 57 |
				(int)data.charAt(2) < 49 | (int)data.charAt(2) > 57) {
			throw new IllegalArgumentException();
		}
		
		int dataInt = Integer.parseInt(data);
	
		arr.add(0, dataInt/100);
		arr.add(1, (dataInt%100)/10);
		arr.add(2, dataInt%10);
    }
	
	public static Integer get(int index) {
		return arr.get(index);
	}
}

public class Application {
	
	public static int[] judge() {
		int[] result = {0,0};
		
		for(int i = 0; i < 3; i++) {
			if(MyNumber.get(i) == Computer.get(i)) { //스트라이크
				result[0]++;
			} else if (Computer.contains(MyNumber.get(i))) { //볼
				result[1]++;
			}
		}
		return result;
	}
	
	public static int printResult(int strike, int ball) throws IllegalArgumentException {
		if(strike == 3) {
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			
			String done = Console.readLine();

			if(done.equals("2")) {
				return 0;
			} else if (done.equals("1")) {
				return 2;
			} else { //1, 2가 아닌 다른 값일 때
				throw new IllegalArgumentException();
			}
		} else if(strike == 0 & ball == 0) {
			System.out.println("낫싱");
			return 1;
		} else if(strike == 0 & ball != 0) {
			System.out.println(ball + "볼");
			return 1;
		} else if(strike != 0 & ball == 0) {
			System.out.println(strike + "스트라이크");
			return 1;
		} else {
			System.out.println(ball + "볼 " + strike + "스트라이크");
			return 1;
		}
	}
	
    public static void main(String[] args) {
    	Computer.generate();
    	
    	int myBool = 1;
    	while(myBool != 0) {
    		MyNumber.input(); //입력 받기
    		int[] result = judge(); //판정
    		myBool = printResult(result[0], result[1]); //결과 출력
    		if(myBool == 2) { //게임 새로 시작
    			Computer.generate(); //숫자 다시 선택
    			myBool = 1;
    		}
    	}
    	return;
    }
}