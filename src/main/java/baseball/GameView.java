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
		String userNumber = Console.readLine();
		validateUserGuess(userNumber);
		return userNumber;
	}

	private void validateUserGuess(String userNumber) {
		// 숫자로만 이루어져 있는지 확인
		boolean isOnlyNumber = userNumber.matches("\\d+");
		// 3자리인지 확인
		boolean isRightSize = userNumber.length() == Constants.NUMBER_LENGTH;

		if (!isOnlyNumber || !isRightSize) {
			throw new IllegalArgumentException(Constants.INVALID_LENGTH_ERROR);
		}

		// 숫자가 서로 다른지 확인
		if (!hasUniqueDigits(userNumber)) {
			throw new IllegalArgumentException(Constants.DUPLICATE_DIGITS_ERROR);
		}
	}

	// 사용자 입력에 중복된 숫자가 있는지 확인
	private boolean hasUniqueDigits(String userNumber) {
		for (char c : userNumber.toCharArray()) {
			if (userNumber.indexOf(c) != userNumber.lastIndexOf(c)) {
				return false;
			}
		}
		return true;
	}

	public void printGuessResult(int numberOfStrike, int numberOfBall){
		StringBuilder guessResult = new StringBuilder();
		if(numberOfBall > 0){
			guessResult.append(numberOfBall).append("볼 ");
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
		String retry = Console.readLine();
		validateRetryInput(retry);
		return retry;
	}

	private void validateRetryInput(String retry){
		boolean isOneOrTwo = retry.equals(Constants.RETRY_TRUE) || retry.equals(Constants.RETRY_FALSE);
		if(!isOneOrTwo){
			throw new IllegalArgumentException(Constants.INVALID_RETRY_INPUT_ERROR);
		}
	}
}
