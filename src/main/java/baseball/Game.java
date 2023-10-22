package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Game {
	List<Integer> comNum = new ArrayList<>(); 
	List<Integer> inputNum = new ArrayList<>();

	public static void init() {
		Game game = new Game();
		System.out.println(Constants.START_MSG);
		game.ready();
	}

	private void ready() {
		while (comNum.size() < Constants.DIGIT_SIZE) {
			int randomNum = Randoms.pickNumberInRange(Constants.START_RANGE, Constants.END_RANGE);
			if (!comNum.contains(randomNum)) {
				comNum.add(randomNum);
			}
		}
		getInputNum();
	}

	private void getInputNum() {
		while (true) {
			System.out.print(Constants.INPUT_MSG);
			String input_str = Console.readLine();
			checkCondition(input_str);
			inputNum = setInputNum(input_str);

			if (checkResult() == true) //3스트라이크, 게임 종료
				break;
		}
	}

	private void checkCondition(String str) {
		isRightLength(str);
		isRightDigit(str);
		isNotDuplicate(str);
	}

	private void isRightLength(String str) {
		if (str.length() != Constants.DIGIT_SIZE)
			throw new IllegalArgumentException(Constants.WRONG_LENGTH_ERROR);
	}

	private void isRightDigit(String str) {
		String tmp = "^[1-9]*$";
		if (Pattern.matches(tmp, str) != true)
			throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
	}

	private void isNotDuplicate(String str) {
		for (int i = 0; i < str.length(); i++) {
			int firstInd = str.indexOf(str.charAt(i));
			if (firstInd != i)
				throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
		}
	}

	private List<Integer> setInputNum(String str) {
		List<Integer> tmp = new ArrayList<>();
		for (int j = 0; j < str.length(); j++) {
			int num = Character.getNumericValue(str.charAt(j));
			tmp.add(num);
		}
		return tmp;
	}

	private boolean checkResult() {
		int strike = getStrike();
		int ball = StrikeOrBall() - strike;

		if (strike == Constants.DIGIT_SIZE)
			printStrike();
		else {
			if (strike == 0 && ball == 0)
				printNothing();
			else
				printBall(strike, ball);
		}
		return true;
	}

	private void printStrike() {
		System.out.println(Constants.SUCCESS_STR);
		System.out.println(Constants.END_MSG);
		
		if (restart() == true)
			init();
	}

	private void printNothing() {
		System.out.println(Constants.NOTHING_STR);
		getInputNum();
	}

	private void printBall(int str, int b) {
		if (b != 0) {
			if (str > 0) //볼 + 스트라이크
				System.out.print(b + "볼 ");
			else //3볼
				System.out.println(b + "볼");
		}
		printResult(str);
	}

	private void printResult(int str) {
		if (str != 0)
			System.out.println(str + "스트라이크");

		getInputNum();
	}

	private int StrikeOrBall() {
		int cnt = 0;
		for (int k = 0; k < Constants.DIGIT_SIZE; k++)
			if (inputNum.contains(comNum.get(k)) == true)
				cnt++;

		return cnt;
	}

	private int getStrike() {
		int cnt = 0;
		for (int k = 0; k < Constants.DIGIT_SIZE; k++) {
			if (inputNum.contains(comNum.get(k)) == true) {
				if (inputNum.get(k) == comNum.get(k))
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