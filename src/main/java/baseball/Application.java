package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
	public static void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");
		Game rightAnswer = new Game();
		Game.init(rightAnswer);
	}
}

class Array {
	static boolean checkArrayContains(final int[] arr, final int number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	static boolean checkArrayContains(final char[] arr, final char number) {
		for (int value : arr) {
			if (value == number) {
				return true;
			}
		}
		return false;
	}

	static char[] getCharArrayFromString(String str) {
		char[] charArray = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);
		}

		return charArray;
	}

	static int getIndexFromValue(final int[] arr, final int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
}

class Game {
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 9;
	static final int NUMBER_COUNT = 3;
	private static final int NEW_GAME = 1;
	private static final int QUIT_GAME = 2;

	private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String SUCCESS_MESSAGE = Game.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + Game.NEW_GAME + ", 종료하려면 " + Game.QUIT_GAME + "를 입력하세요.";

	int[] number = new int[NUMBER_COUNT];

	Game() {
		int nowRandomNum;
		int nowNumberIndex = 0;

		while (nowNumberIndex < NUMBER_COUNT) {
			nowRandomNum = this.getRandomNumber();

			if (!Array.checkArrayContains(number, nowRandomNum)) {
				number[nowNumberIndex++] = nowRandomNum;
			}
		}
	}

	Game(String str) {
		for (int i = 0; i < Game.NUMBER_COUNT; i++) {
			number[i] = Integer.parseInt(str.charAt(i) + "");
		}
	}

	private int getRandomNumber() {
		return pickNumberInRange(Game.START_RANGE, Game.END_RANGE);
	}

	public static void init(Game rightAnswer) {
		Game answer = Game.getAnswer();

		Hint hint = new Hint();
		hint.compareAnswer(answer, rightAnswer);
		hint.showResult();

		if (hint.strike != Game.NUMBER_COUNT) {
			Game.init(rightAnswer);
			return;
		}

		int newGameAnswer = Game.checkNewGameStart();
		if (newGameAnswer == Game.NEW_GAME) {
			rightAnswer = new Game();
			Game.init(rightAnswer);
		}
	}

	private static Game getAnswer() {
		System.out.print(GET_NUMBER_MESSAGE);
		String userInput = readLine();
		Game.checkInputValue(userInput);

		return new Game(userInput);
	}

	private static int checkNewGameStart() {
		System.out.println(SUCCESS_MESSAGE);
		System.out.println(NEW_GAME_CHECK_MESSAGE);

		String newGameAnswer = readLine();
		return Game.getNewGameAnswerNumber(newGameAnswer);
	}

	private static int getNewGameAnswerNumber(String str) {
		int intValue;
		try {
			intValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		if (intValue != 1 && intValue != 2) {
			throw new IllegalArgumentException();
		}

		return intValue;
	}

	public String toString() {
		return "number: " + this.number[0] + this.number[1] + this.number[2];
	}

	static void checkInputValue(final String str) {
		if (!Game.checkInputLength(str)) {
			throw new IllegalArgumentException();
		}
		if (!Game.checkInputNumber(str)) {
			throw new IllegalArgumentException();
		}
		if (!Game.checkEqualNumber(str)) {
			throw new IllegalArgumentException();
		}
	}

	static boolean checkInputLength(final String str) {
		return str.length() == Game.NUMBER_COUNT;
	}

	static boolean checkInputNumber(String str) {
		try {
			int numberValue = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		char[] numberArray = Array.getCharArrayFromString(str);
		return !Array.checkArrayContains(numberArray, '0');
	}

	static boolean checkEqualNumber(String str) {
		char[] checkEqual = new char[str.length()];
		char[] word = Array.getCharArrayFromString(str);

		for (int i = 0; i < str.length(); i++) {
			if (Array.checkArrayContains(checkEqual, word[i])) {
				return false;
			}
			checkEqual[i] = word[i];
		}

		return true;
	}
}

class Hint {
	int ball, strike;

	private static final String BALL_WORD = "볼";
	private static final String STRIKE_WORD = "스트라이크";
	private static final String NOT_MATCH_WORD = "낫싱";

	public String toString() {
		return "ball: " + this.ball + ", strike: " + this.strike;
	}

	private void addBallCount() {
		this.ball++;
	}

	private void addStrikeCount() {
		this.strike++;
	}

	void compareAnswer(Game answer, Game rightAnswer) {
		int nowNumber;

		for (int i = 0; i < Game.NUMBER_COUNT; i++) {
			nowNumber = answer.number[i];

			if (!Array.checkArrayContains(rightAnswer.number, nowNumber)) {
				continue;
			}
			if (i == Array.getIndexFromValue(rightAnswer.number, nowNumber)) {
				addStrikeCount();
				continue;
			}

			addBallCount();
		}
	}

	void showResult() {
		String result = "";
		if (this.ball != 0) {
			result += this.ball + BALL_WORD;
		}

		if (this.strike != 0) {
			if (this.ball != 0) {
				result += " ";
			}
			result += this.strike + STRIKE_WORD;
		}

		if (result.equals("")) {
			result = NOT_MATCH_WORD;
		}

		System.out.println(result);
	}
}