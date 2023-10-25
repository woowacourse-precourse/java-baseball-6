package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputGame {

	public List<Integer> playerNumber(){
		System.out.println("숫자를 입력해주세요 : ");
		
		//Console.readLine() 으로 입력받기.
		List<Integer> playerNumber = new ArrayList<>();
		String inputNumber = Console.readLine();
		
		for(String num : inputNumber.split("")) {
			playerNumber.add(Integer.parseInt(num));
		}
		exception(inputNumber);
		
		return playerNumber;
	}
	//IllegalArgumentException
	public void exception(String s) {
		
		// 입력이 3자리인지 확인 
		if (s.length() != 3) {
			throw new IllegalArgumentException("3자리 수가 아닙니다.");
		}
		
		// 서로 다른 숫자인지 확인
		char[] digits = s.toCharArray();
		if (digits[0] == digits[1] || digits[1] == digits[2] || digits[0] == digits[2]) {
			throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
			
		}
		
		//0을 포함하는지 않는지 확인
		for (char digit : digits) {
			if (digit == '0') {
				throw new IllegalArgumentException("0이 아닌 1~9범위의 3가지 수를 입력해주세요.");
			}
		}
	}
	
}
