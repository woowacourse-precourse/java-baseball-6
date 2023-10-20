package baseball;

import java.util.List;

public class GameStart {

	public void gameStart() {

		System.out.println("숫자 야구 게임을 시작합니다.");

		ComputerNumber computer = new ComputerNumber();
		UserNumber user = new UserNumber();
		CalculateResult calculate = new CalculateResult();
		PrintResult print = new PrintResult();
		Restart restart = new Restart();

		boolean again = true;
		while (again) {
			List<Integer> computerNumbers = computer.computerNumbers();
			while (true) {
				List<Integer> userNumbers = user.userNumbers();
				int[] result = calculate.compare(computerNumbers, userNumbers);
				print.print(result);

				if (result[0] == 0 && result[1] == 3) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					break;
				}
			}
			again = restart.restart();
		}

	}

}
