package baseball.view;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_DECISION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String RESTART = "1";
	private static final String END = "2";

	public List<Integer> createPlayerNumber() {
		System.out.println(NUMBER_INPUT_MESSAGE);
		String input = Console.readLine();
		return input.chars()
			.mapToObj(Character::getNumericValue)
			.collect(Collectors.toList());
	}

	public String decideRestart() {
		System.out.println(RESTART_DECISION_MESSAGE);
		String input = Console.readLine();
		if(!input.equals(RESTART) && !input.equals(END)) {
			throw new IllegalArgumentException("잘못된 재시작 여부 입력값입니다");
		}
		return input;
	}
}
