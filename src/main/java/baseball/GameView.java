package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
	public void printStartMessage(){
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	//* 서로 다른 숫자 3자리가 아니면 Exception
	//* 숫자가 아니면 Exception 발생시키기
	public String getUserGuess(){
		System.out.print("숫자를 입력해주세요 : ");
		String userNumber = Console.readLine();
		return userNumber;
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


}
