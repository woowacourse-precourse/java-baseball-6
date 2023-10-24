package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static void main(String[] args) {

		System.out.println("숫자 야구 게임을 시작합니다.");

		int restart = 1;

		while (restart == 1) {

			List<Integer> computer = new ArrayList<>();
			while (computer.size() < 3) {
				int randomNumber = Randoms.pickNumberInRange(1, 9);
				if (!computer.contains(randomNumber)) {
					computer.add(randomNumber);
				}
			}

			System.out.println(computer); // 컴퓨터가 무슨숫자 등록했는지 테스트

			int firstNumber = computer.get(0);
			int secondNumber = computer.get(1);
			int thirdNumber = computer.get(2);

			char first = Integer.toString(firstNumber).charAt(0);
			char second = Integer.toString(secondNumber).charAt(0);
			char third = Integer.toString(thirdNumber).charAt(0);

			while (true) {

				int strike = 0;
				int ball = 0;
				String myNumber = inputNumber();

				if (first == myNumber.charAt(0)) {
					strike++;
				}

				if (second == myNumber.charAt(1)) {
					strike++;
				}

				if (third == myNumber.charAt(2)) {
					strike++;
				}

				if (first == myNumber.charAt(1)) {
					ball++;
				}

				if (first == myNumber.charAt(2)) {
					ball++;
				}

				if (second == myNumber.charAt(0)) {
					ball++;
				}

				if (second == myNumber.charAt(2)) {
					ball++;
				}

				if (third == myNumber.charAt(0)) {
					ball++;
				}

				if (third == myNumber.charAt(1)) {
					ball++;
				}

				if (strike == 3) {
					System.out.println("3스트라이크");
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
					restart = Integer.parseInt(Console.readLine());

					if (restart == 2) {
						break;
					} else if (restart != 1 && restart != 2)
						throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
					{

					}
					break;
				}

				if (strike == 0 & ball == 0) {
					System.out.println("낫싱");
				}

				else {
					System.out.println(ball + "볼 " + strike + "스트라이크");
				}

			}
		}

	}

	private static String inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String myNumber = Console.readLine();
		if (myNumber.length() != 3 || myNumber.charAt(0) == myNumber.charAt(1)
				|| myNumber.charAt(0) == myNumber.charAt(2) || myNumber.charAt(1) == myNumber.charAt(2)
				|| myNumber.charAt(0) == '0' || myNumber.charAt(1) == '0' || myNumber.charAt(2) == '0') {
			throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
		}
		return myNumber;
	}

}
