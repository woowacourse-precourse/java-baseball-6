package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Integer> inputNum = new ArrayList<>();
	List<Integer> random = new ArrayList<>();

	boolean flag = false;
	Check check = new Check();
	
	public void init() {
		System.out.println(Constants.START_MSG);
		random = check.ready();
		getInputNum();
	}
	
	public void getInputNum() {
		System.out.print(Constants.INPUT_MSG);
		String input_str = Console.readLine();
		do {
			check.checkCondition(input_str);
			inputNum = check.setInputNum(input_str);
			checkResult();
		}while(!flag);
	}
	
	private void printStrike() {
		System.out.println(Constants.SUCCESS_STR);
		System.out.println(Constants.END_MSG);
		
		if (restart() == true) {
			init();
		}
		else {
			flag = true;
		}
	}

	private void printBall(int str, int b) {
		if (b != 0) {
			if (str > 0) //볼 + 스트라이크
				System.out.print(b + "볼 ");
			else { //3볼
				System.out.println(b + Constants.BALL_STR);
			}
		}
		printResult(str);
	}
	
	private void printNothing() {
		System.out.println(Constants.NOTHING_STR);
		getInputNum();
	}

	private void printResult(int str) {
		if (str != 0)
			System.out.println(str + Constants.STRIKE_STR);
		getInputNum();
	}
	
	private void checkResult() {
		int strike = getStrike();
		int ball = StrikeOrBall() - strike;

		if (strike == Constants.DIGIT_SIZE) {
			printStrike();
		}
		else {
			if (strike == 0 && ball == 0)
				printNothing();
			else
				printBall(strike, ball);
		}
	}
	
	private int StrikeOrBall() {
		int cnt = 0;
		for (int k = 0; k < Constants.DIGIT_SIZE; k++)
			if (inputNum.contains(random.get(k)) == true)
				cnt++;

		return cnt;
	}

	private int getStrike() {
		int cnt = 0;
		for (int k = 0; k < Constants.DIGIT_SIZE; k++) {
			if (inputNum.contains(random.get(k)) == true) {
				if (inputNum.get(k) == random.get(k))
					cnt++;
			}
		}
		return cnt;
	}

	private boolean restart() {
		System.out.println(Constants.RESTART_MSG);
		String reply = Console.readLine();
				
		if (reply.equals(Constants.INPUT_RESTART_STR))
			return true;
		else if (reply.equals(Constants.INPUT_TERMINATE_STR))
			return false;
		else
			throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
	}
}