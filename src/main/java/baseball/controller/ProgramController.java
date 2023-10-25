package baseball.controller;

import baseball.view.OutputView;

import java.util.List;

import baseball.model.NumberOfGame;
import baseball.view.InputView;

public class ProgramController {
	
	private String COLLECT_ANSWER = "3스트라이크";
	
	private NumberOfGame numbers = new NumberOfGame();
	
	private OutputView outputView = new OutputView();
	private InputView inputView = new InputView();
	
	private DetermineNumberController determineNumber = new DetermineNumberController();
	private ComputerNumberController computerNumber = new ComputerNumberController();
	private HintController hint = new HintController();
	
	
	public void startProgram() {
		boolean finish = false;
		
		outputView.startGameMessage();
		
		while(!finish) {
			startGame();
			finish = (inputView.restartGameOrFinish() == 2);
		}
		
	}
	
	private void startGame() {
		setComputerNumber();
		do {
			setUserNumber();
			outputView.hintMessage(hint.hintMessage(numbers.getComputerNumber(), numbers.getUserNumber()));
		}while(!is3Strike());
		outputView.endGameMessage();
	}
	
	private boolean is3Strike() {
		return hint.hintMessage
				(numbers.getComputerNumber(), numbers.getUserNumber()).equals(COLLECT_ANSWER);
	}
	
	private void setComputerNumber() {
		numbers.setComputerNumber(computerNumber.madeComputerNumber());
	}
	private void setUserNumber() {
		String inputNumber = inputView.inputNumber();
		List<Integer> userNum = determineNumber.isPossibleNumber(inputNumber);
		numbers.setUserNumber(userNum);
	}
	
}
