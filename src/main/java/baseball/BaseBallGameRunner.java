package baseball;

import baseball.domain.computer.Computer;
import baseball.domain.computer.ComputerFactory;
import baseball.domain.user.User;
import baseball.domain.user.UserInputQuery;
import camp.nextstep.edu.missionutils.Console;

class BaseBallGameRunner {

	public static void run(){
		final Computer computer = ComputerFactory.getInstance(3);
		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			String numbers = Console.readLine();
			final UserInputQuery userInputQuery = new UserInputQuery(numbers);
			final User user = userInputQuery.toDomain(computer);
			final String result = user.result();
			System.out.println(result);
			if (result.equals("3스트라이크")) {
				break;
			}
		}
	}

}
