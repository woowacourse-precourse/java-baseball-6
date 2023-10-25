package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	// TODO: 프로그램 구현
	private static final int NUMBER_LENGTH = 3;
	
	public static void main(String[] args) {
		GameStart();
	}

	private static void GameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		playGame();
	}

	private static void playGame() {
		List<Integer> opponentNumbers = generateOpponentNumbers();
		playingGame(opponentNumbers);
	}

	private static List<Integer> generateOpponentNumbers() {
		List<Integer> nonDuplicateDigitsArray = new ArrayList<>();
		while (nonDuplicateDigitsArray.size() < NUMBER_LENGTH) {
			int noDuplicateDigits = Randoms.pickNumberInRange(1, 9);
			if (!nonDuplicateDigitsArray.contains(noDuplicateDigits)) {
				nonDuplicateDigitsArray.add(noDuplicateDigits);
			}
		}
		return nonDuplicateDigitsArray;
	}

	private static void playingGame(List<Integer> opponentNumbers) {
		List<Integer> playerNumbers = InputPlayerNum();
		countStrikesAndBalls(opponentNumbers, playerNumbers);
	}

	private static List<Integer> InputPlayerNum() {
		System.out.println("숫자를 입력해 주세요");
		String inputNum = Console.readLine();
		List<Integer> playerNumbers = checkPlayerNumber(inputNum);
		return playerNumbers;
	}

	private static List<Integer> checkPlayerNumber(String playerNum) {
		requireValidLength(playerNum);
		requireAllDigits(playerNum);
		List<Integer> playerNumbers = stringToList(playerNum);
		requireNoDuplicates(playerNumbers);
		return playerNumbers;
	}

	private static void requireValidLength(String playerNum) {
		if (playerNum.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException("3자리의 숫자만 입력해주세요.");
		}
	}

	private static void requireAllDigits(String playerNum) {
		if (!playerNum.matches("\\d+")) {
			throw new IllegalArgumentException("입력하신 숫자 중 숫자가 아닌 문자가 있습니다.");
		}
	}

	private static void requireNoDuplicates(List<Integer> playerNumbers) {
		if (new HashSet<>(playerNumbers).size() != NUMBER_LENGTH) {
			throw new IllegalArgumentException("입력하신 숫자 중 중복된 숫자가 있습니다.");
		}
	}

	private static List<Integer> stringToList(String playerNum) {
		List<Integer> playerNumbers = new ArrayList<>();
		for (char digit : playerNum.toCharArray()) {
			playerNumbers.add(Character.getNumericValue(digit));
		}
		return playerNumbers;
	}

	private static void countStrikesAndBalls(List<Integer> opponentNumbers, List<Integer> playerNumbers) {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (Objects.equals(playerNumbers.get(i), opponentNumbers.get(i))) {
				strikeCount++;
			} else if (opponentNumbers.contains(playerNumbers.get(i))) {
				ballCount++;
			}
		}
		int[] compareList = {strikeCount, ballCount};
		displayGameResult(compareList, opponentNumbers);
	}

	private static void displayGameResult(int[] compareList, List<Integer> opponentNumbers) {
		int strikeScore = compareList[0];
		int ballScore = compareList[1];
		String gameResult = "";

		if (strikeScore > 0 && ballScore > 0) {
			gameResult = String.format("%d볼 %d스트라이크", ballScore, strikeScore);
		} else if (strikeScore == 0 && ballScore > 0) {
			gameResult = String.format("%d볼", ballScore);
		} else if (strikeScore > 0 && ballScore == 0) {
			gameResult = String.format("%d스트라이크", strikeScore);
		} else if (strikeScore == 0 && ballScore == 0) {
			gameResult = "낫싱";
		}
		System.out.println(gameResult);
		endGame(strikeScore, opponentNumbers);
	}

	private static void endGame(int strikeCount, List<Integer> opponentNumbers) {
		if (strikeCount == NUMBER_LENGTH) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			selectGame();
		} else {
			playingGame(opponentNumbers);
		}
	}

	private static void selectGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String endingNum = Console.readLine();
		if ("1".equals(endingNum)) {
			playGame();
		}
	}
}


