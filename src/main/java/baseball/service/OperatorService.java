package baseball.service;

import baseball.vo.enums.GameRule;
import baseball.vo.enums.UserInterfaceMessage;
import baseball.vo.enums.ValidationMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OperatorService {
	private List<Integer> playerGameNumberList;

	private OperatorService() {
	}

	private static class OperatorServiceHolder {
		private static final OperatorService OPERATOR_SERVICE = new OperatorService();
	}

	public static OperatorService getInstance() {
		return OperatorServiceHolder.OPERATOR_SERVICE;
	}

	public void validateGameNumber(String inputGameNumber) {
		ValidationMessage validationMessage = validateUserInputCase(inputGameNumber);
		if (validationMessage != ValidationMessage.PROPER_TYPE) {
			System.out.println(validationMessage.getValue());
			throw new IllegalArgumentException(validationMessage.getValue());
		}
	}

	private ValidationMessage validateUserInputCase(String userInput) {
		if (userInput == null) return ValidationMessage.NULL_TYPE;
		if (userInput.isEmpty()) return ValidationMessage.EMPTY_TYPE;
		if (userInput.equals("0")) return ValidationMessage.ZERO_TYPE;
		if (userInput.length() < GameRule.GAME_NUMBER_LEN.getValue()) return ValidationMessage.UNDER_THREE;
		if (userInput.length() > GameRule.GAME_NUMBER_LEN.getValue()) return ValidationMessage.OVER_THREE;
		if (isDuplicateUserInput(userInput)) return ValidationMessage.NOT_DUPLICATE_NUMBER;
		try {
			Integer.valueOf(userInput);
		} catch (NumberFormatException e) {
			return ValidationMessage.NOT_NUMBER;
		}
		return ValidationMessage.PROPER_TYPE;
	}

	private boolean isDuplicateUserInput(String userInput) {
		String[] arrUserInput = userInput.split("");
		Set<String> userInputSet = new HashSet<>();
		for (String userInputNum : arrUserInput) {
			userInputSet.add(userInputNum);
		}
		return (arrUserInput.length != userInputSet.size());
	}

	public String operateGame(List<Integer> computerBaseballGameNumberList, String inputGameNumber) {
		this.playerGameNumberList = generateGameNumberList(inputGameNumber);
		Integer[] gameResult = ComputerBaseballService.getInstance().getGameResult(computerBaseballGameNumberList);
		printGameResult(gameResult);
		if (gameResult[1] == GameRule.GAME_NUMBER_LEN.getValue()) {
			return strikeProcess();
		}
		return "1"; // 게임 계속 진행
	}

	public List<Integer> generateGameNumberList(String playerInputGameNumber) {
		String[] arrPlayerInputGameNumber = playerInputGameNumber.split("");
		List<Integer> playerInputList = new ArrayList<>();
		for (String playerInputNum : arrPlayerInputGameNumber) {
			playerInputList.add(Integer.parseInt(playerInputNum));
		}
		return playerInputList;
	}

	public List<Integer> getPlayerGameNumberList() {
		return playerGameNumberList;
	}


	private String strikeProcess() {
		System.out.println(String.valueOf(GameRule.GAME_NUMBER_LEN.getValue()) + UserInterfaceMessage.GAME_RESULT_SUCCESS.getValue());
		System.out.println(UserInterfaceMessage.GAME_END_RESTART.getValue());
		String inputGameNumber = readLine();
		System.out.println(inputGameNumber);
		if (inputGameNumber.equals("1")) {
			ComputerBaseballService.getInstance().createNewBaseballGameNumberList();
		}
		return inputGameNumber;
	}

	private void printGameResult(Integer[] gameResultArray) {
		System.out.println(gameResultArray2String(gameResultArray));
	}

	private String gameResultArray2String(Integer[] gameResultArray) {
		if (gameResultArray[0] != 0 && gameResultArray[1] != 0) { // 볼 & 스트라이크
			return String.valueOf(gameResultArray[0]) + UserInterfaceMessage.GAME_RESULT_BALL.getValue() + " "
					+ String.valueOf(gameResultArray[1]) + UserInterfaceMessage.GAME_RESULT_STRIKE.getValue();
		}
		if (gameResultArray[0] != 0 && gameResultArray[1] == 0) { // 볼
			return String.valueOf(gameResultArray[0]) + UserInterfaceMessage.GAME_RESULT_BALL.getValue();
		}
		if (gameResultArray[0] == 0 && gameResultArray[1] != 0) { // 스트라이크
			return String.valueOf(gameResultArray[1]) + UserInterfaceMessage.GAME_RESULT_STRIKE.getValue();
		}

		return UserInterfaceMessage.GAME_RESULT_NOTHING.getValue(); // if (gameResultArray[0] == 0 && gameResultArray[1] == 0)
	}


	public void printGameStartMessage() {
		System.out.println(UserInterfaceMessage.GAME_INFO.getValue());
	}
}
