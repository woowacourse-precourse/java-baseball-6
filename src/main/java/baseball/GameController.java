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

	public void run(){
		boolean isRetry = true;
		while(isRetry){
			runGame();
			isRetry = askRetry();
		}
	}

	private void runGame(){
		gameView.printStartMessage();
		makeGame();

		List<Integer> computerNumber = gameModel.getComputerNumber();
		while(!gameModel.getIsCorrect()){
			handleGuess(computerNumber);
		}
	}

	private boolean askRetry(){
		String retry = gameView.getRetry();
		boolean retryResult = false;
		if(retry.equals("1")){
			retryResult = true;
		}
		if(retry.equals("2")){
			retryResult = false;
		}
		return retryResult;
	}


	private void makeGame(){
		List<Integer> computerNumber = new ArrayList<>();

		//Randoms의 메서드를 이용해 서로 다른 3자리의 숫자 생성
		while (computerNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}

		//만들어진 숫자로 gameModel 생성
		GameModel gameModel = new GameModel(computerNumber);

		//만들어진 gameModel을 이 GameController의 gameModel에 할당
		this.gameModel = gameModel;
	}

	private void handleGuess(List<Integer> computerNumber){
		//*삭제예정
		System.out.println(gameModel.getComputerNumber());
		String userGuess = gameView.getUserGuess();
		List<Integer> userGuessNumbers = convertStringToList(userGuess);
		System.out.println(userGuessNumbers);

		int numberOfStrike = 0;
		int numberOfBall = 0;

		for(int i = 0; i < userGuessNumbers.size(); i++){
			int userGuessNumber = userGuessNumbers.get(i);
			//스트라이크인지 확인 (스트라이크이면 볼에 해당되면 안됨)
			if(computerNumber.get(i) == userGuessNumber){
				numberOfStrike++;
				continue;
			}
			//볼인지 확인
			if(computerNumber.contains(userGuessNumber)){
				numberOfBall++;
			}
		}
		System.out.println(numberOfBall);
		System.out.println(numberOfStrike);
		gameView.printGuessResult(numberOfStrike, numberOfBall);

		if(numberOfStrike == 3){
			gameModel.setIsCorrect(true);
			gameView.printCorrectMessage();
		}

	}

	private List<Integer> convertStringToList(String userGuess){
		List<Integer> resultList = new ArrayList<>();
		for (char c : userGuess.toCharArray()) {
			int digit = Character.getNumericValue(c);
			resultList.add(digit);
		}
		return resultList;
	}
}
