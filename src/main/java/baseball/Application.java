package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	static int SIZE = 3;

	public static void main(String[] args) {
		// 게임 시작 문구를 출력
		System.out.println("숫자 야구 게임을 시작합니다.");
		Game:
		while (true) {
			boolean[] numbersInComputer = new boolean[10];
			// 서로 다른 임의의 수 3개 선택
			List<Integer> computer = new ArrayList<>();
			while (computer.size() < SIZE) {
				int randomNumber = Randoms.pickNumberInRange(1, 9);
				if (!numbersInComputer[randomNumber]) {
					computer.add(randomNumber);
					numbersInComputer[randomNumber] = true;
				}
			}
			while (true) {
				// 3자리 수를 입력 받음
				System.out.print("숫자를 입력해주세요 : ");
				String input = Console.readLine();
				// 입력이 올바른 경우
				if (isLegalInput(input)) {
					int[] result = getStrikeBall(input, computer, numbersInComputer);
					int strike = result[0];
					int ball = result[1];
					if (strike == SIZE) {
						System.out.printf("%d스트라이크\n", strike);
						System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", SIZE);
						System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
						String choice = Console.readLine();
						if (isLegalChoice(choice)) {
							if (choice.equals("1")) {
								break;
							}
							break Game;
						}
						throw new IllegalArgumentException("1또는 2를 입력하세요.");
					}

					if (strike > 0) {
						if (ball > 0) {
							System.out.printf("%d볼 %d스트라이크\n", ball, strike);
						} else {
							System.out.printf("%d스트라이크\n", strike);
						}
					} else {
						if (ball > 0) {
							System.out.printf("%d볼\n", ball);
						} else {
							System.out.println("낫싱");
						}
					}
					continue;
				}
				// 입력이 올바르지 않은 경우
				throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 " + SIZE + "개를 공백 없이 입력하세요.");
			}
		}
	}

	static boolean isLegalInput(String input) {
		if (input.length() != SIZE) {
			return false;
		}
		boolean[] numbersInInput = new boolean[10];
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			// 1에서 9까지의 숫자 이외의 값을 입력한 경우
			if (!('0' < ch && ch <= '9')) {
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

	static int[] updateStrikeBall(int currentStrike, int currentBall, int num, int computerValue,
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

	static int[] getStrikeBall(String input, List<Integer> computer, boolean[] numbersInComputer) {
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

	static boolean isLegalChoice(String choice) {
		if (choice.equals("1")) {
			return true;
		} else if (choice.equals("2")) {
			return true;
		}
		// 1, 2 이외의 값을 입력한 경우
		return false;
	}
}
