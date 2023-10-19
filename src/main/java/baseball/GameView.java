package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
	public void printStartMessage(){
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public String getUserGuess(){
		System.out.print("숫자를 입력해주세요 : ");
		String userNumber = Console.readLine();
		validateUserGuess(userNumber);
		return userNumber;
	}

	private void validateUserGuess(String userNumber){
		boolean isOnlyNumber = userNumber.matches("\\d+");
		boolean isRightSize = userNumber.length() == 3;

		if(!isOnlyNumber || !isRightSize){
			throw new IllegalArgumentException("[ERROR] 3자리 수를 입력해주세요");
		}

		List<Character> uniqueDigits = new ArrayList<>();
		for(char c : userNumber.toCharArray()){
			if(uniqueDigits.contains(c)){
				throw new IllegalArgumentException("[ERROR] 서로 다른 3자리 숫자를 입력해주세요");
			}
			if (!uniqueDigits.contains(c)) {
				uniqueDigits.add(c);
			}
		}

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
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	//0 혹은 1이 아니면 예외
	public String getRetry(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String retry = Console.readLine();
		validateRetryInput(retry);
		return retry;
	}

	private void validateRetryInput(String retry){
		boolean isOneOrTwo = retry.equals("1") || retry.equals("2");
		if(!isOneOrTwo){
			throw new IllegalArgumentException("[ERROR] 1 혹은 2로 입력해주세요");
		}
	}




}
