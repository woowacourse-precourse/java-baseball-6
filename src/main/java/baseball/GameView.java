//GameView.java
package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
	public void printStartMessage(){
		System.out.println(Constants.START_MESSAGE);
	}

	public String getUserGuess(){
		System.out.print(Constants.GUESS_MESSAGE);
		String input = Console.readLine();
		validateUserGuess(input);
		return input;
	}

	private void validateUserGuess(String input) {
		// 숫자로만 이루어져 있는지 확인
		boolean isOnlyNumber = input.matches("\\d+");
		// 3자리인지 확인
		boolean isRightSize = input.length() == Constants.NUMBER_LENGTH;

		if (!isOnlyNumber || !isRightSize) {
			throw new IllegalArgumentException(Constants.INVALID_LENGTH_ERROR);
		}

		// 숫자가 서로 다른지 확인
		if (!hasUniqueDigits(input)) {
			throw new IllegalArgumentException(Constants.DUPLICATE_DIGITS_ERROR);
		}
	}

	// 사용자 입력에 중복된 숫자가 있는지 확인
	private boolean hasUniqueDigits(String input) {
		for (char c : input.toCharArray()) {
			if (input.indexOf(c) != input.lastIndexOf(c)) {
				return false;
			}
		}
		return true;
	}

	public void printGuessResult(int numberOfStrike, int numberOfBall){
		StringBuilder guessResult = new StringBuilder();
		if(numberOfBall > 0){
			guessResult.append(numberOfBall).append("볼").append(" ");
		}
		if(numberOfStrike > 0){
			guessResult.append(numberOfStrike).append("스트라이크");
		}
		if(numberOfStrike == 0 && numberOfBall == 0){
			guessResult.append("낫싱");
		}
		System.out.println(guessResult);
	}

	public void printCorrectMessage(){
		System.out.println(Constants.CORRECT_MESSAGE);
	}

	//0 혹은 1이 아니면 예외
	public String getRetry(){
		System.out.println(Constants.RETRY_MESSAGE);
		String input = Console.readLine();
		validateRetry(input);
		return input;
	}

	private void validateRetry(String input){
		boolean isOneOrTwo = input.equals(Constants.RETRY_TRUE) || input.equals(Constants.RETRY_FALSE);
		if(!isOneOrTwo){
			throw new IllegalArgumentException(Constants.INVALID_RETRY_INPUT_ERROR);
		}
	}
}
