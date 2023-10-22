package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
//import java.util.List;

public class UserInput {
	private List<String> userInputList = new ArrayList<>();
	public void InputUserNum() {	
		userInputList.clear();
		System.out.printf("숫자를 입력해주세요 : ");
			String userNumber = Console.readLine();
			// 예외처리 1 : 세 자리 숫자가 아닌 수 입력
			if (userNumber.length() != 3) {
				throw new IllegalArgumentException("세 자리 숫자만 입력가능합니다.");
			}
			
			String inputNum_1 = userNumber.substring(0,1);
			String inputNum_2 = userNumber.substring(1,2);
			String inputNum_3 = userNumber.substring(2,3);
			
			// 예외처리 2 : 중복된 숫자 입력
			
			if (inputNum_1.equals(inputNum_2) || inputNum_1.equals(inputNum_3) || inputNum_2.equals(inputNum_3)) {
				throw new IllegalArgumentException("서로 다른 숫자만 입력가능합니다.");
			}
			
			
			// 예외처리 3 : 숫자가 아닌 문자열 입력
			
			
			
			char exceptCh_1 = inputNum_1.charAt(0);
			char exceptCh_2 = inputNum_2.charAt(0);
			char exceptCh_3 = inputNum_3.charAt(0);
			if (exceptCh_1 < '0' || exceptCh_1 > '9') {
				throw new IllegalArgumentException("숫자만 입력가능합니다.");
			}
			else {
				
			}
			if (exceptCh_2 < '0' || exceptCh_2 > '9') {
				throw new IllegalArgumentException("숫자만 입력가능합니다.");
			}
			else {
				
			}
			if (exceptCh_3 < '0' || exceptCh_3 > '9') {
				throw new IllegalArgumentException("숫자만 입력가능합니다.");
			}
			else {
				
			}
		
			
			userInputList.add(inputNum_1);
			userInputList.add(inputNum_2);
			userInputList.add(inputNum_3);
			//System.out.println(userInputList);
		
		//ComputerOutput comNum = new ComputerOutput();
			
				
		}	
	
	public List<String> getUserNum() {
		return userInputList;
	}
}
		
