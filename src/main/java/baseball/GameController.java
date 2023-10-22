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

	//게임을 실행하는 메서드
	public void run(){
		boolean isRetry = true;
		//사용자가 재시도를 원할 떄까지 게임을 진행
		while(isRetry){
			runGame();
			isRetry = askRetry();
		}
	}

	//게임의 단계별 메서드를 호출하여 게임 진행하는 메서드
	private void runGame(){
		gameView.printStartMessage();
		//gameModel 생성 및 적용
		makeGame();

		List<Integer> computerNumber = gameModel.getComputerNumber();
		while(!gameModel.getIsCorrect()){
			handleGuess(computerNumber);
		}
	}

	//사용자의 재시도 여부를 묻는 메서드
	private boolean askRetry(){
		String retry = gameView.getRetry();
		boolean retryResult = false;
		if(retry.equals(Constants.RETRY_TRUE)){
			retryResult = true;
		}
		if(retry.equals(Constants.RETRY_FALSE)){
			retryResult = false;
		}
		return retryResult;
	}


	//게임 모델을 생성하는 메서드
	private void makeGame(){
		List<Integer> computerNumber = makeRandomNumber();
		//만들어진 숫자로 gameModel 생성
		GameModel gameModel = new GameModel(computerNumber);

		//만들어진 gameModel을 이 GameController의 gameModel에 할당
		this.gameModel = gameModel;
	}

	//랜덤 숫자를 생성하여 반환하는 메서드
	private List<Integer> makeRandomNumber(){
		List<Integer> computerNumber = new ArrayList<>();

		//Randoms의 메서드를 이용해 서로 다른 3자리의 숫자 생성
		while (computerNumber.size() < Constants.NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}
		return computerNumber;
	}

	//사용자의 예상숫자를 처리하는 메서드
	private void handleGuess(List<Integer> computerNumber){
		//user가 입력한 숫자를 받는다.
		String userGuess = gameView.getUserGuess();
		List<Integer> userGuessNumber = convertStringToList(userGuess);
		//user가 입력한 숫자에 대해 스트라이크와 볼의 개수를 프린트한다
		int numberOfStrike = countStrike(computerNumber, userGuessNumber);
		int numberOfBall = countBall(computerNumber, userGuessNumber);
		gameView.printGuessResult(numberOfStrike, numberOfBall);

		//숫자를 맞추었으면 맞추었다는 메세지를 프린트한다
		if(numberOfStrike == Constants.NUMBER_LENGTH){
			gameModel.setIsCorrect(true);
			gameView.printCorrectMessage();
		}
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
