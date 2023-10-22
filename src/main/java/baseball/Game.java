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
		while(true) {
			System.out.print(Constants.INPUT_MSG);
			String input_str = Console.readLine();
			checkCondition(input_str);
			inputNum = setInputNum(input_str);
		
			if(checkResult() == true) //3스트라이크, 게임 종료
				break;
		}
		printStrike();
	}
	
	private void checkCondition(String str) {
		isRightLength(str);
		isRightDigit(str);
		isNotDuplicate(str);
	}
	
	private void isRightLength(String str) { //입력된 값이 3자리 수인지
		if(str.length() != Constants.DIGIT_SIZE)
			throw new IllegalArgumentException(Constants.WRONG_LENGTH_ERROR);
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
	
	private List<Integer> setInputNum(String str){ //입력값 타입 변경
		List<Integer> tmp = new ArrayList<>();
		for(int j = 0; j < str.length(); j++) {
			int num = Character.getNumericValue(str.charAt(j));
			tmp.add(num);
		}
		
		return tmp;
	}
	
	//결과
	private boolean checkResult() {
	      int strike = getStrike();
	      int ball = StrikeOrBall() - strike;

	      if(strike == Constants.DIGIT_SIZE)
	         return true;
	      else {
	         if(strike == 0 && ball == 0)//낫싱
	            printNothing();
	         else
	            printBall(strike, ball);
	      }
	      return false;
	   }

	
	private void printStrike() { //3스트라이크 결과 출력
	      System.out.println(Constants.SUCCESS_STR);
	      System.out.println(Constants.END_MSG); //success + restart 고려
	        
	        //restart() 재시작여부 확인 함수
	}
	
	private void printNothing() {
	      System.out.println(Constants.NOTHING_STR);
	}
	
	private void printBall(int str, int b) {
	      if(b != 0) {
	         if(str > 0) //볼 + 스트라이크
	            System.out.print(b + "볼 ");
	         else //3볼
	            System.out.println(b + "볼");
	      }
	      printResult(str);
	}
	
	private void printResult(int str) { //스트라이크, 스트라이크 + 볼, 볼
	      if(str != 0)
	         System.out.println(str + "스트라이크");
	      
	      getInputNum();
	}

	private int StrikeOrBall() {
		int cnt = 0;
		for(int k = 0; k <Constants.DIGIT_SIZE; k++)
			if(inputNum.contains(comNum.get(k)) == true)
				cnt++;
		
		return cnt;
	}

	private int getStrike() {
		int cnt = 0;
		for(int k = 0; k <Constants.DIGIT_SIZE; k++) {
			if(inputNum.contains(comNum.get(k)) == true) {//랜덤 수와 입력값에 중복 존재(스트라이크 or ball)
				if(inputNum.get(k) == comNum.get(k)) //같은 자리
					cnt++;
			}
		}
		return cnt;
	}
}
	