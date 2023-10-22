package baseball.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.constant.Constant;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.Counter;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.View;

public class BaseballController {
	private static BaseballController baseballController = new BaseballController();
	// View
	private View view = new View();
	private OutputView outputView = view.outputView;
	private InputView inputView = view.getInputView();
	// Model
	private Computer computer = new Computer();
	private Player player = new Player();
	// Util
	private Validator validator = new Validator();
	private Counter counter = new Counter();

	private BaseballController() {
	}

	public static BaseballController getInstance() {
		return baseballController;
	}

	public void runGame() {
		outputView.printStartMessage();

		while (true) {
			play();
			if (quit())
				break;
		}
	}

	public void play() {
		computer.generateRandomNumbers();
		
		while (true) {
			this.counter = new Counter();
			
			outputView.printInputMessage();
			String playerInput = inputView.getInputLine();
			if (!validator.gameInputVaildate(playerInput))
				throw new IllegalArgumentException();
			outputView.printInputMessage(playerInput);
			player.setNumbers(playerInput);
			
			compare(computer.getNumbers(), player.getNumbers());
			showResult();
			if (threeStrike())
				break;
		}
	}

	public void compare(List<Integer> computerNumbers, int[] playerNumbers) {
		for (int i = 0; i < computerNumbers.size(); i++) {
			int computerNumber = computerNumbers.get(i);
			int playerNumber = playerNumbers[i];

			if (computerNumber == playerNumber)
				counter.setStrikeCount(counter.getStrikeCount() + 1);
			else if (computerNumbers.contains(playerNumber))
				counter.setBallCount(counter.getBallCount() + 1);
		}
	}

	public void showResult() {
		int ballCount = counter.getBallCount();
		int strikeCount = counter.getStrikeCount();

		StringBuffer result = new StringBuffer();
		
		if (ballCount == 0 && strikeCount == 0) {
			result.append("낫싱");
		}
		if (ballCount != 0) {
			result.append(ballCount + "볼 ");
		}
		if (strikeCount != 0)
			result.append(strikeCount + "스트라이크");
		
		outputView.printResultMessage(result.toString().trim());
	}

	public Boolean threeStrike() {
		Map<String, String> map = new HashMap<>();
		map.put("maxDigit", Integer.toString(Constant.MAX_DIGIT));
		int strikeCount = counter.getStrikeCount();
		if (strikeCount == Constant.MAX_DIGIT) {
			outputView.printGameEndMessage(map);
			return true;
		}
		return false;
	}
	
	public void showToBeContinue(){
		Map<String, String> map = new HashMap<>();
		map.put("continueInput", Constant.CONTINUE_INPUT);
		map.put("quitInput", Constant.QUIT_INPUT);
		outputView.printContinueOrQuitMessage(map);
	}
	
	public Boolean quit() {
		showToBeContinue();
		
		String input = inputView.getInputLine();

		if (!validator.quitInputValidate(input))
			throw new IllegalArgumentException();

		outputView.printContinueOrQuitMessage(input);
		
		if (input.equals(Constant.QUIT_INPUT)) {
			outputView.printQuitMessage();
			return true;
		}

		return false;
	}
}
