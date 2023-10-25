//GameController.java
package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
	private GameView gameView;
	private GameModel gameModel;

	public GameController(GameView gameView){
		this.gameView = gameView;
	}

	//게임 실행
	public void run(){
		boolean isRetry = true;
		while(isRetry){
			runGame();
			isRetry = askRetry();
		}
	}

	//게임의 단계별 메서드를 호출하여 게임 진행
	private void runGame(){
		gameView.printStartMessage();
		List<Integer> computerNumber = makeComputerNumber();
		this.gameModel = makeGameModelInstance(computerNumber);

		while(!gameModel.getIsCorrect()){
			handleGuess(gameModel.getComputerNumber());
		}
	}

	//사용자의 재시도 의사 확인
	private boolean askRetry(){
		boolean retryResult = false;

		String input = gameView.getRetry();
		if(input.equals(Constants.RETRY_TRUE)){
			retryResult = true;
		}
		if(input.equals(Constants.RETRY_FALSE)){
			retryResult = false;
		}
		return retryResult;
	}

	//GameModel 인스턴스 생성
	private GameModel makeGameModelInstance(List<Integer> computerNumber){
		return new GameModel(computerNumber);
	}


	//컴퓨터 숫자 생성
	private List<Integer> makeComputerNumber(){
		List<Integer> computerNumber = new ArrayList<>();

		while (computerNumber.size() < Constants.NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}
		return computerNumber;
	}

	//사용자의 예상 숫자 처리
	private void handleGuess(List<Integer> computerNumber){
		String input = gameView.getUserGuess();
		List<Integer> userGuessNumber = convertStringToList(input);

		int numberOfStrike = countStrike(computerNumber, userGuessNumber);
		int numberOfBall = countBall(computerNumber, userGuessNumber);
		gameView.printGuessResult(numberOfStrike, numberOfBall);

		boolean isCorrect = numberOfStrike == Constants.NUMBER_LENGTH;
		if(isCorrect){
			handleIsCorrect();
		}
	}
	private void handleIsCorrect(){
		gameModel.setIsCorrect(true);
		gameView.printCorrectMessage();
	}

	//스트라이크의 수 계산
	private int countStrike(List<Integer> computerNumber, List<Integer> userGuessNumber){
		int strikeCount = 0;
		for(int i = 0; i < Constants.NUMBER_LENGTH; i++){
			int number = userGuessNumber.get(i);
			if(computerNumber.get(i).equals(number)){
				strikeCount++;
			}
		}
		return strikeCount;
	}

	//볼의 수 계산
	private int countBall(List<Integer> computerNumber, List<Integer> userGuessNumber){
		int ballCount = 0;

		for(int i = 0; i < Constants.NUMBER_LENGTH; i++){
			int number = userGuessNumber.get(i);
			if(computerNumber.get(i) != number && computerNumber.contains(number)){
				ballCount++;
			}
		}
		return ballCount;
	}

	//문자열을 정수 리스트로 반환
	private List<Integer> convertStringToList(String userGuess){
		List<Integer> resultList = new ArrayList<>();
		for (char c : userGuess.toCharArray()) {
			int digit = Character.getNumericValue(c);
			resultList.add(digit);
		}
		return resultList;
	}
}
