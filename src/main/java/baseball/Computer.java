package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 숫자를 임의로 선택하고 채점하는 Computer 클래스입니다.
final public class Computer {
	private final int size;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private List<Integer> numbers;
	private boolean[] selectedNumbers;

	public Computer(int size) {
		if (size < MIN_NUMBER || size > MAX_NUMBER) {
			throw new IllegalArgumentException("1자리에서 9자리의 숫자를 생성할 수 있습니다.");
		}
		this.size = size;

		selectGameNumbers();
	}

	// 이미 고른 숫자인 경우 아무 작업을 하지 않고, 고르지 않은 숫자인 경우 숫자를 선택합니다.
	private void selectNumber(int number) {
		if (!selectedNumbers[number]) {
			numbers.add(number);
			selectedNumbers[number] = true;
		}
	}

	// size 자리의 숫자를 임의로 선택합니다.
	public void selectGameNumbers() {
		numbers = new ArrayList<>();
		selectedNumbers = new boolean[10];
		while (numbers.size() < size) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			selectNumber(randomNumber);
		}
	}

	private boolean isLegalInput(String input) {
		// 입력한 답과 정답의 길이가 다른 경우
		if (input.length() != size) {
			return false;
		}

		boolean[] numbersInInput = new boolean[10];
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// 1에서 9까지의 숫자 이외의 값을 입력한 경우
			if (!(ch >= MIN_NUMBER + '0' && ch <= MAX_NUMBER + '0')) {
				return false;
			}

			int num = Character.getNumericValue(ch);
			// 같은 수를 2번 이상 입력한 경우
			if (numbersInInput[num]) {
				return false;
			}
			numbersInInput[num] = true;
		}
		return true;
	}

	// 입력한 문자열 중 한 글자가 스트라이크인지 볼인지 판단하여 스트라이크와 볼 값을 업데이트하는 함수
	// 글자가 컴퓨터가 생성한 문자열과 같은 위치에 같은 값이면 스트라이크의 값을 증가
	// 글자가 컴퓨터가 생성한 문자열과 같은 위치에 있지 않지만 다른 위치에 존재하면 볼의 값을 증가
	private int[] updateStrikeBall(int currentStrike, int currentBall, int num, int computerValue,
		boolean isNumberInComputer) {
		int strike = currentStrike;
		int ball = currentBall;
		if (num == computerValue) {
			strike += 1;
		} else if (isNumberInComputer) {
			ball += 1;
		}
		return new int[] {strike, ball};
	}

	// 스트라이크, 볼의 개수를 구하는 함수
	private int[] getStrikeBall(String input, List<Integer> computer, boolean[] numbersInComputer) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < input.length(); i++) {
			int num = Character.getNumericValue(input.charAt(i));
			int[] result = updateStrikeBall(strike, ball, num, computer.get(i), numbersInComputer[num]);
			strike = result[0];
			ball = result[1];
		}
		return new int[] {strike, ball};
	}

	// 입력이 정답인지 아닌지 판단하는 함수
	public boolean gradeInput(String input) {
		// 입력이 올바르지 않은 경우
		if (!isLegalInput(input)) {
			throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 " + size + "개를 공백 없이 입력하세요.");
		}
		// 입력이 올바른 경우
		int[] result = getStrikeBall(input, numbers, selectedNumbers);
		int strike = result[0];
		int ball = result[1];

		// 입력이 정답인 경우
		if (strike == size) {
			System.out.printf("%d스트라이크\n", strike);
			System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", size);
			return true;
		}

		// 입력이 오답인 경우
		if (strike > 0 && ball > 0) {
			System.out.printf("%d볼 %d스트라이크\n", ball, strike);
		} else if (strike > 0 && ball == 0) {
			System.out.printf("%d스트라이크\n", strike);
		} else if (ball > 0) {
			System.out.printf("%d볼\n", ball);
		} else {
			System.out.println("낫싱");
		}
		return false;
	}
}
