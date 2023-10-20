package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
	List<Integer> comNum = new ArrayList<>(); //컴퓨터 생성 랜덤 숫자
	List<Integer> inputNum = new ArrayList<>(); //입력값

	 //게임 시작
	public static void init() {
		Game game = new Game();
		System.out.println(Constants.START_MSG);
		game.ready();
	}
	
	//랜덤 수 생성
	private void ready() {
		while(comNum.size() < Constants.DIGIT_SIZE) { //서로 다른 세자리 수 생성
	         int randomNum = Randoms.pickNumberInRange(Constants.START_RANGE, Constants.END_RANGE);
	         if(!comNum.contains(randomNum)) {
	            comNum.add(randomNum);
	         }
	      } 
		
		getInputNum();
	}
	
	private void getInputNum() {
		System.out.print(Constants.INPUT_MSG);
		String str = Console.readLine();
		
		isRightLength(str);
	}
	
	private void isRightLength(String str) { //입력된 값이 3자리 수인지
		if(str.length() != Constants.DIGIT_SIZE)
			throw new IllegalArgumentException(Constants.WRONG_LENGTH_ERROR);
		
		isRightDigit(str);
	}
	
	private void isRightDigit(String str) { //입력된 값이 0을 제외한 정수인지
		String tmp = "^[1-9]*$";
		if(Pattern.matches(tmp, str) != true)
			throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
	}
	
	private void isNotDuplicate(String str) { //중복되는 수가 있는지
		for(int i = 0; i < str.length(); i++) {
			int firstInd = str.indexOf(str.charAt(i));
			if(firstInd != i)
				throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
		}
	}
}
