package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		// 게임 시작 문구 출력
		System.out.println("숫자 야구 게임을 시작합니다.");
		// TODO: 프로그램 구현
		while (true) {
			boolean gameIsWon = false;
			List<Integer> opponentNumbers = checkForDuplicateDigitsInRandomNumber();
			// System.out.println(opponentNumbers);

			while (true) {
				String playerNumber = InputPlayerNum();
				boolean playerGuess = checkPlayerNumber(playerNumber);
				List<Integer> playerNumbers = stringToList(playerNumber);
				int[] compareList = countStrikesAndBalls(opponentNumbers, playerNumbers);
				String gameResult = displayGameResult(compareList);
				System.out.println(gameResult);
				if (compareList[0] == 3) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					gameIsWon = true;
					break;
				}
			}

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String endingNum = InputPlayerNum();

			if (endingNum.equals("2")) {
				break;
			}
		}

	}

	// 상대방(컴퓨터) 숫자 생성
	private static List<Integer> checkForDuplicateDigitsInRandomNumber() {
		List<Integer> nonDuplicateDigitsArray = new ArrayList<>();

		while (nonDuplicateDigitsArray.size() < 3) {
			int noDuplicateDigits = Randoms.pickNumberInRange(1, 9);
			if (!nonDuplicateDigitsArray.contains(noDuplicateDigits)) {
				nonDuplicateDigitsArray.add(noDuplicateDigits);
			}
		}

		return nonDuplicateDigitsArray;
	}

	// 숫자 입력 받기
	private static String InputPlayerNum() {
		System.out.println("숫자를 입력해 주세요");
		String InputNum = Console.readLine();
		return InputNum;

	}

	// 입력받은 숫자를 리스트로 만들기
	private static List<Integer> stringToList(String playerNum) {
		List<Integer> Nums = new ArrayList<>();
		for (int i = 0; i < playerNum.length(); i++) {
			char digit = playerNum.charAt(i);
			int digitToInt = (int)(digit - '0');
			Nums.add(digitToInt);
		}
		return Nums;
	}

	// 플레이어의 숫자 확인(숫자길이, 숫자로만 이루어져 있는지, 중복된 숫자는 없는지)
	private static boolean checkPlayerNumber(String playerNum) {
		boolean flag = true;
		if (!checkPlayerNumberLength(playerNum)) {
			System.out.println("3자리의 숫자만 입력해주세요.");
			throw new IllegalArgumentException();
		}
		if (!checkPlayerNumberIsNumber(playerNum)) {
			System.out.println("입력하신 숫자 중 숫자가 아닌 문자가 있습니다.");
			throw new IllegalArgumentException();
		}
		if (!checkPlayerNumberDulplicate(playerNum)) {
			System.out.println("입력하신 숫자 중 중복된 숫자가 있습니다.");
			throw new IllegalArgumentException();
		}

		return flag;

	}

	// 플레이어 숫자의 길이가 3인지 확인
	private static boolean checkPlayerNumberLength(String playerNum) {
		boolean flag = false;
		if (playerNum.length() == 3) {
			flag = true;
		}
		return flag;
	}

	// 플레이어의 숫자에 중복된 숫자가 없는지 확인
	private static boolean checkPlayerNumberDulplicate(String playerNum) {
		boolean findFlag = findDuplicates(playerNum);
		boolean flag = false;
		if (findFlag) {
			flag = true;
		}

		return flag;

	}

	// 중복을 찾기 위해서 숫자를 확인
	private static boolean findDuplicates(String playerNum) {
		boolean flag = true;
		HashSet<Character> uniqueDigits = new HashSet<>();
		for (int i = 0; i < playerNum.length(); i++) {
			char digit = playerNum.charAt(i);
			if (!uniqueDigits.contains(digit)) {
				uniqueDigits.add(digit);
			}
		}
		if (uniqueDigits.size() != 3) {
			flag = false;
		}
		return flag;
	}

	// 플레이어의 숫자가 숫자로만 이루어져 있는지 확인
	private static boolean checkPlayerNumberIsNumber(String playerNum) {
		boolean flag = false;
		try {
			int check = Integer.parseInt(playerNum);
		} catch (NumberFormatException e) {
			return flag;
		}
		flag = true;
		return flag;
	}

	// 숫자를 대조해서 스트라이크와 볼의 개수를 파악
	private static int[] countStrikesAndBalls(List<Integer> opponentNums, List<Integer> playerNums) {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < 3; i++) {
			if (playerNums.get(i).equals(opponentNums.get(i))) {
				strikeCount++;
			} else if (opponentNums.contains(playerNums.get(i))) {
				ballCount++;
			}
		}
		return new int[] {strikeCount, ballCount};
	}

	// 볼과 스트라이크 결과를 출력하고 둘 다 없으면 낫싱 출력
	private static String displayGameResult(int[] compareList) {
		int strikeScore = compareList[0];
		int ballScore = compareList[1];
		String gameResult = "";

		if (strikeScore > 0 && ballScore > 0) {
			gameResult = ballScore + "볼 " + strikeScore + "스트라이크";
		} else if (strikeScore == 0 && ballScore > 0) {
			gameResult = ballScore + "볼";
		} else if (strikeScore > 0 && ballScore == 0) {
			gameResult = strikeScore + "스트라이크";
		} else if (strikeScore == 0 && ballScore == 0) {
			gameResult = "낫싱";
		}
		return gameResult;
	}
}
