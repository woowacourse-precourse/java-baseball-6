package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class UserNumInputManager {
	static ExceptionHandler exceptionHandler = new ExceptionHandler();
	static List<String> userInputNumList = new ArrayList<>();
	static String userInputNumber;
	static String inputNum_1;
	static String inputNum_2;
	static String inputNum_3;
	public static void inputUserNum() {

		userInputNumList.clear();
		System.out.print("숫자를 입력해주세요 : ");
		userInputNumber = Console.readLine();

		inputNum_1 = userInputNumber.substring(0, 1);
		inputNum_2 = userInputNumber.substring(1, 2);
		inputNum_3 = userInputNumber.substring(2, 3);

		exceptionHandler.cautionLength(userInputNumber);
		exceptionHandler.cautionDuplicate(inputNum_1, inputNum_2, inputNum_3);
		exceptionHandler.cautionNotNumber(inputNum_1, inputNum_2, inputNum_3);

		userInputNumList.add(inputNum_1);
		userInputNumList.add(inputNum_2);
		userInputNumList.add(inputNum_3);

	}

	public List<String> getUserInputNumList() {
		return userInputNumList;
	}
}
		
