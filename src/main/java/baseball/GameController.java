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
		}
	}

	private void runGame(){
		makeGame();
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
}
