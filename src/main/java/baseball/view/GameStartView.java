package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.exception.UserNumberInputException;
import baseball.util.StringParseRelatedUtil;
import camp.nextstep.edu.missionutils.Console;

public class GameStartView {
	private List<Integer> userNumber = new ArrayList<>();
	private UserNumberInputException inputException = new UserNumberInputException();
	private StringParseRelatedUtil parseUtil = new StringParseRelatedUtil();
	private String inputedNumber;

	public List<Integer> setUserNumber() {
		printToInputNum();
		requestInputNumber();
		checkException(inputedNumber);
		setList(inputedNumber);

		return userNumber;
	}

	public void printToInputNum() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void requestInputNumber() {
		inputedNumber = Console.readLine();
	}

	public void checkException(String inputedNumber) {
		inputException.checkException(inputedNumber);
	}

	public void setList(String inputedNumber) {
		userNumber = parseUtil.addListToInteger(inputedNumber);
	}

	public void printStartMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
}
