package baseball;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private Ball[] balls;

	public Player() {
	}

	public void getInput() {
		System.out.println("숫자를 입력해주세요 : ");
		String input = Console.readLine();

		if (!isCorrectInput(input)) {
			throw new IllegalArgumentException("잘못된 입력값입니다. 세 자리의 숫자를 입력하세요.");
		}

		balls = new Ball[3];
		for (int i = 0; i < 3; i++) {
			balls[i] = new Ball(Character.getNumericValue(input.charAt(i)));
		}

	}

	public Ball[] getBalls() {
		return balls;
	}

	private boolean isCorrectInput(String input) {
		Pattern pattern = Pattern.compile("^(?!.*(.).*\\1)[1-9]{3}$");
		Matcher matcher = pattern.matcher(input);

		return matcher.matches();
	}

}
